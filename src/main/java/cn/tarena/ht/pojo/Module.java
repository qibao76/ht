package cn.tarena.ht.pojo;

public class Module extends BaseEntity{
	private Module parentModule;	//上级模块
	private String moduleId;		//模块ID
	private String name;			//权限标识
	private int ctype;				//模块类型 1一级菜单 2左侧菜单 3按钮
	private int state;				//1启用 0停用
	private int orderNo;			//排序号
	private String remark;			//备注信息
	
	private String checked;
	//为zTree树 提供属性支持id
	public String getId(){
		return moduleId;
	}
	//准备父级Id
	public String getpId(){
		if(parentModule !=null){
			return parentModule.moduleId;
		}
		return "";
	}
	//节点数据回显
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getModuleId() {
		return moduleId;
	}
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCtype() {
		return ctype;
	}
	public void setCtype(int ctype) {
		this.ctype = ctype;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Module getParentModule() {
		return parentModule;
	}
	public void setParentModule(Module parentModule) {
		this.parentModule = parentModule;
	}
	
	
}
