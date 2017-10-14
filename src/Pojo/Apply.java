package Pojo;

public class Apply {
private Integer id;
private String house_id;
private String address;
private double area;
private double price;
private Integer userlist_id;
private String status;
private Userlist userlist;
public Userlist getUserlist() {
	return userlist;
}
public void setUserlist(Userlist userlist) {
	this.userlist = userlist;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getHouse_id() {
	return house_id;
}
public void setHouse_id(String house_id) {
	this.house_id = house_id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getArea() {
	return area;
}
public void setArea(double area) {
	this.area = area;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Integer getUserlist_id() {
	return userlist_id;
}
public void setUserlist_id(Integer userlist_id) {
	this.userlist_id = userlist_id;
}
@Override
public String toString() {
	return "Apply [id=" + id + ", house_id=" + house_id + ", address=" + address + ", area=" + area + ", price=" + price
			+ ", userlist_id=" + userlist_id + ", status=" + status + ", userlist=" + userlist + "]";
}



}
