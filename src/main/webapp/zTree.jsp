<%@ page language="java" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="${ctx}/staticfile/components/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="${ctx}/staticfile/components/zTree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="${ctx}/staticfile/components/zTree/js/jquery.ztree.core-3.5.min.js"></script>
	<script type="text/javascript" src="${ctx}/staticfile/components/zTree/js/jquery.ztree.excheck-3.5.min.js"></script>
<SCRIPT type="text/javascript">

		/*Ztree树配置  */
		var setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			}
		};
		/*j就是页面需要展现的数据的json格式*/
		var z=[{"id":1,"name":"总公司",checked:true},{"id":2,"name":"子公司"}];
		var zNodes =[{name:"桌子","id":"1",checked:true},
		             {"name":"椅子",id:"2",checked:true},
		             {"name":"桌子1",id:"2",pId:1,checked:true},
		             {"name":"椅子1",id:"2",pId:2,checked:true},
		             {"name":"桌子2",id:"2",pId:1,checked:true},
		             {"name":"桌子3",id:"2",pId:1,checked:true},
		             {name:"板凳",id:"3",checked:true}]
		
		$(document).ready(function(){
			$.fn.zTree.init($("#htZtree"), setting, zNodes);

			var zTreeObj = $.fn.zTree.getZTreeObj("htZtree");
			zTreeObj.expandAll(true);		//展开所有树节点
		});
		
		
		
	</SCRIPT>

</head>

<body>
<h1>Ztree入门教例</h1>
<div style="padding:30px;">
		<ul id="htZtree" class="ztree"></ul>
</div>
 
</div>
 
 
</form>
</body>
</html>

