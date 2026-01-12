package com.duzicong.gulimall.member.feign;

import com.duzicong.common.utils.R;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class CouponFeignServiceTest {

    @Resource
    CouponFeignService couponFeignService;

    @Test
    void testFeign(){
        R membercoupons = couponFeignService.membercoupons();
        System.out.println(membercoupons);
    }
}
