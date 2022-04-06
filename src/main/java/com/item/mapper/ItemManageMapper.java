package com.item.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemManageMapper {
	public List<Object> getItemAcqirdList(HashMap<String, Object> map);
	public List<Object> getItemPossessList(HashMap<String, Object> map);
	public List<Object> getItemInfoList(HashMap<String, Object> map);
	public Integer setItemOrganize(HashMap<String, Object> map);
	public Integer setRegItem(HashMap<String, Object> map);
}
