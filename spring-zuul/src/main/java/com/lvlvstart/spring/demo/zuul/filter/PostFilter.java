package com.lvlvstart.spring.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class PostFilter extends ZuulFilter{

    /**
     * 处理器类型
     * @return {@link FilterConstants#POST_TYPE}
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 执行顺序
     * @return {@link FilterConstants#SEND_RESPONSE_FILTER_ORDER} -1
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


        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletResponse response = requestContext.getResponse();
        response.setHeader("hello","hello");
        return null;

    }
}
