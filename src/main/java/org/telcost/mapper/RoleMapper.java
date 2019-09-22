package org.telcost.mapper;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.telcost.entity.Role;
@Repository("roleMapper")
public interface RoleMapper {
	/**
	 * 查询当前用户角色
	 * @param aid
	 * @return
	 */
	public List<Role> getAllRole(int aid);
	/**
	 * 查询所有用户角色
	 * @return
	 */
	public List<Role> selectAllRole();
	/**
	 * 插入角色权限
	 * @param role
	 */
	public void insertRolePriv(Role role);
	/**
	 * 插入角色
	 * @param role
	 * @return
	 */
	public int insertRole(Role role);
	/**
	 * 通过Rid获取角色名
	 * @param rid
	 * @return
	 */
	public Role getRoleNameByRid(int rid);
	/**
	 * 修改角色名字
	 * @param role
	 * @return
	 */
	public int updateRoleName(Role role);
	/**
	 * 删除角色权限（修改）
	 * @param rid
	 * @return
	 */
	public int deleteRolePows(Integer rid);
	/**
	 * 插入角色权限（修改）
	 * @param role
	 * @return
	 */
	public int insertRolePows(Role role);
	/**
	 * 删除角色
	 * @param rid
	 * @return
	 */
	public int  deleteRole(int rid);

}
