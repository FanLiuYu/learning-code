package org.telcost.service;

import org.telcost.entity.Admin;
public interface AdminService {
	 /**
	  * 获取用户的数据
	  * @param admin
	  * @return
	  */
	 public Admin getAdmin(Admin admin);
	 /**
	  * 修改用户密码
	  * @param admin
	  * @return
	  */
	 public boolean updateAdminPassword(Admin admin);
	 /**
	  * 修改用户信息
	  * @param admin
	  * @return
	  */
	 public boolean updateAdminInfo(Admin admin);
}
