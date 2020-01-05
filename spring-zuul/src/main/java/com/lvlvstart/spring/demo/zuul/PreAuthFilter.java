package com.lvlvstart.spring.demo.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

public class PreAuthFilter extends ZuulFilter{

    //是什么类型的过滤器
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 判断执行的顺序，顺序越小，越靠前拦截
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }

    //判断是否应该被拦截
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
