package com.item.controller;

import java.util.HashMap;
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
	
	@RequestMapping(value = "itemAcqird.do", method = RequestMethod.POST)
	public List<Object> itemAcqird(@RequestParam HashMap<String, Object> map) {
		
		return itemManageService.getItemAcqirdList(map);
	}
	
	@RequestMapping(value = "itemPossess.do", method = RequestMethod.POST)
	public List<Object> itemPossess(@RequestParam HashMap<String, Object> map) {
		
		return itemManageService.getItemPossessList(map);
	}
	
	@RequestMapping(value = "itemInfo.do", method = RequestMethod.POST)
	public List<Object> itemInfo(@RequestParam HashMap<String, Object> map) {
		
		return itemManageService.getItemInfoList(map);
	}
	
	@RequestMapping(value = "orgnizItemData.do", method = RequestMethod.POST)
	public int orgnizItemData(@RequestParam HashMap<String, Object> map) {
		
		return itemManageService.setItemOrganize(map);
	}
	
	@RequestMapping(value = "/regItem.do", method = RequestMethod.POST)
	public int regItem(@RequestParam HashMap<String, Object> map) {
		
		return itemManageService.setRegItem(map);
	}
}