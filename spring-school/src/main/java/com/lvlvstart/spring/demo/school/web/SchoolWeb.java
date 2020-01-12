package com.lvlvstart.spring.demo.school.web;

import com.lvlvstart.spring.demo.common.enums.MsgEnum;
import com.lvlvstart.spring.demo.common.msg.BaseWeb;
import com.lvlvstart.spring.demo.common.msg.Result;
import com.lvlvstart.spring.demo.school.entity.School;
import com.lvlvstart.spring.demo.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("school")
public class SchoolWeb extends BaseWeb{

    @Autowired
    private SchoolService schoolService;

    @PostMapping(value = "findAll")
    public Result<List<School>> findAll(){
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<School> schools = schoolService.findAll();
        return this.success(MsgEnum.SUCESS.getCode(),MsgEnum.SUCESS.getMsg(),schools);
    }

    @PostMapping(value = "findById")
    public Result<School> findById(String schoolId){
        School school = schoolService.findById(schoolId);
        return this.success(MsgEnum.SUCESS.getCode(),MsgEnum.SUCESS.getMsg(),school);
    }



}
