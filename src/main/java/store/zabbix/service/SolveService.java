package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.QueryVo;
import store.zabbix.pojo.Solve;
import store.zabbix.pojo.Wrong;

public interface SolveService {
	public List<Solve> selectall(QueryVo vo);
	public Integer selectcount(QueryVo vo);
	public void deletesolve(Integer id);
	
	public List<Wrong> findwrong(QueryVo vo);
	public Wrong findbyid(Integer id);
	 public void insertwrong(Wrong wrong);
	 public void gotosolve(Integer id, Solve solve);
}
