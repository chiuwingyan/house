package dao;

import java.util.List;

import Pojo.QueryVo;
import Pojo.Wrong;

public interface WrongMapper {
  public List<Wrong> findwrong(QueryVo vo);
  public Wrong findbyid(Integer id);
  public void insertwrong(Wrong wrong);
  public void deletewrong(Integer id);
}
