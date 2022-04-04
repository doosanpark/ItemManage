package com.item.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.item.mapper.ItemManageMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemManageServiceImpl implements ItemManageService {

	private final ItemManageMapper itemManageMapper ;
	
	@Override
	public List<Object> getAllDataList() {
		System.out.println("itemManageMapper.getAllDataList() :::::: " + itemManageMapper.getAllDataList());
		
		return itemManageMapper.getAllDataList();
	}

}
