package com.daxia.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.daxia.R;
import com.daxia.http.HttpError;
import com.daxia.http.HttpRequestQueque;
import com.daxia.http.HttpSuccess;
import com.daxia.http.JsonObj;
import com.daxia.http.JsonTextData;

/**
 * 首页fragment ViewPager tab
 * @author dewyze
 *
 */
public class HomeTabFragment extends BaseFragment {
	
	private static final String TAG = "HomeTabFragment";
	private Activity mActivity;
	private TextView mMsgTv;
	private String mMsgName;
	private EditText area_weather;
	private Button find_weather;
	private HttpRequestQueque requestQueque;

	public void setMsgName(String msgName) {
		this.mMsgName = msgName;
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.mActivity = activity;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_home_tab, container, false);
		return view;
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initViews(view);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initDisplay();
	}
	
	private void initViews(View view) {
		mMsgTv = (TextView) view.findViewById(R.id.msg_tv);
		area_weather = (EditText) view.findViewById(R.id.area_weather);
		find_weather = (Button) view.findViewById(R.id.find_weather);
		find_weather.setOnClickListener(new findClickListener());
	}
	
	private void initDisplay() {
		//mMsgTv.setText(mMsgName + "");
	}

	@Override
	public String getFragmentName() {
		return TAG;
	}
	
	private class findClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			String area = area_weather.getText().toString();
			 
	        requestQueque = new HttpRequestQueque(mActivity);
			
	        // 获取有json对象返回的方式
			requestQueque.add(JsonTextData.getTestObj("1", new HttpSuccess<JsonObj>() {
				
				@Override
				public void onSuccess(JsonObj jsonObj) {
					mMsgTv.setText("success");
					
				}
			}, new HttpError() {
				
				@Override
				public void onError(Throwable arg0) {
					
					// TODO Auto-generated method stub
					Toast.makeText(mActivity, "失败了！！！！！", 1).show();
					
				}
			}));
		}
		
	}
}
