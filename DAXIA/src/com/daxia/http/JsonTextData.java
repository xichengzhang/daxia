package com.daxia.http;
/**
 * JsonTextData.java
 * com.hch.httpforjson.api
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2015年4月6日 		hch
 *
 * Copyright (c) 2015, TNT All Rights Reserved.
*/


import java.util.HashMap;

import org.json.JSONObject;



/**
 * ClassName:JsonTextData
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 *
 * @author   hch
 * @version  
 * @since    Ver 1.1
 * @Date	 2015年4月6日		下午3:10:03
 */
public class JsonTextData {

	/**
	 * 
	 * getFindList: 请求同时获取返回obj
	 * TODO(这里描述这个方法适用条件 – 可选)
	 * TODO(这里描述这个方法的执行流程 – 可选)
	 * TODO(这里描述这个方法的使用方法 – 可选)
	 * TODO(这里描述这个方法的注意事项 – 可选)
	 *
	 * @param  @param type
	 * @param  @param typeId
	 * @param  @param page
	 * @param  @param friendId
	 * @param  @param httpSuccess
	 * @param  @param httpError
	 * @param  @return    设定文件
	 * @return HttpClassRequest<JsonObj>    DOM对象
	 * @throws 
	 * @since  CodingExample　Ver 1.1
	 */
	public static HttpClassRequest<JsonObj> getTestObj(String page,
			HttpSuccess<JsonObj> httpSuccess, HttpError httpError) {
		HashMap<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("r", "index/test.do");
		hashMap.put("pageSize", "10");
		hashMap.put("page", page);


		HttpData<JsonObj> huiHenDuoData = new HttpData<JsonObj>();
		return huiHenDuoData.newHttpRequest(JsonObj.class, hashMap, httpSuccess, httpError);

	}
	
	
 	/**
 	 * 
 	 * deleteContent: JsonObject 只看返回数据是否成功
 	 *
 	 * @param  @param contentId
 	 * @param  @param httpSuccess
 	 * @param  @param httpError
 	 * @param  @return    设定文件
 	 * @return HttpJsonObjectRequest    DOM对象
 	 * @throws 
 	 * @since  CodingExample　Ver 1.1
 	 */
	public static HttpJsonObjectRequest isSuccess(String contentId, HttpSuccess<JSONObject> httpSuccess,
			HttpError httpError) {

		HashMap<String, String> hashMap = new HashMap<String, String>();

		hashMap.put("r", "DiscoveryContent/DelContent");
		hashMap.put("contentId", contentId);
		HttpData<JSONObject> huiHenDuoData = new HttpData<JSONObject>();
		return huiHenDuoData.newHttpRequest(hashMap, httpSuccess, null);

	}
}


