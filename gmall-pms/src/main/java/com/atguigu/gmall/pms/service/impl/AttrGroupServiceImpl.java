package com.atguigu.gmall.pms.service.impl;

import com.atguigu.gmall.pms.entity.AttrEntity;
import com.atguigu.gmall.pms.mapper.AttrMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.gmall.common.bean.PageResultVo;
import com.atguigu.gmall.common.bean.PageParamVo;

import com.atguigu.gmall.pms.mapper.AttrGroupMapper;
import com.atguigu.gmall.pms.entity.AttrGroupEntity;
import com.atguigu.gmall.pms.service.AttrGroupService;
import org.springframework.util.CollectionUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroupEntity> implements AttrGroupService {

    @Autowired
    private AttrMapper attrMapper;
    @Override
    public PageResultVo queryPage(PageParamVo paramVo) {
        IPage<AttrGroupEntity> page = this.page(
                paramVo.getPage(),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageResultVo(page);
    }

    @Override
    public List<AttrGroupEntity> queryGroupsWithAttrsByCid(Long catId) {
        //先根据分类id查询组列表
        QueryWrapper<AttrGroupEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id", catId);
        List<AttrGroupEntity> attrGroupEntities = this.list(queryWrapper);
        if (CollectionUtils.isEmpty(attrGroupEntities)){
            return null;
        }

        //遍历所有的组查询组下的规格参数
        attrGroupEntities.forEach(attrGroupEntity ->{
            QueryWrapper<AttrEntity> wrapper =new QueryWrapper<>();
            wrapper.eq("group_id", attrGroupEntity.getId()).eq("type", 1);
            List<AttrEntity> attrEntities = this.attrMapper.selectList(wrapper);
            attrGroupEntity.setAttrEntities(attrEntities);
        });


        return attrGroupEntities;
    }

}