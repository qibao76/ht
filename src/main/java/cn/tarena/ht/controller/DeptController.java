package cn.tarena.ht.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.tarena.ht.pojo.Dept;
import cn.tarena.ht.service.DeptService;

@Controller
@RequestMapping("/sysadmin/dept/")
public class DeptController extends BaseController{
	
	@Resource
	private DeptService deptService;
	
	//需要显示部门列表信息
	@RequestMapping("list")
	public String findDeptList(Model model){
		List<Dept> dataList = deptService.findDeptList();
		model.addAttribute("deptList", dataList);
		System.out.println(dataList);
		//实现页面跳转
		return "sysadmin/dept/jDeptList";
	}
	
	
	
	//状态停用
	@RequestMapping("stop")
	public String toStop(@RequestParam("deptId") String[] deptIds){
		int state = 0;	//状态停用
		deptService.updateState(deptIds,state);
		
		//需要重定向到部门列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//状态启用
	@RequestMapping("start")
	public String toStart(@RequestParam("deptId") String[] deptIds){
		int state = 1;	//状态停用
		deptService.updateState(deptIds,state);
		//需要重定向到部门列表页面
		return "redirect:/sysadmin/dept/list";
	}
	
	//批量删除
	@RequestMapping("delete")
	public String delete(@RequestParam("deptId")String[] deptIds){
		deptService.deleteDepts(deptIds);
		return "redirect:/sysadmin/dept/list";
	}
	
	
	//转向部门新增页面
	@RequestMapping("tocreate")
	public String tocreate(Model model){
		//需要准备上级部门列表
		List<Dept> dataList = deptService.findDeptList();
		model.addAttribute("deptList", dataList);
		//转向页面
		return "sysadmin/dept/jDeptCreate";
	}
	
	@RequestMapping("save")
	public String save(Dept dept){
		deptService.saveDept(dept);
		
		return "redirect:/sysadmin/dept/list";
	}
	
	//一次选中一个值进行查看
	@RequestMapping("toview")
	public String toview(String deptId,Model model){
		//根据Id 查询部门信息
		Dept dept = deptService.findDeptByID(deptId);
		model.addAttribute("dept", dept);
		
		//转向查看页面
		return "sysadmin/dept/jDeptView";
	}
	
}
