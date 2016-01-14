package com.daxia.http;

/**
 * @FILE:HuiHenDuoFileRequest.java
 * @AUTHOR:xq
 * @DATE:2014-8-26 ����10:06:30
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.daxia.utils.ConstantValues;
import com.daxia.utils.LogUtils;
import com.loopj.android.http.RequestParams;

/*******************************************
 * @COMPANY:
 * @CLASS:HttpFileRequest
 * @DESCRIPTION:
 * @AUTHOR:hc
 * @VERSION:v1.0
 * @DATE:2014-8-26 ����10:06:30
 *******************************************/
public class HttpFileRequest extends HttpRequest {
	private HashMap<String, Object> params;

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
	public HttpFileRequest(HashMap<String, Object> map, HttpSuccess<JSONObject> httpSuccess, HttpError httpError) {

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

		RequestParams requestParams = new RequestParams();

		StringBuilder stringBuilder = new StringBuilder();
		Iterator<String> iterator = params.keySet().iterator();

		while (iterator.hasNext()) {

			String key = iterator.next().toString();

			if (params.get(key) instanceof File) {

				File tFile = (File) params.get(key);
				LogUtils.d("%s %d  %s %s  %s", "is file", tFile.length(), key, tFile.exists(), tFile.getAbsolutePath());

				try {
					requestParams.put(key, tFile, "application/octet-stream");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				String val = "";
				if (params.get(key) != null) {
					val = params.get(key).toString();
				}
				stringBuilder.append("&" + key + "=" + val);
				requestParams.put(key, params.get(key));
			}

		}

		LogUtils.d("�ύ����Ϊ:", stringBuilder.toString());

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

		LogUtils.d("����ǣ�", result);
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
