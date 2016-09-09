package com.kellonge.demo.hystrix.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kellonge on 16/9/8.
 */
@RestController
@RequestMapping("/slow")
public class SlowController {
    Logger logger = Logger.getLogger(SlowController.class);

    @RequestMapping("/now")
    public Date now(HttpServletRequest httpRequest) throws InterruptedException {
        logger.info("come from " + httpRequest.getRemoteAddr() + ":" + httpRequest.getRemotePort());
        Thread.sleep(1000L);
        return new Date();
    }
}
