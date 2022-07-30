package com.zhuiyi.demo.basics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "2",tags = "redisDemo")
@RestController
public class RedisDemoController {

    @Autowired
    RedisTemplate redisTemplate;

    /* Swagger方法注解 */
    /* 目前接口报错 */
    @ApiOperation(value = "3", notes = "", httpMethod = "GET")
    @RequestMapping("/getRedisDateDemo")
    public void getRedisDateDemo(){
        String value=redisTemplate.opsForValue().get("redisDemo").toString();
        System.out.println(value);
    }

    /* Swagger方法注解 */
    @ApiOperation(value = "4", notes = "", httpMethod = "POST")
    @RequestMapping( "/setRedisDateDemo")
    public void setRedisDateDemo(){
        redisTemplate.opsForSet().add("redisDemo","存进来的第一个值！");
    }

}
