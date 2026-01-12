package com.duzicong.gulimall.coupon.controller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duzicong.gulimall.coupon.entity.CouponEntity;
import com.duzicong.gulimall.coupon.service.CouponService;
import com.duzicong.common.utils.PageUtils;
import com.duzicong.common.utils.R;



/**
 * 
 *
 * @author duzicong
 * @email duzicong@gmail.com
 * @date 2026-01-02 16:42:03
 */
@RefreshScope
@RestController
@RequestMapping("coupon/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")
    private String username;

    @RequestMapping("test")
    public R test(){
        return R.ok().put("name", username);
    }

    @RequestMapping("/member/list")
    public R membercoupons(){
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setCouponName("满100减10");
        couponEntity.setCouponType(0);
        couponEntity.setCouponImg("https://example.com/coupon1.jpg");
        couponEntity.setNum(1000);
        couponEntity.setAmount(new BigDecimal("10"));
        couponEntity.setPerLimit(5);
        couponEntity.setMinPoint(new BigDecimal("100"));
        couponEntity.setUseType(0);
        couponEntity.setNote("全场通用优惠券");
        couponEntity.setPublishCount(10000);
        couponEntity.setUseCount(5000);
        couponEntity.setReceiveCount(7000);
        couponEntity.setCode("FULL100OFF10");
        couponEntity.setMemberLevel(0);
        couponEntity.setPublish(1);

        return R.ok().put("coupons",Arrays.asList(couponEntity) );
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CouponEntity coupon){
		couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CouponEntity coupon){
		couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
