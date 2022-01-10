package com.pearz.mvc.controller;

import com.pearz.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 22:41 2022/1/9
 */

@Controller
public class HttpController {

    @RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String requestBody) {
        System.out.println(requestBody);
        return "success";
    }

    @RequestMapping(value = "/testRequestEntity", method = RequestMethod.POST)
    public String testRequestEntity(RequestEntity<String> requestEntity) {
        System.out.println(requestEntity.getHeaders());
        System.out.println(requestEntity.getBody());
        return "success";
    }

    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response ) throws IOException {
        response.getWriter().print("hello reponse");
    }

    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody() {
        return "successs";
    }

    @RequestMapping("/testResponseBodyUser")
    @ResponseBody
    public User testResponseBodyUser() {
        return new User("1", "pearz", "123456", 23, "男");
    }
}
