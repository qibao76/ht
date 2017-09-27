package cn.tarena.ht.pojo;

public class Dept extends BaseEntity{
	private String deptId;			//部门ID
	private Dept parentDept;		//上级部门对象
	private String deptName;		//部门名称
	private int state;				//状态 0停用  1启用
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public Dept getParentDept() {
		return parentDept;
	}
	public void setParentDept(Dept parentDept) {
		this.parentDept = parentDept;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
