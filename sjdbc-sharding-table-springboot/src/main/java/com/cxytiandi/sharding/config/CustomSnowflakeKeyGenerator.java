//package com.cxytiandi.sharding.config;
//
//import cn.hutool.core.lang.Snowflake;
//import io.shardingsphere.core.keygen.KeyGenerator;
//import org.springframework.stereotype.Component;
//
///**
// * <p>
// * 自定义雪花算法，替换 DefaultKeyGenerator，避免DefaultKeyGenerator生成的id大几率是偶数
// * </p>
// *
// * @package: com.xkcoding.sharding.jdbc.config
// * @description: 自定义雪花算法，替换 DefaultKeyGenerator，避免DefaultKeyGenerator生成的id大几率是偶数
// * @author: yangkai.shen
// * @date: Created in 2019-03-26 17:07
// * @copyright: Copyright (c) 2019
// * @version: V1.0
// * @modified: yangkai.shen
// */
//
//@Component
//public class CustomSnowflakeKeyGenerator {
//    private Snowflake snowflake;
//
//    public CustomSnowflakeKeyGenerator(Snowflake snowflake) {
//        this.snowflake = snowflake;
//    }
//
//    public Number generateKey() {
//        return snowflake.nextId();
//    }
//}
