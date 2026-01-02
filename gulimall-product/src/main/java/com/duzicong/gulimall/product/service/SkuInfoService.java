package com.duzicong.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.gulimall.product.entity.SkuInfoEntity;

import java.util.Map;

/**
 * 
 *
 * @author duzicong
 * @email 1074676408@qq.com
 * @date 2025-12-29 15:44:58
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

