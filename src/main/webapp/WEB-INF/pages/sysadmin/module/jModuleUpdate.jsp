<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../baselist.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>模块更新</title>
</head>

<body>
<form name="icform" method="post">

<div id="menubar">
<div id="middleMenubar">
<div id="innerMenubar">
  <div id="navMenubar">
<ul>
	<li id="save"><a href="#" onclick="formSubmit('update','_self');this.blur();">更新</a></li>
	<li id="back"><a href="#" onclick="window.history.go(-1)">返回</a></li>
	
</ul>
  </div>
</div>
</div>
</div>
   
  <div class="textbox-title">
	<img src="../../staticfile/skin/default/images/icon/currency_yen.png"/>
    模块更新
  </div> 
  
<div>


<div class="eXtremeTable" >
<table id="ec_table" class="tableRegion" width="98%" >
	
	<!--隐藏域 保存模块ID  -->
	<tr>
		<td><input name="moduleId" value="${module.moduleId}" type="hidden"/></td>
	</tr>
	<tr class="odd">
		<td>权限标识</td>
		<td><input name="name" type="text" value="${module.name}"/></td>
	</tr>
	<tr class="odd">
		<td>模块类型</td>
		<td>
			<select name="ctype" style="width:121px">
				<option value="1"  <c:if test="${module.ctype ==1}">selected="selected"</c:if> >主菜单</option>
				<option value="2"  <c:if test="${module.ctype ==2}">selected="selected"</c:if>>左侧菜单</option>
				<option value="3"  <c:if test="${module.ctype ==3}">selected="selected"</c:if>>按钮</option>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>上级模块</td>
		<td>
			<select name="parentModule.moduleId" style="width:121px">
				<!--遍历部门list  -->
				<option value="">---无上级---</option>
				<c:forEach items="${moduleList}" var="m">
					<option value="${m.moduleId}" 
					<c:if test="${m.moduleId == module.parentModule.moduleId}">selected="selected"</c:if>
					  >${m.name}</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr class="odd">
		<td>排序号</td>
		<td><input name="orderNo" type="text" value="${module.orderNo}"/></td>
	</tr>
	<tr class="odd">
		<td>备注信息:</td>
		<td colspan="2">
			<textarea style="width:100%;height:120px" name="remark">
			${module.remark}	
			</textarea>
		</td>
	</tr>
	
</table>
</div>
 
</div>
 
 
</form>
</body>
</html>

