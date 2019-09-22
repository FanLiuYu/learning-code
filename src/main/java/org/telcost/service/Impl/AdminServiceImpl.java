package org.telcost.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telcost.entity.Admin;
import org.telcost.mapper.AdminMapper;
import org.telcost.service.AdminService;
@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminMapper adminMapper;
	public Admin getAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminMapper.loginAdmin(admin);
	}

	public boolean updateAdminPassword(Admin admin) {
		// TODO 自动生成的方法存根
		int i = adminMapper.updateAdminPassword(admin);
		if(i>0) return true;
		return false;
	}

	@Override
	public boolean updateAdminInfo(Admin admin) {
		// TODO 自动生成的方法存根
		int i = adminMapper.updateAdminInfo(admin);
		if(i>0) return true;
		return false;
	}

	
}

