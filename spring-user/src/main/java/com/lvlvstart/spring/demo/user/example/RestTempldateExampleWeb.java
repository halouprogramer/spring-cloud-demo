package com.lvlvstart.spring.demo.user.example;

import com.lvlvstart.spring.demo.common.entity.School;
import com.lvlvstart.spring.demo.common.msg.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("rest_template")
public class RestTempldateExampleWeb {


    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("findAllSchool")
    public Result remoteCallSchoolFindAll(){
        Result result = restTemplate.postForObject("http://SPRING-SCHOOL/school/findAll", null,Result.class);
        return result;
    }


}
