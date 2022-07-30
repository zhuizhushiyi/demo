package com.zhuiyi.demo.basics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* Swagger类注解 */
@Api(value = "1",tags = "diyilei")
@RestController
/**
 * Swagger类注解
 */
public class RebushuDemo {

    /* Swagger方法注解 */
    @ApiOperation(value = "1", notes = "", httpMethod = "GET")
    @RequestMapping("/index")
    public String index() {
        return "helloworld!2222";
    }

    /* Swagger方法注解 */
    @ApiOperation(value = "2", notes = "",httpMethod = "POST")
    @RequestMapping("/say")
    public String say(){
        return "I love Java!ww";
    }
}
