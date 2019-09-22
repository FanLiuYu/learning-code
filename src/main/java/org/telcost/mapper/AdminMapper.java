package org.telcost.mapper;
import org.springframework.stereotype.Repository;
import org.telcost.entity.Admin;
@Repository("adminMapper")
public interface AdminMapper {
	/**
	 * 用户登录
	 * @param admin
	 * @return
	 */
	public Admin loginAdmin(Admin admin);
	/**
	 * 修改用户密码
	 * @param admin
	 * @return
	 */
	public int updateAdminPassword(Admin admin);
	/**
	 * 修改用户信息
	 * @param admin
	 * @return
	 */
	public int updateAdminInfo(Admin admin);
}
