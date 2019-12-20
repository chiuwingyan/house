package store.zabbix.service;

import java.util.List;

import store.zabbix.pojo.Checkout;

public interface CheckoutService {
    void insertcheckout(Checkout checkout);

    List<Checkout> getallcheckout();

    void deletecheckout(Integer id);
}
