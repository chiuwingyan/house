package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.Paid;
import store.zabbix.pojo.QueryVo;
import store.zabbix.pojo.Topaid;

public interface TopaidService {
	public void inserttopaid(Topaid topaid);
	public List<Topaid> findtopaid(QueryVo vo);
	public Topaid findbyid(Integer id);
	public void gotopay(Integer id,Paid paid);
}
