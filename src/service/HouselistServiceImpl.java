package service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import Pojo.Houselist;
import Pojo.QueryVo;
import dao.HouselistMapper;

@Service
public class HouselistServiceImpl implements HouselistService {
	
	@Autowired
	private HouselistMapper houselistMapper;
	
	@Override
	public List<Houselist> selectAll() {
		List<Houselist> houselist=houselistMapper.selectAll();
		return houselist;
	}

	@Override
	public Houselist findhouseid(String houseid) {
		Houselist houselist=houselistMapper.findhouseid(houseid);
		return houselist;
	}

	@Override
	public void inserthouse(Houselist houselist) {
		// TODO Auto-generated method stub
		houselistMapper.inserthouse(houselist);
	}

	@Override
	public void deletehouse(int id) {
		// TODO Auto-generated method stub
		houselistMapper.deletehouse(id);
	}

	@Override
	public Houselist findhouseidupdate(Houselist houselist) {
		Houselist list=houselistMapper.findhouseidupdate(houselist);
		return list;
	}

	@Override
	public void updatehouse(Houselist houselist) {
		houselistMapper.updatehouse(houselist);
		
	}

	@Override
	public Houselist findid(int id) {
		Houselist list=houselistMapper.findid(id);
		return list;
	}

	@Override
	public void updatehousestatus(Houselist houselist) {
		// TODO Auto-generated method stub
		houselistMapper.updatehousestatus(houselist);
	}

	@Override
	public void deletehousebyhouseid(String house_id) {
		houselistMapper.deletehousebyhouseid(house_id);
		
	}

	

}
