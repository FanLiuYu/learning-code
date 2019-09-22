package org.telcost.service;

import java.util.List;

import org.telcost.entity.Pow;

public interface PowService {
	/**
	 * 获取所有权限
	 * @return
	 */
	List<Pow> getAllPowName();

}
