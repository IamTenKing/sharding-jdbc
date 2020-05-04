package com.cxytiandi.sharding.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author jt
 * @date 2020-5-4
 */

@Data
public class UserDTO {

    private Long id;

    private String city = "";

    private String name = "";

    private String createTime;

}
