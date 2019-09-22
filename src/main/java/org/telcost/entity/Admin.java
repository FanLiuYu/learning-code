package org.telcost.entity;

import java.sql.Date;
import java.util.List;

import lombok.Data;
@Data
public class Admin {
	/**
	 * 管理员id
	 */
	private Integer aid;
	/**
	 * 管理员姓名
	 */
	private String aname;
	/**
	 * 管理员密码
	 */
	private String apwd;
	/**
	 * 管理员账号
	 */
	private String acname;	
	/**
	 * 管理员电话
	 */
	private String atel;
	/**
	 * 管理员邮箱地址
	 */
	private String aemail;
	/**
	 * 管理员头像
	 */
	private String eimg;
	
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 创建者
	 */
	private String createUser;
	/**
	 * 修改时间
	 */
	private Date updatetime;
	/**
	 * 修改人
	 */
	private String updateUser;
	private String by01;
	private String by02;
	private String by03;
	private String by04;
	
	private List<Pow> lp;
	private List<Role> lr;
	
	public String getRoleName() {
		String roleName = "";
		if(lr != null) {
			for(Role r : lr) {
				roleName += r.getRname() + ",";
			}
		}
		return roleName;		
	}
	
	/*public Admin() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	public Admin(Integer aid) {
		this.aid = aid;
	}
	
	public Admin(String apwd) {
		this.apwd = apwd;
	}
	

	public Admin(String acname, String apwd) {
		this.apwd = apwd;
		this.acname = acname;
	}

	public Admin(Integer aid, String aname, String atel, String email) {
		this.aid = aid;
		this.aname = aname;
		this.atel = atel;
		this.email = email;
	}
	
	public Admin(Integer aid, String aname, String apwd, String acname, String atel, String email, Date createtime) {
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.acname = acname;
		this.atel = atel;
		this.email = email;
		this.createtime = createtime;
	}
	
	public Admin(Integer aid, String aname, String apwd, String acname, String atel, String email) {
		this.aid = aid;
		this.aname = aname;
		this.apwd = apwd;
		this.acname = acname;
		this.atel = atel;
		this.email = email;
	}
	
	public Admin(String aname, String atel, String email,  String acname, String apwd) {
		this.aname = aname;
		this.atel = atel;
		this.email = email;
		this.apwd = apwd;
		this.acname = acname;		
	}*/
}
