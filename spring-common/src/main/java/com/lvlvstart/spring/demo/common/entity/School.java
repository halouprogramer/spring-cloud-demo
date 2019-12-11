package com.lvlvstart.spring.demo.common.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/9 15:46
 */
@Data
public class School implements Serializable{

    private String id;

    /**
     * 学校名称
     */
    private String schoolName;
}
