package com.lvlvstart.spring.demo.common.msg;

import lombok.Data;


/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/9 16:14
 */
@Data
public class Result<T> {

    private Header header;

    private T body;


    public Result(){}

    public Result(String header,String msg,T data){
        this.header = new Header(header,msg);
        body = data;
    }

}
