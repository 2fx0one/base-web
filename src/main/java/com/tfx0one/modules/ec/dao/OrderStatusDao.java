package com.tfx0one.modules.ec.dao;

import com.tfx0one.modules.ec.entity.OrderStatusEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单状态表
 * 
 * @author 2fx0one
 * @email 2fx0one@gmail.com
 * @date 2019-07-15 21:31:30
 */
@Mapper
public interface OrderStatusDao extends BaseMapper<OrderStatusEntity> {
	
}