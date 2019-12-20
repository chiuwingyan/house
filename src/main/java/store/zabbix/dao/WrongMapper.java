package store.zabbix.dao;

import java.util.List;

import store.zabbix.pojo.QueryVo;
import store.zabbix.pojo.Wrong;

public interface WrongMapper {
  public List<Wrong> findwrong(QueryVo vo);
  public Wrong findbyid(Integer id);
  public void insertwrong(Wrong wrong);
  public void deletewrong(Integer id);
}
