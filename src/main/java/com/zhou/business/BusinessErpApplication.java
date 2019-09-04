package com.zhou.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan({"com.zhou.business"})
@EnableTransactionManagement
//@MapperScan(basePackages = {"com.zhou.business.dal"})
@SpringBootApplication
public class BusinessErpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessErpApplication.class, args);
	}

}
