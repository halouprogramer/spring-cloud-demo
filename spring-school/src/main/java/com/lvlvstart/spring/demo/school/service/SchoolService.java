package com.lvlvstart.spring.demo.school.service;

import com.lvlvstart.spring.demo.school.dao.SchoolRepository;
import com.lvlvstart.spring.demo.school.entity.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/9 15:53
 */
@Service
@RefreshScope
public class SchoolService {


    @Value("${env}")
    private String env;

    @Autowired
    private SchoolRepository repository;


    public List<School> findAll(){
        return repository.findAll();
    }

    public School findById(String choolId){
        Optional<School> school = repository.findById(choolId);
        if(school.isPresent()){
            return school.get();
        }
        return null;
    }

    public String getEnv(){
        return env;
    }


}
