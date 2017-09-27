package cn.tarena.ht.pojo;

public class Role extends BaseEntity{
	private String roleId;
	private String name;
	private String remarks;
	private int orderNo;
	private String checked;
	
	//为了数据回显 设置checked属性
	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
	//为了转变json字符串  多一个id
	public String getRoleId() {
		return roleId;
	}
	
	//为了zTree展现效果，得到roleId
	public String getId(){
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	
}
