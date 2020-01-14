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
import org.springframework.web.bind.annotation.RequestParam;
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

    //降级
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
//    })
    @PostMapping("findAllSchoolGet")
    @HystrixCommand(commandKey = "findAllGet")
    public Result findAllGet(){
        return schoolClient.findAll();
    }


    /**
     * 熔断设置
     * @return
     */
    @PostMapping("findAllBreaker")
//    @HystrixCommand(fallbackMethod = "brekerMsg",commandProperties = {@HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //设置再滚动时间窗口中的最小请求数,
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//熔断开启后的时间
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")}) //设置比60%，如果再滚动时间窗口内，大于60%的时候，就会进行熔断
    @HystrixCommand(defaultFallback = "brekerMsg")
    public Result findAllBreaker(@RequestParam( value = "param" ) String param ){

        if("2".equals(param)){
            return success(MsgEnum.SUCESS.getCode(),MsgEnum.SUCESS.getMsg());
        }
        return schoolClient.findAll();
    }

    public Result defaultMsg(){
        return fail(MsgEnum.DOWNGRADE.getCode(),MsgEnum.DOWNGRADE.getMsg());
    }

    public Result brekerMsg(){
        return  fail(MsgEnum.BREAKER.getCode(),MsgEnum.BREAKER.getMsg());
    }
}
