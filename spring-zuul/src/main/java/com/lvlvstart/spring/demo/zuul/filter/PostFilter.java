package com.lvlvstart.spring.demo.zuul.filter;

import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import sun.net.httpserver.AuthFilter;

import javax.servlet.http.HttpServletRequest;

public class PostFilter extends ZuulFilter{

    /**
     * 处理器类型
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 返回内容设置
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        return null;

    }
}
