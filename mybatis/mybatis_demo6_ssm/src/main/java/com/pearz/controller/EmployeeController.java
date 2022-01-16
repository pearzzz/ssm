package com.pearz.controller;

import com.pearz.bean.Employee;
import com.pearz.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * @Description
 * @Author pearz
 * @Email zhaihonghao317@163.com
 * @Date 19:24 2022/1/15
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/save", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String saveEmployee(Employee employee) throws IOException {
        employeeService.save(employee);
        return "保存成功";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws IOException {
        final List<Employee> employeeList = employeeService.getAllEmps();
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("employeeList", employeeList);
        modelAndView.setViewName("employeeList");
        return modelAndView;
    }
}
