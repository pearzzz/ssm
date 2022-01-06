package com.pearz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 13:22 2022/1/6
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }


    @RequestMapping("/hello")
    public String HelloWorld() {
        return "target";
    }
}
