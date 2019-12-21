package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.Apply;
import store.zabbix.pojo.Houselist;

public interface ApplyService {
	
	public void insertapply(Apply apply);
	public List<Apply> findapplylist() throws Exception;
	Apply findbyhouse_id(String house_id);
	public void deletebyhouse_id(String house_id);
	public void refuseapply(Houselist houselist);
}
