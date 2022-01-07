package com.pearz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 11:41 2022/1/7
 */

@Controller
public class testController {

    //@RequestMapping("/")
    //public String index() {
    //    return "index";
    //}

    @RequestMapping("/test_view")
    public String testView() {
        return "test_view";
    }
}
