package com.kellonge.demo.hystrix.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kellonge on 16/9/8.
 */
@RestController
@RequestMapping("/normal")
public class NormalController {

    @RequestMapping("/now")
    public Date now() {
        return new Date();
    }
}
