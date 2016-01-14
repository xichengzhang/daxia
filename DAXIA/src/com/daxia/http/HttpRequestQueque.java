package com.daxia.http;


import org.apache.http.Header;

import com.daxia.utils.LogUtils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import android.content.Context;

public class HttpRequestQueque {

	private AsyncHttpClient client;// ʵ��������

	private HttpRequest _httpRequst;

	private RequestParams params;

	/**
	 * create a instance HttpRequestQueque.
	 * 
	 * @param context
	 */
	public HttpRequestQueque(Context context) {
		client = new AsyncHttpClient();
		client.setTimeout(30000);
	}

	/**
	 * @description: �������
	 * @author:hc
	 * @return:void
	 * @param httpRequst
	 */

	public void add(HttpRequest httpRequst) {
		this._httpRequst = httpRequst;
		//this.cance();
		params = httpRequst.getParams();

		LogUtils.d("JSONObject=%s", _httpRequst.getUrlString());

		this._get(_httpRequst.getUrlString(), params, new TextHttpResponseHandler() {

			@Override
			public void onFailure(int arg0, Header[] arg1, String arg2, Throwable arg3) {

				LogUtils.d("http_stats_code=%s", " " + arg0);

				_httpRequst.onFailure(arg3);

			}

			@Override
			public void onSuccess(int arg0, Header[] arg1, String arg2) {
				// TODO Auto-generated method stub
				_httpRequst.onSuccess(arg2);
			}
		});

	}

	/**
	 * @description: post �ϴ�
	 * @author:hc
	 * @return:void
	 * @param httpRequst
	 */

	public void addPost(HttpRequest httpRequst) {

		this._httpRequst = httpRequst;

		params = httpRequst.getParams();

		LogUtils.d("SERVER_URL_POST==%s", _httpRequst.getUrlString());

		this._post(_httpRequst.getUrlString(), params, new AsyncHttpResponseHandler() {

			@Override
			public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
				_httpRequst.onSuccess(new String(responseBody));

			}

			@Override
			public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

				LogUtils.d("statusCode ==== %d", statusCode);
				_httpRequst.onFailure(error);

			}
		});

	}

	/**
	 * @description: ȡ������
	 * @author:hc
	 * @return:void
	 */

	public void cance() {
		client.cancelAllRequests(true);
	}

	/**
	 * @description: ����http����
	 * @author:hc
	 * @return:void
	 * @param urlString
	 * @param params
	 * @param res
	 */

	private void _get(String urlString, RequestParams params, AsyncHttpResponseHandler res) // url���������
	{
		client.get(urlString, params, res);
	}

	/**
	 * @description: ִ��post����
	 * @author:hc
	 * @return:void
	 * @param urlString
	 * @param params
	 * @param res
	 */

	private void _post(String urlString, RequestParams params, AsyncHttpResponseHandler res) // url���������
	{

		client.post(urlString, params, res);
	}
}

