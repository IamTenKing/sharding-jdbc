package com.cxytiandi.sharding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Spring Boot版 Sharding JDBC 不分库，只分表案例
 * 
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.cxytiandi.sharding.repository"})
public class ShardingTableApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShardingTableApplication.class, args);
	}
}
