package com.cxytiandi.sharding.algorithm;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * 自定义分片算法
 *
 * 精确路由
 *
 * @author yinjihuan
 *
 */
public class MyPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Date> {


	/**
	 * availableTargetNames:可用的表
	 * Date是分片键的字段类型
	 * @param availableTargetNames
	 * @param shardingValue
	 * @return
	 */
	@Override
	public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {
//		for (String tableName : availableTargetNames) {
//			if (tableName.endsWith(shardingValue.getValue() % 4 + "")) {
//				return tableName;
//			}
//		}
			SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String format1 = format.format(shardingValue.getValue());
		for (String availableTargetName : availableTargetNames) {
			if(availableTargetName.endsWith(format1)){
				return availableTargetName;
			}

		}




		throw new IllegalArgumentException();
	}

}
