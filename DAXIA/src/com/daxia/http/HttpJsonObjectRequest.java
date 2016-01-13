package com.daxia.http;

/**
 * @FILE:HttpJsonObjectRequest.java
 * @AUTHOR:hc
 * @DATE:2014-7-30 ����3:12:35
 **/

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.daxia.utils.ConstantValues;
import com.daxia.utils.LogUtils;
import com.loopj.android.http.RequestParams;

/*******************************************
 * @COMPANY:
 * @CLASS:HttpJsonObjectRequest
 * @DESCRIPTION:
 * @AUTHOR:hc
 * @VERSION:v1.0
 * @DATE:2014-7-30 ����3:12:35
 *******************************************/
public class HttpJsonObjectRequest extends HttpRequest {

	private HashMap<String, String> params;

	private HttpError error;

	private HttpSuccess<JSONObject> success;

	/**
	 * create a instance HttpRequest.
	 * 
	 * @param cls
	 * @param map
	 * @param httpSuccess
	 * @param httpError
	 */
	public HttpJsonObjectRequest(HashMap<String, String> map, HttpSuccess<JSONObject> httpSuccess, HttpError httpError) {

		this.params = map;
		this.success = httpSuccess;
		this.error = httpError;

	}

	/**
	 * @description: ��ȡ����
	 * @author:hc
	 * @return:RequestParams
	 * @return
	 */

	@Override
	public RequestParams getParams() {
		// TODO Auto-generated method stub
		final RequestParams requestParams = new RequestParams();

		StringBuilder stringBuilder = new StringBuilder();
		Iterator<String> iterator = params.keySet().iterator();
		while (iterator.hasNext()) {

			String key = iterator.next().toString();

			requestParams.put(key, params.get(key));

			String val = params.get(key);
			stringBuilder.append("&" + key + "=" + val);

		}

		LogUtils.d("�ύ����Ϊ: %s", "=" + stringBuilder.toString());

		return requestParams;
	}

	/**
	 * @description:
	 * @author:hc
	 * @return:String
	 * @return
	 */

	@Override
	public String getUrlString() {
		return ConstantValues.url;
	}

	/**
	 * @description:ʧ�ܺ����
	 * @author:hc
	 * @return:void
	 * @param arg3
	 */

	@Override
	public void onFailure(Throwable throwable) {
		if (error != null)
			error.onError(throwable);
	}

	/**
	 * @description:�ɹ������
	 * @author:hc
	 * @return:void
	 * @param arg2
	 */

	@Override
	public void onSuccess(String result) {

		LogUtils.d("����ǣ�%s", result);
		try {
			JSONObject jsonObject = new JSONObject(result);
			if (success != null)
				success.onSuccess(jsonObject);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (error != null)
				error.onError(new Throwable());
		}
	}

}

