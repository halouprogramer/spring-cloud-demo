package com.lvlvstart.spring.demo.school.web;


import com.lvlvstart.spring.demo.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config-demo")
public class ConfigDemoController {


    @Autowired
    private SchoolService schoolService;

    @GetMapping("get-env")
    private String getEnv(){
        return schoolService.getEnv();
    }
}
