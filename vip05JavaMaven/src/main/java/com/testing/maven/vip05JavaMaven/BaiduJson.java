package com.testing.maven.vip05JavaMaven;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

public class BaiduJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ipResult = "{\"status\":\"0\",\"t\":\"1556114489842\",\"set_cache_time\":\"\",\"data\":[{\"location\":\"美国\",\"titlecont\":\"IP地址查询\",\"origip\":\"3.3.3.3\",\"origipquery\":\"3.3.3.3\",\"showlamp\":\"1\",\"showLikeShare\":1,\"shareImage\":1,\"ExtendedLocation\":\"\",\"OriginQuery\":\"3.3.3.3\",\"tplt\":\"ip\",\"resourceid\":\"6006\",\"fetchkey\":\"3.3.3.3\",\"appinfo\":\"\",\"role_id\":0,\"disp_type\":0}]}";
		JSONObject json=JSON.parseObject(ipResult);
		System.out.println(json);
		System.out.println(json.get("data"));
		Map<String, Object> map =new HashMap<String, Object>();
		for(String key:json.keySet()) {
			map.put(key, json.get(key));
		}
		System.out.println(map);
		Map<String, Object> dimap =new HashMap<String, Object>();
		dimap=(Map)JSON.parse(ipResult);
		System.out.println(dimap);
		
		
		String recomJson="{";
		for(Entry entry:dimap.entrySet()) {
			if(entry.getValue() instanceof String) {
				System.out.println(entry.getKey()+"值类型是String，拼接加双引号"+entry.getValue());
				recomJson+="\""+entry.getKey()+"\":\""+entry.getValue()+"\",";
			}
			else {
				System.out.println(entry.getKey()+"值非string，不加双引号"+entry.getValue());
				recomJson+="\""+entry.getKey()+"\":"+entry.getValue()+",";
			}
		}
		recomJson=recomJson.substring(0, recomJson.length()-1);
		recomJson+="}";
		System.out.println(recomJson);
		
		System.out.println(JSON.toJSONString(dimap));
		
		
	}

}
