package com.swang.distributeddbmiddleware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.swang.distributeddbmiddleware.mapper")
@SpringBootApplication
public class DistributedDbMiddlewareApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedDbMiddlewareApplication.class, args);
	}

}
