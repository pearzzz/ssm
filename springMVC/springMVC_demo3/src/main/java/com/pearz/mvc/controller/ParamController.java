package com.pearz.mvc.controller;

import com.pearz.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 20:03 2022/1/6
 */

@Controller
public class ParamController {

    @RequestMapping("/param")
    public String param() {
        return "test_param";
    }

    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam("user_name") String username,
            String password,
            String hobby,
            @RequestHeader("Host") String host) {
        System.out.println(username + " === " + password + " === " + hobby);
        System.out.println(host);
        return "success";
    }

    @RequestMapping("/testBean")
    public String tsetBean(User user) {
        System.out.println(user);
        return "success";
    }
}
