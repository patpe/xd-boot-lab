package com.patpe.lab.xd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value =  "/dashboard")
public class DashboardController {

    @RequestMapping(method = RequestMethod.GET)
    public String getPage(Model model) {
        return "dashboard";
    }
}
