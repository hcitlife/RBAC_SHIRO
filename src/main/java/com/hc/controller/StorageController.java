package com.hc.controller;

import com.hc.domain.Storage;
import com.hc.service.StorageService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/toList")
    public String toList(Model model){
        model.addAttribute("msg","仓库列表");
        return "/store/list";
    }
    //map.put("/storage/list", "perms[admin:list]");
    @RequestMapping("/list")
    @RequiresPermissions("storage:list")
    public String list(Model model) {
        List<Storage> storageList = storageService.getAll();
        model.addAttribute("storageList",storageList);
        return "/store/list";
    }

    @RequestMapping("/delete/{id}")
    @RequiresRoles("role:system")
    public String delete(@PathVariable("id")Integer id){
        storageService.removeById(id);
        return "redirect:/storage/list";
    }

}
