package com.duzicong.gulimall.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duzicong.gulimall.product.entity.SkuBaseAttrValueEntity;
import com.duzicong.gulimall.product.service.SkuBaseAttrValueService;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.common.utils.R;



/**
 * 
 *
 * @author duzicong
 * @email duzicong@gmail.com
 * @date 2025-12-31 15:46:08
 */
@RestController
@RequestMapping("product/skubaseattrvalue")
public class SkuBaseAttrValueController {
    @Autowired
    private SkuBaseAttrValueService skuBaseAttrValueService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuBaseAttrValueService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SkuBaseAttrValueEntity skuBaseAttrValue = skuBaseAttrValueService.getById(id);

        return R.ok().put("skuBaseAttrValue", skuBaseAttrValue);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SkuBaseAttrValueEntity skuBaseAttrValue){
		skuBaseAttrValueService.save(skuBaseAttrValue);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SkuBaseAttrValueEntity skuBaseAttrValue){
		skuBaseAttrValueService.updateById(skuBaseAttrValue);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		skuBaseAttrValueService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
