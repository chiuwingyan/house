package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Pojo.Zulist;
import dao.HouselistMapper;
import dao.ZulistMapper;

@Service
public class ZulistServiceImpl implements ZulistService {
	
	@Autowired
	private ZulistMapper zulistMapper;
	
	@Override
	public void insertzulist(Zulist zulist) {
		zulistMapper.insertzulist(zulist);
		
	}

	@Override
	public List<Zulist> findzuuserlist() throws Exception {
		List<Zulist> zulist=zulistMapper.findzuuserlist();
		
		return zulist;
	}

	@Override
	public Zulist findzulist(String house_id) {
		Zulist zulist=zulistMapper.findzulist(house_id);
		return zulist;
	}

	@Override
	public void deletezulist(String house_id) {
		zulistMapper.deletezulist(house_id);
		
	}

	@Override
	public List<Zulist> findzulistbyuid(Integer userlist_id) {
		List<Zulist> zulist=zulistMapper.findzulistbyuid(userlist_id);
		return zulist;
	}

}
