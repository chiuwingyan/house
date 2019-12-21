package store.zabbix.dao;

import java.util.List;

import store.zabbix.pojo.QueryVo;
import store.zabbix.pojo.Solve;

public interface SolveMapper {
	public List<Solve> selectall(QueryVo vo);
	public Integer selectcount(QueryVo vo);
	public void deletesolve(Integer id);
	public void insertsolve(Solve solve);
}
