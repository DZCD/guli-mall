package com.duzicong.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.gulimall.coupon.entity.SkuBoundsEntity;

import java.util.Map;

/**
 * 
 *
 * @author duzicong
 * @email duzicong@gmail.com
 * @date 2026-01-02 16:42:03
 */
public interface SkuBoundsService extends IService<SkuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

