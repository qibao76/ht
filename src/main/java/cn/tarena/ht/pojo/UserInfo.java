package cn.tarena.ht.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserInfo extends BaseEntity{
	private UserInfo manager;		//上级领导 一对一
	
	private String userInfoId;		//用户ID
	private String name;			//真是姓名
	private String cardNo;			//身份证号
	private Date joinDate;			//入职时间
	private double salary;			//薪资
	private Date birthday;			//生日
	private String gender;			//性别
	private String station;			//岗位
	private String telephone;		//电话
	private String userLevel;		//用户级别  4-普通用户 3-部门经理 2-副总 1-总经理
	private String remark;			//备注信息
	private int orderNo;			//排序
	public UserInfo getManager() {
		return manager;
	}
	public void setManager(UserInfo manager) {
		this.manager = manager;
	}
	public String getUserInfoId() {
		return userInfoId;
	}
	public void setUserInfoId(String userInfoId) {
		this.userInfoId = userInfoId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) throws ParseException {
		if (joinDate!=null||joinDate.trim().length()!=0) {
			this.joinDate = new SimpleDateFormat("yyyy-MM-dd").parse(joinDate);
		}
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) throws ParseException {
		if (birthday!=null||birthday.trim().length()!=0) {
			this.birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		}
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	
	  
}
