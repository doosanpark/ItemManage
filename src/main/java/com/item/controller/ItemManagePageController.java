package com.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ItemManagePageController {
	
	
	@GetMapping("/itemPage.do")
	  public String itemInfo(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "ItemPage";
	  }
}
