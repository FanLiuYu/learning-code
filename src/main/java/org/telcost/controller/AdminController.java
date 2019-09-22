package org.telcost.controller;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.telcost.entity.Admin;
import org.telcost.service.AdminService;
import org.telcost.service.PowService;
import org.telcost.service.RoleService;

@Controller("adminController")
public class AdminController {
	 @Autowired
	 AdminService adminService;
	 
	 @RequestMapping("/logAdmin")
     public String loginAdmin(Admin admin,HttpSession session){
   		Admin am = adminService.getAdmin(admin);
   		if(am!=null) {
   			session.setAttribute("ad",am);
   			System.out.println(am.getLp());
   			return "redirect:/view/index.jsp";
   		}
   	   return "redirect:/view/login.jsp";
	  }
	 
	 @RequestMapping("/updateAdminPassword")
	 public String updateAdminPassword(HttpSession session,String newPwd,String oldPwd ,String renewPwd,Model model) {	 
		 Admin admin = (Admin) session.getAttribute("ad");
		 System.out.println(admin.getAcname());
		 if(oldPwd==""||newPwd==""||renewPwd=="") return "forward:/view/user/user_modi_pwd.jsp";
		 if(oldPwd.equals(admin.getApwd())) {
			 if(newPwd.equals(renewPwd)) {
				 admin.setApwd(newPwd);
				 adminService.updateAdminPassword(admin);	
				 return "redirect:/view/login.jsp";
			 }else {
				 model.addAttribute("errorMsg", "两次新密码输入不一致！");
			 }			
		 }else {
			 model.addAttribute("errorMsg1", "旧密码输入错误!");
			 return "forward:/view/user/user_modi_pwd.jsp";
		 }
		return "forward:/view/user/user_modi_pwd.jsp";		
	 }
	 
	 @RequestMapping("/UpdateAdminInform")
	 public String UpdateAdminInform(HttpSession session,String aname,String atel,String aemail,String createtime) {
		 Admin admin = (Admin) session.getAttribute("ad");
		 admin.setAname(aname);
		 admin.setAemail(aemail);
		 admin.setAtel(atel);
		 adminService.updateAdminInfo(admin);
		 return "forward:/view/user/user_info.jsp";
	 }
	 
	 @RequestMapping("/existServlet")
	 public String existServlet() {
		 return "redirect:/view/login.jsp";
	 }	 
}
