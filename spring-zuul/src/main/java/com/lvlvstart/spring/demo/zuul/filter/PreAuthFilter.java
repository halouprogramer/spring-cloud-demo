package com.lvlvstart.spring.demo.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
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

        RequestContext requestContext = RequestContext.getCurrentContext();

        String auth = requestContext.getRequest().getHeader("auth");
        if(StringUtils.isBlank(auth) || !"halou".equals(auth)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
