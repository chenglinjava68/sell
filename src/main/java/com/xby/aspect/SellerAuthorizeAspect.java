package com.xby.aspect;

import com.xby.constant.CookieConstant;
import com.xby.constant.RedisConstant;
import com.xby.exception.SellerAuthorizeException;
import com.xby.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author :xby
 * @date :2019/2/16 15:41
 * @description :
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 对直接登录卖家后台其它界面进行拦截
     */
    @Pointcut("execution(public * com.xby.controller.Seller*.*(..))" +
            "&& !execution(public * com.xby.controller.SellerUserController.*(..))")
    public void verify() {}

    /**
     * 拦截前，检查Cookie以及redis中是否有卖家信息
     */
    @Before("verify()")
    public void doVerify() {
        //使用RequestContextHolder获取到当前的HttpServletRequest
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //根据TOKEN去查询cookie中是否有对应的信息
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }

        //调用RedisTemplate常用集合opsForValue中的get()方法
        //通过cookie的值获取redis的过期时间，存到tokenValue
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】Redis中查不到token");
            throw new SellerAuthorizeException();
        }
    }
}
