package com.lvlvstart.spring.demo.common.msg;

import lombok.Data;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 头信息
 * @create 2019/12/9 16:12
 */
@Data
public class Header {

    private String code;

    private String msg;


    public Header(){}

    public Header(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

}
