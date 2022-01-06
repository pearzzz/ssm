package com.pearz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 14:49 2022/1/6
 */

@Controller
public class TestController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
