package com.lvlvstart.spring.demo.user.example;

import com.lvlvstart.spring.demo.common.client.SchoolClient;
import com.lvlvstart.spring.demo.common.enums.MsgEnum;
import com.lvlvstart.spring.demo.common.msg.BaseWeb;
import com.lvlvstart.spring.demo.common.msg.Result;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description 类描述
 * @create 2019/12/12 13:57
 */
@RestController
@RequestMapping("rest_feign")
@DefaultProperties(defaultFallback = "defaultMsg")
public class OpenFeignExampleWeb extends BaseWeb {

    @Autowired
    private SchoolClient schoolClient;

    @PostMapping("findAllSchool")
    public Result findAll(){
        return schoolClient.findAll();
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
    })
    @PostMapping("findAllSchoolGet")
    public Result findAllGet(){
        return schoolClient.findAll();
    }


    public Result defaultMsg(){
        return fail(MsgEnum.DOWNGRADE.getCode(),MsgEnum.DOWNGRADE.getMsg());
    }
}
