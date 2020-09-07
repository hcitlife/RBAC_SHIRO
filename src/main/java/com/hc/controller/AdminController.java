package com.hc.controller;

import com.hc.domain.Admin;
import com.hc.service.AdminService;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Log4j
public class AdminController {
    @Resource
    private AdminService adminService;

    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        model.addAttribute("msg","增加用户");
        return "user/add";
    }
    @RequestMapping("/add")
    @ResponseBody
    public boolean add(Admin admin){
        boolean res = adminService.add(admin);
        return  res;
    }
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")Integer id,Model model){
        Admin admin = adminService.getById(id);
        model.addAttribute("admin",admin);
        return "user/update";
    }
    @RequestMapping("/update")
    @ResponseBody
    public boolean update(Admin admin){
        boolean res = adminService.update(admin);
        return  res;
    }
    @RequestMapping("/toList")
    public String toList(Model model){
        model.addAttribute("msg","用户列表");
        return "user/list";
    }
    @RequestMapping("/list")
    public String list(Model model) {
        List<Admin> adminList = adminService.getAll();
        model.addAttribute("adminList",adminList);
        return "/user/list";
    }
    @RequestMapping("/toDetail/{id}")
    public String toDetail(@PathVariable("id")Integer id, Model model){
        Admin admin = adminService.getById(id);
        model.addAttribute("admin",admin);
        return "user/detail";
    }
    @RequestMapping("/detail/{id}")
    public Admin detail(@PathVariable("id")Integer id) {
        Admin admin = adminService.getById(id);
        return admin;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable("id") Integer id) {
        boolean res = adminService.deleteById(id);
        return res;
    }
    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        model.addAttribute("msg", "登录");
        return "login";
    }
    @RequestMapping("/login")
    public String login(String account, String password, Model model){
        //subject-securityManager-realm
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(account, password);
        try {
            subject.login(token);
            model.addAttribute("msg","登录成功");
            return "/index";
        } catch (UnknownAccountException e) { //用户名不存在
            model.addAttribute("msg", "用户名错误");
            log.info(e.getMessage());
            return  "login";
        } catch (IncorrectCredentialsException e) { //用户名不存在
            model.addAttribute("msg", "密码错误");
            log.info(e.getMessage());
            return "login";
        } catch (Exception e){
            model.addAttribute("msg","系统错误");
            log.info(e.getMessage());
            return "login";
        }
    }
}
