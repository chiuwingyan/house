package service;

import java.util.List;

import Pojo.Applyout;
import Pojo.Checkout;
import Pojo.Zulist;

public interface CheckoutService {
public void insertcheckout(Checkout checkout);
public List<Checkout> getallcheckout();
public void deletecheckout(Integer id);
}
