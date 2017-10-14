package service;

import java.util.List;

import Pojo.User;
import Pojo.Userlist;

public interface UserService {

	public List<User> userList() throws Exception;
	public User login(User user) throws Exception;
	
}
