package com.item.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.item.service.ItemManageService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ItemManageDataController {
	private final ItemManageService itemManageService;
	
	@RequestMapping(value = "basicInfo", method = RequestMethod.POST)
	public List<Object> basicInfo() {
		
		return itemManageService.getAllDataList();
	}
}
