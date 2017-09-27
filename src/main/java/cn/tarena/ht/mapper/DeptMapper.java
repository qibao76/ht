package cn.tarena.ht.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.tarena.ht.pojo.Dept;

public interface DeptMapper {

	public List<Dept> findDeptList();
	
	/**Mybatis中多值参数传递时需要参数封装为map
	 * 只能接收一个参数  可以使用一个map  或者一个对象
	 * {deptIds:deptIds},
	 * {state:state}
	 */
	
	public void updateState(@Param("deptIds")String[] deptIds, @Param("state")int state);

	public void deleteDepts(String[] deptIds);

	public void saveDept(Dept dept);

	public Dept findDeptByID(String deptId);
	
}
