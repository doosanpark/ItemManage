package com.item.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.item.mapper.ItemManageMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemManageServiceImpl implements ItemManageService {

	private final ItemManageMapper itemManageMapper ;

	public List<Object> getItemAcqirdList(HashMap<String, Object> map) {
		return itemManageMapper.getItemAcqirdList(map);
	}

	public List<Object> getItemPossessList(HashMap<String, Object> map) {
		return itemManageMapper.getItemPossessList(map);
	}

	public List<Object> getItemInfoList(HashMap<String, Object> map) {
		return itemManageMapper.getItemInfoList(map);
	}
	
	public Integer setItemOrganize(HashMap<String, Object> map) {
		
		
		ArrayList<Object> itemAcqirdList = (ArrayList<Object>) itemManageMapper.getItemAcqirdList(map);
		ArrayList<Object> itemPossessList = (ArrayList<Object>) itemManageMapper.getItemPossessList(map);
	
		if(itemAcqirdList.size() == 0) return 0;
		
		try {
			HashMap<String, Object> itemAcqirdObj = null;
			HashMap<String, Object> itemPossessObj = null;
			int itmEachSeq = 0;
			boolean hasData = false;
			Date acqirdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1900-01-01 00:00:00");
			Date possessDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1900-01-01 00:00:00");
			if(itemPossessList.size() > 0 ) {
				hasData = true;
			}
			
			if(hasData == true) {
				itemAcqirdObj = (HashMap<String, Object>)itemAcqirdList.get(0);
				itemPossessObj = (HashMap<String, Object>)itemPossessList.get(0);
				String itemAcqirdDate = (String) itemAcqirdObj.get("ACQIRD_DATE");
				String itemPossessDate = (String) itemPossessObj.get("ACQIRD_DATE");
				acqirdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(itemAcqirdDate);
				possessDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(itemPossessDate);
				itmEachSeq = Integer.parseInt(String.valueOf(itemPossessObj.get("ITM_EACH_SEQ")));
			}
			if(!hasData || acqirdDate.after(possessDate)) {
				int seq = 1;
				for(int i = itemAcqirdList.size() -1 ; i >= 0 ; i--) {
					HashMap<String, Object> newData = (HashMap<String, Object>) itemAcqirdList.get(i);
					Date newItmAcqirdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse((String) newData.get("ACQIRD_DATE"));
					for(int j = 0; j
< Integer.parseInt(String.valueOf((newData.get("ITM_CNT")))); j++) {
						if(newItmAcqirdDate.after(possessDate)) {
							newData.put("ITM_EACH_SEQ", itmEachSeq + seq);
							newData.put("DUE_DATE", "");
							HashMap<String, Object> itmName = new HashMap<String, Object>();
							itmName.put("itmName", newData.get("ITM_NM"));
							List<Object> itemInfoList = itemManageMapper.getItemInfoList(itmName);
							if(itemInfoList.size() > 0 ) {
								HashMap<String, Object> itemInfoMap = (HashMap<String, Object>) itemInfoList.get(0);
								
								Calendar cal = Calendar.getInstance();
								cal.setTime(newItmAcqirdDate);
								cal.add(Calendar.MONTH, Integer.parseInt(String.valueOf(itemInfoMap.get("DURABLE_MONTH"))));
								
								newData.put("DUE_DATE", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cal.getTime()));
							}
							itemManageMapper.setItemOrganize(newData);
							seq++;
						}
					}
				}
				return 1;
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public Integer setRegItem(HashMap<String, Object> map) {
		return itemManageMapper.setRegItem(map);
	}
	
}
