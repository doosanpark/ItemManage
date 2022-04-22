package com.item.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.item.service.ItemManageMysqlService;
import com.item.service.ItemManageOracleService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ItemManageDataController {
	private final ItemManageMysqlService itemManageMysqlService;
	private final ItemManageOracleService itemManageOracleService;

	@RequestMapping(value = "itemAcqirdOrigin.do", method = RequestMethod.POST)
	public List<Object> itemAcqird(@RequestParam HashMap<String, Object> map) {
		
		return itemManageMysqlService.getItemAcqirdList(map);
	}

	@RequestMapping(value = "/regItemAcqird.do", method = RequestMethod.POST)
	public int regItemAcqird(@RequestParam HashMap<String, Object> map) {
		
		return itemManageMysqlService.setItemAcqird(map);
	}
	

	@RequestMapping(value = "itemAcqirdMoved.do", method = RequestMethod.POST)
	public List<Object> itemAcqirdMoved(@RequestParam HashMap<String, Object> map) {
		
		return itemManageOracleService.getItemAcqirdList(map);
	}
	
	@RequestMapping(value = "itemPossess.do", method = RequestMethod.POST)
	public List<Object> itemPossess(@RequestParam HashMap<String, Object> map) {
		
		return itemManageOracleService.getItemPossessList(map);
	}
	
	@RequestMapping(value = "itemInfo.do", method = RequestMethod.POST)
	public List<Object> itemInfo(@RequestParam HashMap<String, Object> map) {
		
		return itemManageOracleService.getItemInfoList(map);
	}
	
	@RequestMapping(value = "orgnizItemData.do", method = RequestMethod.POST)
	public int orgnizItemData(@RequestParam HashMap<String, Object> map) {
		
		return itemManageOracleService.setItemOrganize(map);
	}
	
	@RequestMapping(value = "/regItem.do", method = RequestMethod.POST)
	public int regItem(@RequestParam HashMap<String, Object> map) {
		
		return itemManageOracleService.setRegItem(map);
	}
	
}