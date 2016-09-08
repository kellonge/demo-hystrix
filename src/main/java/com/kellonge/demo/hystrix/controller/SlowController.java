package com.kellonge.demo.hystrix.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kellonge on 16/9/8.
 */
@RestController
@RequestMapping("/slow")
public class SlowController {

    @RequestMapping("/now")
    public Date now() throws InterruptedException {
        Thread.sleep(1000L);
        return new Date();
    }
}
