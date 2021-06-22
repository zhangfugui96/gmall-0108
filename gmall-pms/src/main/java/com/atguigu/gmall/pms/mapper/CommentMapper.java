package com.atguigu.gmall.pms.mapper;

import com.atguigu.gmall.pms.entity.CommentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价
 * 
 * @author zql
 * @email zql@atguigu.com
 * @date 2021-06-22 15:19:13
 */
@Mapper
public interface CommentMapper extends BaseMapper<CommentEntity> {
	
}
