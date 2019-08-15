package com.ecommerce.spring.cloud.microservice.server.controller;

import com.ecommerce.spring.cloud.microservice.server.utils.ReturnData;
import com.ecommerce.spring.cloud.microservice.server.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName TestController1
 * @Description TODO
 * @Author IvenYan
 * @Date 2019/8/8 19:40
 * @Version 1.0
 **/
@RestController
@RequestMapping("/server")
@Api(value = "TestController1 operations",tags = {"TestController1 service"})
public class TestController1 {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/function1")
    public String test1(){

        return "success";
    }

    @RequestMapping("/function2")
    public String test2(){

        return "success2";
    }

    @ApiOperation(value="用户登录",notes="根据产品的pid来获取产品分类信息", produces="application/json",consumes = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String")
    })
    @RequestMapping("/user/login")
    public ReturnData test3(HttpServletRequest request, @RequestParam("userName") String userName, @RequestParam("password") String password){
//        redisTemplate.opsForValue().set("loginUser:"+userName,session.getId());
        String s = redisTemplate.opsForValue().get("loginUser:"+userName);
        if (userName != null){
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", userName);
            redisTemplate.opsForValue().set("loginUser:" + userName, session.getId());

            return new ReturnData(StatusCode.REQUEST_SUCCESS, "", "登录成功！");
        }
        System.out.println("user loing ="+ s);
        return null;
    }


}
