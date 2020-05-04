package com.cxytiandi.sharding.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cxytiandi.sharding.dto.UserDTO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cxytiandi.sharding.po.User;
import com.cxytiandi.sharding.repository.UserRepository;

import javax.swing.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> list() {
		List<User> list = userRepository.list();
		ArrayList<UserDTO> users = Lists.newArrayList();
		for (User user : list) {
			UserDTO userDTO = new UserDTO();
			userDTO.setCity(user.getCity());
			userDTO.setId(user.getId());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			userDTO.setCreateTime(format.format(user.getCreateTime()));
			userDTO.setName(user.getName());
			users.add(userDTO);
		}

		int currentPage = 1;
		int pageSize = 5;
		String orderBy = "id desc";
		List<User> users1 = userRepository.selectAll();
		PageInfo<User> userPageInfo = new PageInfo<>(users1);
		PageHelper.startPage(currentPage, pageSize, orderBy);

		return users;
	}

	public PageInfo<UserDTO> listPage() {


		int currentPage = 1;
		int pageSize = 5;
		String orderBy = "id desc";
		List<User> users1 = userRepository.selectAll();
		ArrayList<UserDTO> users = Lists.newArrayList();
		for (User user : users1) {
			UserDTO userDTO = new UserDTO();
			userDTO.setCity(user.getCity());
			userDTO.setId(user.getId());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			userDTO.setCreateTime(format.format(user.getCreateTime()));
			userDTO.setName(user.getName());
			users.add(userDTO);
		}
		PageInfo<UserDTO> userPageInfo = new PageInfo<>(users);

		return userPageInfo;
	}

	@Override
	public List<UserDTO> listRange(String start, String end) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			Date startDate = format.parse(start);
			Date endDate = format.parse(end);


			List<UserDTO> users = userRepository.listRange(startDate,endDate);

			return users;

		} catch (ParseException e) {
			e.printStackTrace();
		}


		return null;
	}

	public int add(User user) {
		return  userRepository.insert(user);
	}

	public Long add1(User user) {
		return  userRepository.addUser(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByName(String name) {
		return userRepository.findByName(name);
	}

}
