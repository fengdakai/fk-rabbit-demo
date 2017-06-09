package com.fk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/6/9.
 */
@Controller
@RequestMapping(value = "test")
public class TestController {
    @RequestMapping(value = "test")
    public void test(){
        System.out.println("test");
    }
}
