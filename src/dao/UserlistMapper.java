package dao;

import java.util.List;

import Pojo.Userlist;

public interface UserlistMapper {
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
	public void deleteuser(Integer id);
	public void deleteuserlist(Integer id);
}
