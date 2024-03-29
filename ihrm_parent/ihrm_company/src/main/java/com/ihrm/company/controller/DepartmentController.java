package com.ihrm.company.controller;


import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.company.service.DepartmentService;
import com.ihrm.domain.company.Company;
import com.ihrm.domain.company.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/company")
public class DepartmentController {
    @Autowired
  private   DepartmentService departmentService;

    @Autowired
    private CompanyService companyService;


    //保存
    @RequestMapping(value = "/department",method = RequestMethod.POST)
    public Result save(Department department){
       String companyId="1";
        department.setId(companyId);
        departmentService.save(department);
        return new Result(ResultCode.SUCCESS);
    }

    //查询全部部门
    @RequestMapping(value = "/department",method = RequestMethod.GET)
    public Result findAll(){
        String companyId="1";
        Company company = companyService.findCompanyById(companyId);
        List<Department> list = departmentService.findAll(companyId);
        DeptListResult deptListResult=new DeptListResult(company,list);
        return new Result(ResultCode.SUCCESS,deptListResult);
    }

    //通过id查询部门
    @RequestMapping(value = "/department/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id){
        Department department = departmentService.findById(id);
        return new Result(ResultCode.SUCCESS,department);
    }

    //更新部门
    @RequestMapping(value = "/department/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id,Department department){
        department.setId(id);
        departmentService.update(department);
        return new Result(ResultCode.SUCCESS);
    }

    //删除
    @RequestMapping(value = "/department/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id){
        departmentService.deleteById(id);
        return new Result(ResultCode.SUCCESS);
    }


}
