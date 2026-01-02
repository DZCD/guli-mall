package com.duzicong.gulimall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.common.utils.Query;

import com.duzicong.gulimall.product.dao.SkuBaseAttrValueDao;
import com.duzicong.gulimall.product.entity.SkuBaseAttrValueEntity;
import com.duzicong.gulimall.product.service.SkuBaseAttrValueService;


@Service("skuBaseAttrValueService")
public class SkuBaseAttrValueServiceImpl extends ServiceImpl<SkuBaseAttrValueDao, SkuBaseAttrValueEntity> implements SkuBaseAttrValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuBaseAttrValueEntity> page = this.page(
                new Query<SkuBaseAttrValueEntity>().getPage(params),
                new QueryWrapper<SkuBaseAttrValueEntity>()
        );

        return new PageUtils(page);
    }

}