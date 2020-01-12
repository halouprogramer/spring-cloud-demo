package com.lvlvstart.spring.demo.common.client;

import com.lvlvstart.spring.demo.common.entity.School;
import com.lvlvstart.spring.demo.common.msg.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/12 13:54
 */
@FeignClient("SPRING-SCHOOL")
public interface SchoolClient {


    @PostMapping(value = "/school/findAll")
    public Result<List<School>> findAll();

    @PostMapping(value = "/school/findById")
    public Result<School> findById(String schoolId);
}
