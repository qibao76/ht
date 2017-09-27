package cn.tarena.ht.service;

import java.io.*;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tarena.ht.mapper.DeptMapper;
import cn.tarena.ht.pojo.Dept;
@Service("deptService")
public class DeptServiceImpl implements DeptService {
	
	@Resource
	private DeptMapper deptMapper;
	
	 
	public List<Dept> findDeptList() {
		
		return deptMapper.findDeptList();
	}

	 
	public void updateState(String[] deptIds, int state) {
		
		deptMapper.updateState(deptIds,state);
		
	}

	 
	public void deleteDepts(String[] deptIds) {
		deptMapper.deleteDepts(deptIds);
		
	}

	 
	public void saveDept(Dept dept){
		//设置状态
		dept.setState(1);
		//设置创建日期
		dept.setCreateTime(new Date());
		deptMapper.saveDept(dept);
		
	}

	 
	public Dept findDeptByID(String deptId) {
		
		return deptMapper.findDeptByID(deptId);
	}

}
