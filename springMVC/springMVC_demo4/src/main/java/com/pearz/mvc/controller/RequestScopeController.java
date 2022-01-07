package com.pearz.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 11:08 2022/1/7
 */

@Controller
public class RequestScopeController {

    @RequestMapping("/testRequestScope")
    public String testRequestScope(HttpServletRequest req) {
        req.setAttribute("testRequestScope", "hello, servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("testRequestScope", "helle, ModeAndView");
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testSession")
    public String testSession(HttpSession session) {
        session.setAttribute("testSession", "hello, session");
        return "success";
    }

    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplication", "hello, application");
        return "success";
    }
}
