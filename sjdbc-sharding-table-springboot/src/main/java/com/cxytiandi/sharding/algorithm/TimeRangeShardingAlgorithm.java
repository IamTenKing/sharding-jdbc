package com.cxytiandi.sharding.algorithm;

import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * 范围查询,仅支持月份
 * @author jt
 * @date 2020-5-4
 */
public class TimeRangeShardingAlgorithm implements RangeShardingAlgorithm<Date> {



    private DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyyMM");
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> shardingValue) {
        Collection<String> result = new LinkedHashSet<String>();
        Range<Date> shardingKey = shardingValue.getValueRange();
        Date date = shardingKey.lowerEndpoint();
        Date date1 = shardingKey.upperEndpoint();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        String format1 = format.format(date);
        String format2 = format.format(date1);
        int start = Integer.valueOf(format1);
        int end = Integer.valueOf(format2);
        while(start <= end){
            StringBuffer tableName = new StringBuffer();
            tableName.append(shardingValue.getLogicTableName())
                    .append("_").append(start);
            result.add(tableName.toString());
            start++;
        }
        return result;
    }
}
