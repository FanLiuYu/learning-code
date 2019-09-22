package org.telcost.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telcost.entity.Admin;
import org.telcost.entity.Pow;
import org.telcost.entity.Role;
import org.telcost.service.PowService;
import org.telcost.service.RoleService;
@Controller("roleController")
public class RoleController {
	@Autowired
	RoleService roleService;
	@Autowired
	PowService powService;
	
	@RequestMapping("ShowAdminInform")
	 public String ShowAllRole(HttpSession session) {
		List<Role> lr = roleService.getAllRole();
		session.setAttribute("roleList", lr);
		return "forward:/view/role/role_list.jsp";
	 }
		
	@RequestMapping("addRole")
	public String AddRole(HttpSession session) {
		List<Pow> lp = powService.getAllPowName();
		session.setAttribute("powList", lp);
		return "forward:/view/role/role_add.jsp";	
	}
	
	@RequestMapping("AddRoleAndRolePow")
	public String AddRoleAndRolePow(HttpSession session , String roleName , String[] pows) {
		List<Pow> lp = new ArrayList<Pow>();
		for(String  priv : pows) {
			Pow p = new Pow();
			p.setPid(Integer.parseInt(priv));
			lp.add(p);
		}
		Role role = new Role();
		role.setRname(roleName);
		role.setLp(lp);		
		roleService.addRole(role);
		return "forward:/view/role/role_add.jsp";
	}
	
	@RequestMapping("UpdateShowRoleName")
	public String UpdateShowRoleName(HttpSession session,int rid,String roleName,String[] pows) {
		Admin admin = (Admin) session.getAttribute("ad");
		Role role = roleService.getRoleNameByRid(rid);
		List<Pow> lp = powService.getAllPowName();
		session.setAttribute("powList", lp);
		session.setAttribute("role", role);
		return "forward:/view/role/role_modi.jsp";
	}
	
	@RequestMapping("UpdateRoleMessage")
	public String UpdateRoleMessage(HttpSession session , String roleName , String[] pows , int rid) {
		System.out.println(pows.length+"77777777777777777777777777777777");
		List<Pow> lp = new ArrayList<Pow>();
		for(String  priv : pows) {
			Pow p = new Pow();
			p.setPid(Integer.parseInt(priv));
			lp.add(p);
		}
		Role role = new Role();
		role.setRid(rid);
		role.setRname(roleName);
		role.setLp(lp);	
		roleService.updateRole(role);
		return "forward:/view/role/role_add.jsp";
	}
	
	@RequestMapping("deleteRole")
	public String deleteRole(int rid) {
		roleService.deleteRole(rid);
		return "forward:/view/role/role_list.jsp";
	}
}
