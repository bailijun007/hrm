package com.ihrm.company.service;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.company.dao.CompanyDao;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
   private CompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;
/*
* 保存企业
* 1.配置idworker 到工程
* 2.注入idworker到service
* 3.通过idworker生成id
* 4.保存企业
* */
public void save(Company company){
    String id=idWorker.nextId()+"";
    //设置默认值
    company.setId(id);
    company.setAuditState("0");//0:未审核  1：已审核
    company.setState(1);//0未激活  1已激活
    companyDao.save(company);
}

/*
* 更新企业
* */
public void update(Company company){
    Company company1 = companyDao.findById(company.getId()).get();
    company1.setName(company.getName());
    company1.setCompanyPhone(company.getCompanyPhone());
    companyDao.save(company1);
}

/*
* 根据id删除企业
* */
public void deleteById(String id){
     companyDao.deleteById(id);
}

    /*
     * 根据id查询企业
     * */
public Company findCompanyById(String id){
    Company company = companyDao.findById(id).get();
    return company;
}

    /*
     * 查询全部企业
     * */
    public List<Company> findAll(){
        List<Company> list = companyDao.findAll();
        return  list;
    }


}
