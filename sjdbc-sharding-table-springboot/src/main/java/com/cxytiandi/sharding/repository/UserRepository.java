package com.cxytiandi.sharding.repository;

import java.util.Date;
import java.util.List;


import com.cxytiandi.sharding.dto.UserDTO;
import com.cxytiandi.sharding.po.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface UserRepository  extends Mapper<User>, MySqlMapper<User> {
//
	Long addUser(User user);
	
	List<User> list();
	
	User findById(Long id);
	
	User findByName(String name);

	List<UserDTO> listRange(Date start, Date end);
}
