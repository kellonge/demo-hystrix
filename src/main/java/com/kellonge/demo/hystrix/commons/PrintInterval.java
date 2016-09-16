package com.kellonge.demo.hystrix.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * Created by kellonge on 16/9/16.
 */
public class PrintInterval {
    private static Logger logger = LoggerFactory.getLogger(PrintInterval.class);

    private static Date   startDate;

    /**
     * 开始计时
     */
    public static void start() {
        startDate = new Date();
    }

    /**
     * 结束计时
     */
    public static void end() {
        if (startDate == null) {
            throw new IllegalArgumentException("invoke start date method first");
        }
        logger.info("invoke intervale is " + (new Date().getTime() - startDate.getTime()) + "ms");
    }
}
