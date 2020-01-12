package com.lvlvstart.spring.demo.user.example;

import com.lvlvstart.spring.demo.common.client.SchoolClient;
import com.lvlvstart.spring.demo.common.enums.MsgEnum;
import com.lvlvstart.spring.demo.common.msg.BaseWeb;
import com.lvlvstart.spring.demo.common.msg.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/12 13:57
 */
@RestController
@RequestMapping("rest_feign")
public class OpenFeignExampleWeb extends BaseWeb {

    @Autowired
    private SchoolClient schoolClient;

    @PostMapping("findAllSchool")
    public Result findAll(){
        return schoolClient.findAll();
    }

    @HystrixCommand(fallbackMethod = "msg")
    @PostMapping("findAllSchoolGet")
    public Result findAllGet(){
        return schoolClient.findAll();
    }


    public Result msg(){
        return fail(MsgEnum.DOWNGRADE.getCode(),MsgEnum.DOWNGRADE.getMsg());
    }
}
