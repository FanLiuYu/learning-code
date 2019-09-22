package org.telcost.entity;

import java.util.List;

import lombok.Data;

@Data
public class Pow {
	private Integer pid;
	private String pclass;
	private String purl;
	private List<Pow> lp;
	private String pname;
	
	/*public Pow() {
		
	}
	
	public Pow(Integer pid) {
		this.pid = pid;
	}
	public Pow(String purl) {
		this.purl = purl;
	}

	public Pow(Integer pid, String pclass, String purl) {
		this.pid = pid;
		this.pclass = pclass;
		this.purl = purl;
	}*/
}
