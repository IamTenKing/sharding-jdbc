package com.cxytiandi.sharding.po;

import java.io.Serializable;
import java.util.Date;

/**
 * 分表
 * @author yinjihuan
 *
 */

public class User implements Serializable {

	private static final long serialVersionUID = -1205226416664488559L;
	
	private Long id;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	private String city = "";
	
	private String name = "";
	private Date createTime = new Date();



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
