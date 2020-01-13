package com.lvlvstart.spring.demo.common.enums;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/9 16:45
 */
public enum MsgEnum {

    SUCESS("1","成功"),

    DOWNGRADE("001001","服务降级"),
    BREAKER("001002","服务熔断");

    private String code;

    private String msg;


    MsgEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }


    public String getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }


}
