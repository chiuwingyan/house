package store.zabbix.dao;

import java.util.List;

import store.zabbix.pojo.QueryVo;
import store.zabbix.pojo.Topaid;

public interface TopaidMapper {
public void inserttopaid(Topaid topaid);
public List<Topaid> findtopaid(QueryVo vo);
public Topaid findbyid(Integer id);
public void deletetopaid(Integer id);
}
