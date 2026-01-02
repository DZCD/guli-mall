package com.duzicong.gulimall.coupon.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duzicong.gulimall.coupon.entity.CategoryBoundsEntity;
import com.duzicong.gulimall.coupon.service.CategoryBoundsService;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.common.utils.R;



/**
 * 
 *
 * @author duzicong
 * @email duzicong@gmail.com
 * @date 2026-01-02 16:42:03
 */
@RestController
@RequestMapping("coupon/categorybounds")
public class CategoryBoundsController {
    @Autowired
    private CategoryBoundsService categoryBoundsService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = categoryBoundsService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CategoryBoundsEntity categoryBounds = categoryBoundsService.getById(id);

        return R.ok().put("categoryBounds", categoryBounds);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryBoundsEntity categoryBounds){
		categoryBoundsService.save(categoryBounds);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryBoundsEntity categoryBounds){
		categoryBoundsService.updateById(categoryBounds);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		categoryBoundsService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
