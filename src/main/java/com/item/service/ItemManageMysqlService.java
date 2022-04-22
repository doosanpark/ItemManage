package com.item.service;

import java.util.HashMap;
import java.util.List;

public interface ItemManageMysqlService {
	public List<Object> getItemAcqirdList(HashMap<String, Object> map);
	public int setItemAcqird(HashMap<String, Object> map);
}
