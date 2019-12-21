package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.Applyout;
import store.zabbix.pojo.Zulist;

public interface ApplyoutService {
	public void insertapplyout(Zulist zulist);
	List<Applyout> findallapplyout();
	public void updateapplyout(Applyout applyout);
	public void agreeapplyout(Integer id);
	public void deleteapplyout(Integer id);
}
