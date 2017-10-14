package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Pojo.Userlist;
import dao.UserlistMapper;

@Service
@Transactional
public class UserlistServiceImpl implements UserlistService {

	@Autowired
	private UserlistMapper userlistMapper;
	@Override
	public Userlist findhasuserlist(Integer user_id) {
		Userlist userlist=userlistMapper.findhasuserlist(user_id);
		return userlist;
	}
	@Override
	public Userlist checkuserlist(String idcard) {
		Userlist userlist=userlistMapper.checkuserlist(idcard);
		return userlist;
	}
	@Override
	public void insertuserlist(Userlist userlist) {
		userlistMapper.insertuserlist(userlist);
		
	}
	@Override
	public void updateuserlist(Userlist userlist) {
		userlistMapper.updateuserlist(userlist);
		
	}
	@Override
	public Userlist finduserlistupdate(Userlist userlist) {
		Userlist list=userlistMapper.finduserlistupdate(userlist);
		return list;
	}
	@Override
	public List<Userlist> getUserzuList(Integer id) {
		List<Userlist> userlist=userlistMapper.getUserzuList(id);
		for(Userlist list:userlist){
			System.out.println(list);
		}
		return userlist;
	}
	@Override
	public List<Userlist> getmycheckout(Integer id) {
		List<Userlist> list=userlistMapper.getmycheckout(id);
		return list;
	}
	@Override
	public List<Userlist> getmyapply(Integer id) {
		List<Userlist> list=userlistMapper.getmyapply(id);
		return list;
	}
	@Override
	public List<Userlist> getmyapplyout(Integer id) {
		List<Userlist> list=userlistMapper.getmyapplyout(id);
		return list;
	}
	@Override
	public List<Userlist> findalluserlist() {
		List<Userlist> list=userlistMapper.findalluserlist();
		return list;
	}
	
	@Override
	public void deleteuserlist(Integer id) {
		userlistMapper.deleteuserlist(id);
		userlistMapper.deleteuser(id);
	}

}
