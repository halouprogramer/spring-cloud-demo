package com.lvlvstart.spring.demo.school.entity;

import lombok.Data;

import javax.persistence.Entity;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/9 15:46
 */
@Data
@Entity
public class School {

    private String id;

    /**
     * 学校名称
     */
    private String schoolName;
}
