package store.zabbix.dao;

import java.util.List;

import store.zabbix.pojo.Paid;
import store.zabbix.pojo.QueryVo;

public interface PaidMapper {
public List<Paid> selectall(QueryVo vo);
public Double selectsum(QueryVo vo);
public void deletepaid(Integer id);
public void insertpaid(Paid paid);
}
