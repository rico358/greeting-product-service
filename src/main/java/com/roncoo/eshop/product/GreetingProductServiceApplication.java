package com.roncoo.eshop.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.roncoo.eshop.product.mapper")
public class GreetingProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingProductServiceApplication.class, args);
	}

}
