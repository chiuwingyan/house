package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.Schedule;

public interface ScheduleService {
	public void insertschedule(Schedule schedule);
	public List<Schedule> selectAll();
	public void deleteschedule(Integer id);
	public void updateschedule(Schedule schedule);
	public Schedule selectbyid(Integer id);
}
