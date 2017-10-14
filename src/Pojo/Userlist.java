package Pojo;

import java.util.List;

public class Userlist {
private Integer id;
private String name;
private String idcard;
private String phone;
private Integer user_id;
private List<Apply> apply;
private List<Zulist> zulist;
private List<Checkout> checkout;
private List<Applyout> applyout;
private User user;

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public List<Applyout> getApplyout() {
	return applyout;
}
public void setApplyout(List<Applyout> applyout) {
	this.applyout = applyout;
}
public List<Checkout> getCheckout() {
	return checkout;
}
public void setCheckout(List<Checkout> checkout) {
	this.checkout = checkout;
}
public List<Zulist> getZulist() {
	return zulist;
}
public void setZulist(List<Zulist> zulist) {
	this.zulist = zulist;
}
public List<Apply> getApply() {
	return apply;
}
public void setApply(List<Apply> apply) {
	this.apply = apply;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIdcard() {
	return idcard;
}
public void setIdcard(String idcard) {
	this.idcard = idcard;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public Integer getUser_id() {
	return user_id;
}
public void setUser_id(Integer user_id) {
	this.user_id = user_id;
}

}
