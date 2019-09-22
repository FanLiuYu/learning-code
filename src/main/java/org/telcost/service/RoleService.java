package org.telcost.service;

import java.util.List;

import org.telcost.entity.Admin;
import org.telcost.entity.Role;

public interface RoleService {
	/**
	 * 获取所有角色信息
	 * @return
	 */
	List<Role> getAllRole();
	/**
	 * 添加角色
	 * @param role
	 * @return
	 */
	boolean addRole(Role role);
	/**
	 * 通过Aid获取角色名
	 * @param admin
	 * @return
	 */
	Role getRoleNameByRid(int rid);
	/**
	 * 修改角色信息
	 * @param role
	 * @return
	 */
	boolean updateRole(Role role);
	/**
	 * 删除选中角色
	 * @param rid
	 * @return
	 */
	boolean deleteRole(int rid);
	
}
