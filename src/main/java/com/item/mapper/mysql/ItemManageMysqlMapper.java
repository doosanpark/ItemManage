package com.item.mapper.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemManageMysqlMapper {
	public List<Object> getItemAcqirdList(HashMap<String, Object> map);
	public int setItemAcqird(HashMap<String, Object> map);
}
