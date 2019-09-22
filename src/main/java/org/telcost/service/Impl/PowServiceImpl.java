package org.telcost.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telcost.entity.Pow;
import org.telcost.mapper.PowMapper;
import org.telcost.service.PowService;
@Service("powService")
public class PowServiceImpl implements PowService {
	@Autowired
	PowMapper powMapper;
	
	public List<Pow> getAllPowName() {
		// TODO 自动生成的方法存根
		return powMapper.getAllPowInRole();
	}

}
