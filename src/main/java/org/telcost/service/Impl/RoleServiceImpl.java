package org.telcost.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telcost.entity.Admin;
import org.telcost.entity.Pow;
import org.telcost.entity.Role;
import org.telcost.mapper.PowMapper;
import org.telcost.mapper.RoleMapper;
import org.telcost.service.RoleService;
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleMapper roleMapper;
	@Autowired
	PowMapper powMapper;
	
	public List<Role> getAllRole() {
		// TODO 自动生成的方法存根
		List<Role> lr = roleMapper.selectAllRole();
		for(Role r : lr) {
			List<Pow> lp = powMapper.selectPowByRid(r.getRid());
			r.setLp(lp);
		}
		return lr;
	}

	@Override
	public boolean addRole(Role role) {
		List<Role> lr = roleMapper.selectAllRole();
		role.setRid(lr.size()+1);//添加到role对象中
		int i = roleMapper.insertRole(role);//获取返回自动生成的id值	
		
		List<Pow> lp = role.getLp();
		for(Pow pow : lp) {
			role.setPid(pow.getPid());
			roleMapper.insertRolePriv(role);
		}
		//添加关联表中
		if(i>0) return true;
		return false;
	}

	@Override
	public Role getRoleNameByRid(int rid) {
		Role role = roleMapper.getRoleNameByRid(rid);
		List<Pow> lp = powMapper.selectPowByRid(rid);
		role.setLp(lp);
		return role;
	}

	@Override
	public boolean updateRole(Role role) {
		int i =  roleMapper.updateRoleName(role);
		int j = roleMapper.deleteRolePows(role.getRid());
		int k = 0;
		List<Pow> lp = role.getLp();
		for(Pow pow : lp) {
			role.setPid(pow.getPid());
			k = roleMapper.insertRolePows(role);
		}		
		return i+j+k>=3?true:false;
	}

	@Override
	public boolean deleteRole(int rid) {
		// TODO 自动生成的方法存根
		int i = roleMapper.deleteRolePows(rid);
		int j = roleMapper.deleteRole(rid);
		if(i+j>2) return true;
		return false;
	}

}
