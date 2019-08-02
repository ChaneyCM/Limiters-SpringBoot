package com.chaney.limiters.service;

import com.chaney.limiters.limiters.CountLimiter;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class AccessLimitService {

    // permission per second. 每秒5个请求
    RateLimiter rateLimiter = RateLimiter.create(5);
    CountLimiter myCountLimiter = CountLimiter.create(1000, 5);


    // 谷歌开源包：令牌桶算法
    public boolean rateLimiterTryAcquire() {
        return rateLimiter.tryAcquire();
    }

    // 漏桶算法
    public boolean requestIntoBudget() {
        return false;
    }

    // 计算器算法
    public boolean countAcquire() {
        return myCountLimiter.acquire();
    }
}