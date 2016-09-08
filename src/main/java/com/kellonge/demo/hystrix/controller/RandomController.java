package com.kellonge.demo.hystrix.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kellonge on 16/9/8.
 */
@RestController
@RequestMapping("/random")
public class RandomController {

    @RequestMapping("/now")
    public Date now() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return new Date();
        } else {
            throw new RuntimeException("can't get date");
        }
    }
}
