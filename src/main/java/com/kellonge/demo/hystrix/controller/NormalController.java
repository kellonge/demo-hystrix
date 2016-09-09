package com.kellonge.demo.hystrix.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kellonge on 16/9/8.
 */
@RestController
@RequestMapping("/normal")
public class NormalController {
    Logger logger = Logger.getLogger(NormalController.class);

    @RequestMapping("/now")
    public Date now(HttpServletRequest httpRequest) {
        logger.info("come from " + httpRequest.getRemoteAddr() + ":" + httpRequest.getRemotePort());
        return new Date();
    }
}
