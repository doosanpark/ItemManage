package com.item.service;

import java.util.HashMap;
import java.util.List;

public interface ItemManageService {
	public List<Object> getItemAcqirdList(HashMap<String, Object> map);
	public List<Object> getItemPossessList(HashMap<String, Object> map);
	public List<Object> getItemInfoList(HashMap<String, Object> map);
	public Integer setItemOrganize(HashMap<String, Object> map);
	public Integer setRegItem(HashMap<String, Object> map);
}
