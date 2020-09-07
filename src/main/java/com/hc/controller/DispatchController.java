package com.hc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DispatchController {

    @RequestMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("msg", "首页");
        return "index";
    }
    @RequestMapping("/unauth")
    public String unauth(Model model) {
        model.addAttribute("msg", "未授权");
        return "unauth";
    }

}
