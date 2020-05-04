package com.cxytiandi.sharding.repository;

import java.util.List;
import com.cxytiandi.sharding.po.LouDong;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;


@Component
public interface LouDongRepository extends Mapper<LouDong>, MySqlMapper<LouDong> {
	
	Long addLouDong(LouDong louDong);
	
	List<LouDong> list();
}
