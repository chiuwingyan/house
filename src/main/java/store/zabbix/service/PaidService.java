package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.Paid;
import store.zabbix.pojo.QueryVo;
import store.zabbix.pojo.Zulist;

public interface PaidService {
	public List<Paid> selectall(QueryVo vo);
	public Double selectsum(QueryVo vo);
	public void deletepaid(Integer id);
	public List<Zulist> findzuuserlist() throws Exception;
	public Zulist findzukezulist(Integer id);
	
}
