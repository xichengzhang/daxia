/**
 * 
 */
package com.good.night.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.good.night.dao.UserDAO;



/**
 * @Description:com.good.night.service.UserService
 * @author zhangxc  email: zhangxicheng@lizi-inc.com
 * @date 2015年12月25日 下午6:17:53 
 */
@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	
}
