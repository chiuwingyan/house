package store.zabbix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import store.zabbix.pojo.Hetong;
import store.zabbix.dao.HetongMapper;

@Service
@Transactional
public class HetongServiceImpl implements HetongService {
	@Autowired
	private HetongMapper hetongMapper;
	
	@Override
	public void inserthetong(Hetong hetong) {
		hetongMapper.inserthetong(hetong);
		
	}

	@Override
	public Hetong findhetong(String house_id) {
		Hetong hetong=hetongMapper.findhetong(house_id);
		return hetong;
	}

	@Override
	public void updatehetong(Hetong hetong) {
		
		hetongMapper.updatehetong(hetong);
	}

	@Override
	public void deletehetong(String house_id) {
		// TODO Auto-generated method stub
		hetongMapper.deletehetong(house_id);
		
	}
	
}
