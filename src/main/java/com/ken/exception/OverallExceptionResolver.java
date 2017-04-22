package com.ken.exception;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by it on 12/04/2017.
 */
public class OverallExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver {

    Logger logger = LogManager.getLogger(OverallExceptionResolver.class);

    /**
     * 进行全局异常的过滤和处理
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        logger.error(e.getMessage());
        System.out.println(e.getMessage());

        return null;
    }
}
