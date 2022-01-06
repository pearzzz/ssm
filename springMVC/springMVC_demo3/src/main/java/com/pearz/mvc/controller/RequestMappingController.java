package com.pearz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 17:30 2022/1/6
 */

@Controller
//@RequestMapping("/test")
public class RequestMappingController {

    @RequestMapping("/success")
    public String requestMappingTest() {
        return "success";
    }

    @RequestMapping("/success/{id}/{username}")
    public String test1(@PathVariable("id") String id, @PathVariable("username") String username) {
        System.out.println(id + "==>" + username);
        return "success";
    }
}
