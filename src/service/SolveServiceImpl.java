package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Pojo.QueryVo;
import Pojo.Solve;
import Pojo.Wrong;
import dao.SolveMapper;
import dao.WrongMapper;
@Service
@Transactional
public class SolveServiceImpl implements SolveService {
	@Autowired
	private SolveMapper solveMapper;
	@Autowired
	private WrongMapper wrongMapper;
	@Override
	public List<Solve> selectall(QueryVo vo) {
		List<Solve> list=solveMapper.selectall(vo);
		return list;
	}
	@Override
	public Integer selectcount(QueryVo vo) {
		Integer count=solveMapper.selectcount(vo);
		return count;
	}
	@Override
	public void deletesolve(Integer id) {
		solveMapper.deletesolve(id);
		
	}
	
	@Override
	public List<Wrong> findwrong(QueryVo vo) {
		List<Wrong> list=wrongMapper.findwrong(vo);
		return list;
	}
	@Override
	public Wrong findbyid(Integer id) {
		Wrong wrong=wrongMapper.findbyid(id);
		return wrong;
	}
	@Override
	public void insertwrong(Wrong wrong) {
		wrong.setStatus("待处理");
		wrongMapper.insertwrong(wrong);
		
	}
	@Override
	public void gotosolve(Integer id, Solve solve) {
		solveMapper.insertsolve(solve);
		wrongMapper.deletewrong(id);
		
	}

}
