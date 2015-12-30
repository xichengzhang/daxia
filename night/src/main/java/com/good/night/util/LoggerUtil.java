/**
 * 
 */
package com.good.night.util;

import org.apache.log4j.Logger;

/**
 * 日志工具
 * 
 * @Description:com.good.night.util.LoggerUtil
 * @author zhangxc email: zhangxicheng@lizi-inc.com
 * @date 2015年12月29日 下午2:25:44
 */
public class LoggerUtil {
	public static Logger getLogger(Class<?> clazz) {
		return Logger.getLogger(clazz);
	}

	private LoggerUtil() {
	}
}
