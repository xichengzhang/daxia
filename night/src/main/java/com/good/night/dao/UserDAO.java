/**
 * 
 */
package com.good.night.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

import com.good.night.bean.User;

/**
 * @Description:com.good.night.dao.UserDAO
 * @author zhangxc  email: zhangxicheng@lizi-inc.com
 * @date 2015年12月25日 下午6:06:33 
 */
@DAO
public interface UserDAO {
	String FIEDLS = "id,exhibition_id,create_time,update_time,name,title,pwd,mobile,company,wx_open_id,device_token,chn,mode,remark";
	String INSERT_FIEDLS = "exhibition_id,create_time,update_time,name,title,pwd,mobile,company,wx_open_id,device_token,chn,mode,remark";
	
	@SQL("select " + FIEDLS + " from ##(:table_name) where exhibition_id=:2 order by create_time limit :3,:4")
	public List<User> getUsers(@SQLParam("table_name") String table_name, long exhibition_id, int start, int offset);
	
	@SQL("select " + FIEDLS + " from ##(:table_name) where id = :2")
	public User getUser(@SQLParam("table_name") String table_name, long id);
	
	@SQL("select " + FIEDLS + " from ##(:table_name) where wx_open_id=:2 and exhibition_id=:3")
	public User getUserByOpenID(@SQLParam("table_name") String table_name, String open_id, long exhibition_id);
	
	@SQL("select " + FIEDLS + " from ##(:table_name) where mobile=:2 and exhibition_id=:3")
	public User getUserByPhone(@SQLParam("table_name") String table_name, String phone, long exhibition_id);

	@ReturnGeneratedKeys
	@SQL("insert into ##(:table_name) (" + INSERT_FIEDLS + ") values (:2.exhibition_id,now(),now(),:2.name,:2.title,:2.pwd,:2.mobile,:2.company,:2.wx_open_id,:2.device_token,:2.chn,:2.mode,:2.remark)")
	public Long addUser(@SQLParam("table_name") String table_name, User user);
	
	@SQL("update ##(:table_name) set exhibition_id=:2.exhibition_id,update_time=now(),name=:2.name,title=:2.title,mobile=:2.mobile,pwd=:2.pwd,company=:2.company,wx_open_id=:2.wx_open_id,device_token=:2.device_token,chn=:2.chn,mode=:2.mode,remark=:2.remark where id=:2.id")
	public Integer updateUser(@SQLParam("table_name") String table_name, User user);
	
	@SQL("update ##(:table_name) set exhibition_id=:2.exhibition_id,update_time=now(),name=:2.name,title=:2.title,mobile=:2.mobile,pwd=:2.pwd,company=:2.company,wx_open_id=:2.wx_open_id,device_token=:2.device_token,chn=:2.chn,mode=:2.mode,remark=:2.remark where id=:3")
	public Integer updateUser(@SQLParam("table_name") String table_name, User user, long id);
	
	@SQL("delete from ##(:table_name) where id = :2")
	public Integer delUser(@SQLParam("table_name") String table_name, long id);
	
	@SQL("select count(1) from ##(:table_name) where exhibition_id=:2")
	public Integer countUser(@SQLParam("table_name") String table_name, long exhibition_id);

	@SQL("select " + FIEDLS + " from ##(:table_name) where device_token=:2 and exhibition_id=:3")
	public List<User> getUserBydeviceToken(@SQLParam("table_name") String table_name, String device_token,long exhibition_id);
	
	@SQL("select " + FIEDLS + " from ##(:table_name) where mobile=:2 and pwd=:3 and exhibition_id=:4")
	public User getUserByPhonePwd(@SQLParam("table_name") String table_name, String phone, String pwd, long exhibition_id);

	@SQL("delete from ##(:table_name) where mobile = :2")
	int delByPhone(@SQLParam("table_name") String tableName, String mobile);

}
