package com.hysky.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/7/2.
 */
public class PreRrequestLogFile extends ZuulFilter {


    private static final Logger LOGGER = LoggerFactory.getLogger(PreRrequestLogFile.class);


    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }


    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();

        HttpServletRequest request =  ctx.getRequest();


        LOGGER.info(String.format("send %s request to %s",request.getMethod(),request.getRequestURL().toString()));
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
}
