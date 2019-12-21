package store.zabbix.dao;

import java.util.List;

import store.zabbix.pojo.Checkout;

public interface CheckoutMapper {
	public void insertcheckout(Checkout checkout);
	public List<Checkout> getallcheckout();
	public void deletecheckout(Integer id);
}
