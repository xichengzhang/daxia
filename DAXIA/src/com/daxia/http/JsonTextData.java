package com.daxia.http;
/**
 * JsonTextData.java
 * com.hch.httpforjson.api
 *
 * Function�� TODO 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��4��6�� 		hch
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
 * @Date	 2015��4��6��		����3:10:03
 */
public class JsonTextData {

	/**
	 * 
	 * getFindList: ����ͬʱ��ȡ����obj
	 * TODO(����������������������� �C ��ѡ)
	 * TODO(�����������������ִ������ �C ��ѡ)
	 * TODO(�����������������ʹ�÷��� �C ��ѡ)
	 * TODO(�����������������ע������ �C ��ѡ)
	 *
	 * @param  @param type
	 * @param  @param typeId
	 * @param  @param page
	 * @param  @param friendId
	 * @param  @param httpSuccess
	 * @param  @param httpError
	 * @param  @return    �趨�ļ�
	 * @return HttpClassRequest<JsonObj>    DOM����
	 * @throws 
	 * @since  CodingExample��Ver 1.1
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
 	 * deleteContent: JsonObject ֻ�����������Ƿ�ɹ�
 	 *
 	 * @param  @param contentId
 	 * @param  @param httpSuccess
 	 * @param  @param httpError
 	 * @param  @return    �趨�ļ�
 	 * @return HttpJsonObjectRequest    DOM����
 	 * @throws 
 	 * @since  CodingExample��Ver 1.1
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


