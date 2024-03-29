package com.ecommerce.spring.cloud.microservice.server.interceptor;

import com.alibaba.fastjson.JSON;
import com.ecommerce.spring.cloud.microservice.server.utils.ReturnData;
import com.ecommerce.spring.cloud.microservice.server.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName RedisSessionInterceptor
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/15 16:28
 * @Version 1.0
 **/
public class RedisSessionInterceptor implements HandlerInterceptor {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //无论访问的地址是不是正确的，都进行登录验证，登录成功后的访问再进行分发，404的访问自然会进入到错误控制器中

        HttpSession session = request.getSession();
        System.out.println("什么时候都走拦截器吗"+session.getId());
        if (session.getAttribute("loginUserId") != null)
        {
            try
            {
                //验证当前请求的session是否是已登录的session
                String loginSessionId = redisTemplate.opsForValue().get("loginUser:" + session.getAttribute("loginUserId"));
                System.out.println("2什么时候都走拦截器吗"+loginSessionId);
                if (loginSessionId != null && loginSessionId.equals(session.getId()))
                {
                    return true;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        response401(response);
        return false;
    }

    private void response401(HttpServletResponse response)
    {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");

        try
        {
            response.getWriter().print(JSON.toJSONString(new ReturnData(StatusCode.NEED_LOGIN, "", "用户未登录！")));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
