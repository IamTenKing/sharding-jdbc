package com.cxytiandi.sharding.controller;

import com.cxytiandi.sharding.dto.UserDTO;
import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.service.LouDongService;
import com.cxytiandi.sharding.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private LouDongService louDongService;
	
	@GetMapping("/users")
	public Object list() {
		return userService.list();
	}
	
	@PostMapping("/add")
	@Transactional
	public Object add(@RequestBody User user) {

//		Snowflake snowflake = IdUtil.createSnowflake(1, 1);
//		long l = snowflake.nextId();
//		user.setId(l);
//		userService.add(user);
//		user.setCreateTime(new Date());
		Date createTime = user.getCreateTime();
		//调用通用mapper的insert方法,无法使用sharding jdbc的生成id
		userService.add1(user);
//		for (long i = 0; i < 100; i++) {
//			User user = new User();
//			user.setId(i);
//			user.setCity("深圳");
//			user.setName("李四");
//			userService.add(user);
//		}
//		LouDong louDong = new LouDong();
//		louDong.setCity("test");
//		louDongService.addLouDong(louDong);
//		int i = 1/0;
		return "success";
	}
	
	@GetMapping("/users/{id}")
	public Object get(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@GetMapping("/users/query")
	public Object get(String name) {
		return userService.findByName(name);
	}


	@GetMapping("/user/page")
	public Object page() {
		return userService.listPage();
	}

	/*
	测试范围路由
	http://localhost:8084//user/range?start=20200401&end=20200530
	只会路由到两张表，而不会全路由
	 */

	@GetMapping("/user/range")
	public List<UserDTO> pageRange(@RequestParam("start")String start, @RequestParam("end")String end) {
		return userService.listRange(start,end);
	}



}
