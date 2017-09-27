package cn.tarena.ht.pojo;

public class User extends BaseEntity{
	
	private String userId;
	private String username;
	private String password;
	private int state;
	private Dept dept;		//一对一关联部门信息
	private UserInfo userInfo;  //一对一关联



	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {

		
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
	  
}
