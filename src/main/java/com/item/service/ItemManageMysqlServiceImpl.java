package com.item.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.item.mapper.mysql.ItemManageMysqlMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemManageMysqlServiceImpl implements ItemManageMysqlService {

	private final ItemManageMysqlMapper ItemManageMysqlMapper ;

	public List<Object> getItemAcqirdList(HashMap<String, Object> map) {
		return ItemManageMysqlMapper.getItemAcqirdList(map);
	}
	public int setItemAcqird(HashMap<String, Object> map) {
		return ItemManageMysqlMapper.setItemAcqird(map);
	}

}
