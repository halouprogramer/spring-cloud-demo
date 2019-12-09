package com.lvlvstart.spring.demo.common.msg;

/**
 * @author zishu.lv@baodanyun-inc.com
 * @description 类描述
 * @create 2019/12/9 16:20
 */
public class BaseWeb {


    /**
     * 返回结果
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> result(String code,String message,T data){
        return new Result<>(code,message,data);
    }


    /**
     * 成功
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> success(String code,String message){
        return new Result<>(code,message,null);
    }

    /**
     * 成功
     * @param code
     * @param message
     * @param data
     * @param <T>
     * @return
     */
    public <T> Result<T> success(String code,String message,T data){
        return new Result<>(code,message,data);
    }

    /**
     * 失败
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public <T> Result<T> fail(String code ,String message){
        return new Result<>(code,message,null);
    }


}
