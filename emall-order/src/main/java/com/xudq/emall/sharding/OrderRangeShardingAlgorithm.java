package com.xudq.emall.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;

/**
 * @author ：
 * @date ：
 * @version: V1.0
 * @description: 分表范围查询,支持between and < > <= >= in 查询
 * 只支持单分片字段条件路由，不支持多分片字段
 * @notice: <strong>分库算法设置与此类似,dosharding传入的collection就是所有库的集合<strong/>
 **/
@Slf4j
public class OrderRangeShardingAlgorithm implements RangeShardingAlgorithm {
    @Override
    public Collection<String> doSharding(Collection collection, RangeShardingValue rangeShardingValue) {
        // 真实节点
        collection.stream().forEach((item)->{
            log.info("actual node table:{}",item);
        });

        log.info("logic table name:{},rout column:{}",rangeShardingValue.getLogicTableName(),rangeShardingValue.getColumnName());

        //区间分片
        log.info("range:{}",rangeShardingValue.getValueRange());

        return null; //返回你要路由的表的集合
    }
}
