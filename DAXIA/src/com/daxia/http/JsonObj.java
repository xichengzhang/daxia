package com.daxia.http;

/**
 * JsonObj.java
 * com.hch.httpforjson.vi
 *
 * Function�� TODO 
 *
 *   ver     date      		author
 * ��������������������������������������������������������������������
 *   		 2015��4��6�� 		hch
 *
 * Copyright (c) 2015, TNT All Rights Reserved.
 */


import java.util.ArrayList;

/**
 * ClassName:�����Ӧ���json��ʽ��������bean
 * 
 * @author hch
 * @version
 * @since Ver 1.1
 * @Date 2015��4��6�� ����3:02:24
 */
public class JsonObj {

	String System_id;
	ArrayList<JsonObj2> item;

	public String getSystem_id() {
		return System_id;
	}

	public void setSystem_id(String system_id) {
		System_id = system_id;
	}

	public ArrayList<JsonObj2> getItem() {
		return item;
	}

	public void setItem(ArrayList<JsonObj2> item) {
		this.item = item;
	}

}

