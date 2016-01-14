/**
 * 
 */
package com.good.night.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置工具
 * 
 * @Description:com.good.night.util.Config
 * @author zhangxc email: zhangxicheng@lizi-inc.com
 * @date 2016年1月14日 下午5:55:02
 */
public class Config {
	private static final Config instance = new Config();
	private Properties prop = null;

	public static Config getInstance() {
		return instance;
	}

	public String get(String key) {
		return prop.getProperty(key);
	}
	
	private void init() {
		try {
			InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties");
			prop = new Properties();
			prop.load(is);
			is.close();
		} catch (IOException e) {
			LoggerUtil.getLogger(Config.class).error("load config error", e);
			e.printStackTrace();
		}
	}
	
	private Config() {
		init();
	}
	
	public static void main(String[] args) {
		System.out.println(Config.getInstance().get("redis.auth"));
	}
}
