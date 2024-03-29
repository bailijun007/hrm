package com.ihrm.company;

import com.ihrm.common.utils.IdWorker;
import com.ihrm.common.utils.JwtUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

//1.springboot包扫描
@SpringBootApplication(scanBasePackages = "com.ihrm.company")
//2.jpa注解扫描
@EntityScan(value = "com.ihrm.domain.company")
public class CompanyApplication {
/*
* 启动方法
* */
public static void main(String[] args) {
    SpringApplication.run(CompanyApplication.class,args);
}

    @Bean
    public IdWorker idWorker(){
    return new IdWorker();
}
    @Bean
    public JwtUtils jwtUtils(){
        return new JwtUtils();
    }

}
