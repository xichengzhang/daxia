/**
 * 
 */
package com.good.night.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:com.good.night.bean.User
 * @author zhangxc email: zhangxicheng@lizi-inc.com
 * @date 2015年12月25日 下午6:06:52
 */
public class User implements Serializable{
	private static final long serialVersionUID = 6817817688854326437L;
	private Long id = 0L;
	private Long exhibition_id = 0L; //展会id
	private Date create_time = null;
	private Date update_time = null;
	private String name = null;
	private String title = null; // 头衔
	private String pwd = null;
	private String mobile = null;
	private String company = null;
	private String wx_open_id = null; // 微信open_id
	private String user_token = null; // 用户token,不存库
	private String device_token = null; // 设备token
	private String chn = null; // 设备平台
	private int mode = 0; // 用户类型: 0:普通用户,1:参展商用户 ,2:组织者用户,3:超级用户
	private String remark = null;
	
	public User(long exhibition_id, String name, String mobile, String title) {
		this.exhibition_id = exhibition_id;
		this.name = name;
		this.mobile = mobile;
		this.title = title;
	}

	public User(long exhibition_id) {
		this.exhibition_id = exhibition_id;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getExhibition_id() {
		return exhibition_id;
	}

	public void setExhibition_id(Long exhibition_id) {
		this.exhibition_id = exhibition_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWx_open_id() {
		return wx_open_id;
	}

	public void setWx_open_id(String wx_open_id) {
		this.wx_open_id = wx_open_id;
	}

	public String getUser_token() {
		return user_token;
	}

	public void setUser_token(String user_token) {
		this.user_token = user_token;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	public String getChn() {
		return chn;
	}

	public void setChn(String chn) {
		this.chn = chn;
	}

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
