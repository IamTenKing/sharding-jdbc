package com.cxytiandi.sharding.service;

import java.util.List;

import com.cxytiandi.sharding.dto.UserDTO;
import com.cxytiandi.sharding.po.User;
import com.github.pagehelper.PageInfo;

public interface UserService {

	List<UserDTO> list();
	
	int add(User user);
	
	User findById(Long id);
	
	User findByName(String name);
	 Long add1(User user);

	PageInfo<UserDTO> listPage();

	List<UserDTO> listRange(String start, String end);
}
