package store.zabbix.dao;

import java.util.List;

import store.zabbix.pojo.Houselist;
import store.zabbix.pojo.QueryVo;

public interface HouselistMapper {
List<Houselist> selectAll();
public Integer findhouselistByVoCount(QueryVo vo);
Houselist findhouseid(String houseid);
void inserthouse(Houselist houselist);
void deletehouse(int id);
Houselist findid(int id);
Houselist findhouseidupdate(Houselist houselist);
void updatehouse(Houselist houselist);
void updatehousestatus(Houselist houselist);
public void deletehousebyhouseid(String house_id);
public void updatestatus(Houselist houselist);
}
