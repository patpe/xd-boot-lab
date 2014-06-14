package com.patpe.lab.xd.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/")
	public String getPage(Model model) {
		model.addAttribute("pageid", "NA");
		return "page";
	}

	@RequestMapping("/{pageid}")
	public String getPage(@PathVariable("pageid") String pageId, Model model) {
		model.addAttribute("pageid", pageId);
		return "page";
	}
}
