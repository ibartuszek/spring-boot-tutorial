package com.example.springboottutorial.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceInterceptor.class);

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        ProductServiceInterceptor.LOGGER.info("Pre handle method is calling.");
        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
            final ModelAndView modelAndView) throws Exception {
        ProductServiceInterceptor.LOGGER.info("Post handle method is calling.");
    }

    @Override
    public void afterCompletion(final HttpServletRequest request, final HttpServletResponse response, final Object handler, final Exception ex)
            throws Exception {
        ProductServiceInterceptor.LOGGER.info("Request and response is completed.");
    }
}
