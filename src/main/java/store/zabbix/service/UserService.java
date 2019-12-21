package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.User;

public interface UserService {

	public List<User> userList() throws Exception;
	public User login(User user) throws Exception;
	
}
