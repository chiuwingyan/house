package service;

import java.util.List;

import Pojo.Applyout;
import Pojo.Zulist;

public interface ApplyoutService {
	public void insertapplyout(Zulist zulist);
	List<Applyout> findallapplyout();
	public void updateapplyout(Applyout applyout);
	public void agreeapplyout(Integer id);
	public void deleteapplyout(Integer id);
}
