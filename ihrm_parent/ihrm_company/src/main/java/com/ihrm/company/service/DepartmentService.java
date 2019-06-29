package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.company.dao.DepartmentDao;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
   private DepartmentDao departmentDao;

    @Autowired
    private IdWorker idWorker;
/*
* 保存部门
* 1.配置idworker 到工程
* 2.注入idworker到service
* 3.通过idworker生成id
* 4.保存部门
* */
public void save(Department department){
    String id=idWorker.nextId()+"";
    department.setId(id);
    departmentDao.save(department);
}

/*
* 更新部门
* */
public void update(Department department){
    Department department1 = departmentDao.findById(department.getId()).get();
    department1.setCode(department.getCode());
    department1.setIntroduce(department.getIntroduce());
    department1.setName(department.getName());
    departmentDao.save(department1);

}

/*
* 根据id删除部门
* */
public void deleteById(String id){
    departmentDao.deleteById(id);
}

    /*
     * 根据id查询部门
     * */
public Department findById(String id){
   return departmentDao.findById(id).get();
}

    /*
     * 查询全部部门
     * */
    public List<Department> findAll(String departmentId){
        Specification<Department> specification=new Specification<Department>() {
            @Override
            public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                return cb.equal(root.get("departmentId").as(String.class),departmentId);
            }
        };

     return    departmentDao.findAll(specification);
    }


}
