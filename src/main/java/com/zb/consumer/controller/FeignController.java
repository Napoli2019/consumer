package com.zb.consumer.controller;

import com.zb.consumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Map;

@Controller
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/list")
    public String list(@RequestParam Map map, Model model){
        model.addAttribute("users",feignService.findAll(map));
        return "list";
    }

    @RequestMapping("/get")
    public String get(@RequestParam(value = "id")String id,Model model){
        System.out.println("id:"+id);
        model.addAttribute("user",feignService.get(id));
        return "view";
    }

}
