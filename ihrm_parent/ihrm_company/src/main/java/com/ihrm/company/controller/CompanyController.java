package com.ihrm.company.controller;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.company.service.CompanyService;
import com.ihrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {
@Autowired
private CompanyService companyService;


    //保存
    @RequestMapping(value = "",method = RequestMethod.POST)
    public Result save(@RequestBody Company company){
        companyService.save(company);
        return new Result(ResultCode.SUCCESS);
    }

    //根据id更新企业
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id")String id,@RequestBody Company company){
            company.setId(id);
            companyService.update(company);
            return new Result(ResultCode.SUCCESS);
    }


    //根据id删除企业
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id){
        companyService.deleteById(id);
    return new Result(ResultCode.SUCCESS);
}

    //根据id查询企业
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findCompanyById(@PathVariable(value = "id") String id){
        Company company = companyService.findCompanyById(id);
        return new Result(ResultCode.SUCCESS,company);
    }
    

    //查询所有企业
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result findAll(){
    List<Company> list = companyService.findAll();
    return new Result(ResultCode.SUCCESS,list);

}

}
