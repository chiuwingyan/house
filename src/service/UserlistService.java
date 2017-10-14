package service;

import java.util.List;

import Pojo.Userlist;

public interface UserlistService {
	Userlist findhasuserlist(Integer user_id);
	Userlist checkuserlist(String idcard);
	void insertuserlist(Userlist userlist);
	void updateuserlist(Userlist userlist);
	Userlist finduserlistupdate(Userlist userlist);
	public List<Userlist> getUserzuList(Integer id);
	public List<Userlist> getmycheckout(Integer id);
	public List<Userlist> getmyapply(Integer id);
	public List<Userlist> getmyapplyout(Integer id);
	public List<Userlist> findalluserlist();

	public void deleteuserlist(Integer id);
}
