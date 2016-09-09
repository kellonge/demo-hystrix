package com.kellonge.demo.hystrix.controller;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kellonge on 16/9/8.
 */
@RestController
@RequestMapping("/random")
public class RandomController {
    Logger logger = Logger.getLogger(RandomController.class);

    @RequestMapping("/now")
    public Date now(HttpServletRequest httpRequest) {
        logger.info("come from " + httpRequest.getRemoteAddr() + ":" + httpRequest.getRemotePort());
        Random random = new Random();
        if (random.nextBoolean()) {
            return new Date();
        } else {
            throw new RuntimeException("can't get date");
        }
    }
}
