package org.telcost.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.telcost.entity.Pow;
@Repository("powMapper")
public interface PowMapper {
	/**
	 * 查询所有用户权限
	 * @param aid
	 * @return
	 */
   public List<Pow> getAllPow(Integer aid);
   /**
    * 查询当前用户权限
    * @param rid
    * @return
    */
   public List<Pow> selectPowByRid(Integer rid);
   /**
    * 获取所有权限
    * @return
    */
   public List<Pow> getAllPowInRole();
}
