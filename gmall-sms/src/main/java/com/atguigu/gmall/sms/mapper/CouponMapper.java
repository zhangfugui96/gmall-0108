package com.atguigu.gmall.sms.mapper;

import com.atguigu.gmall.sms.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author zql
 * @email zql@atguigu.com
 * @date 2021-06-22 17:51:53
 */
@Mapper
public interface CouponMapper extends BaseMapper<CouponEntity> {
	
}
