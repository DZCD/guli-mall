package com.duzicong.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.gulimall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author duzicong
 * @email 1074676408@qq.com
 * @date 2025-12-29 15:44:59
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CategoryEntity> listWithTree();
}

