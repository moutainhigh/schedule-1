<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html lang="zh-cn">
<head>
<title>任务管理</title>
</head>

<body menuId="43">
	<!--Action boxes-->
	<div class="container-fluid">
		<hr>
		<div class="row-fluid">
			<div class="span12">
				<div class="widget-box">
					<div class="widget-title">
						<span class="icon"> <i class="fa fa-th"></i>
						</span>
						<h5></h5>
						<span class="label label-info">
						<u:authority menuId="1">
							<a href="javascript:;" onclick="add()">添加任务</a>
						</u:authority>
						</span>
						<div class="search">
						 	<form method="post" id="mainForm">
							<ul>
						   <li>
						   	<input type="text" name="text" value="<s:property value="#parameters.text"/>" maxlength="40" placeholder="任务id/任务名称/存储过程名称" class="txt_177" />
						   </li>
						   <%-- 
						   <li>
						       	<u:date id="start_date" value="${param.start_date}" placeholder="扫描开始时间" maxId="end_date" />
								<span>至</span>
						       	<u:date id="end_date" value="${param.end_date}" placeholder="扫描结束时间" minId="start_date" />
							</li>
							 --%>
						  <li>
							<u:select id="task_type" value="${param.task_type}" placeholder="任务类型" dictionaryType="task_type" />
						  </li>
						  <li>
							<u:select id="execute_type" value="${param.execute_type}" placeholder="执行类型" dictionaryType="task_execute_type" />
						  </li>
						   <%-- 
						  <li>
							<u:select id="scan_execute" value="${param.scan_execute}" placeholder="是否每次扫描都执行" dictionaryType="task_scan_execute" />
						  </li>
							 --%>
						  <li>
							<u:select id="group" value="${param.group}" placeholder="分组" sqlId="task_group" />
						  </li>
						  <li>
							<u:select id="status" value="${param.status}" placeholder="状态" dictionaryType="task_status" />
						  </li>
						   <li>
						  		<input type="submit" value="搜索" />
						   </li>
						   </ul>
						  </form>
						</div>
					</div>
					<div class="widget-content nopadding">
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
							    	<th>序号</th>
							    	<th>任务id</th>
							    	<th>任务名称</th>
							    	<th>存储过程名称</th>
							    	<th>数据库</th>
							    	<th>分组</th>
							    	<th>组内排序</th>
							    	<th>下次执行时间</th>
							    	<th>下次扫描时间</th>
							    	<th>状态</th>
							    	<th>操作</th>
							   </tr>
							</thead>
							<tbody>
								<s:iterator value="page.list">
								<tr>
									<td>${rownum}</td>
									<td>${task_id}</td>
									<td><u:truncate value="${task_name}" length="15" /></td>
									<td><u:truncate value="${procedure_name}" length="20" /></td>
									<td><u:ucparams key="${db_type}" type="db_type" /></td>
									<td>${group}</td>
									<td>${order}</td>
									<td>${execute_next}</td>
									<td>${scan_next}</td>
									<td name="status_name"><u:ucparams key="${status}" type="task_status" /></td>
									<td>
										<a href="javascript:;" onclick="view('${task_id}')">查看</a>
										| <a href="javascript:;" onclick="taskLog('${task_id}')">日志</a>
								   		<%--0关闭 --%>
								   		<span name="operate_0" ${status==0 ? "" : "style='display:none;'"}>
											| <a href="javascript:;" onclick="updateStatus(this, '${task_id}', 1)">启用</a>
											| <a href="javascript:;" onclick="edit('${task_id}')">编辑</a>
											| <a href="javascript:;" onclick="updateStatus(this, '${task_id}', 3)">删除</a>
								   		</span>
								   		
								   		<%--1启用 --%>
								   		<span name="operate_1" ${status==1 ? "" : "style='display:none;'"}>
											| <a href="javascript:;" onclick="updateStatus(this, '${task_id}', 0)">关闭</a>
								   		</span>
								   		
								   		<%--2正在执行 --%>
								   		<span name="operate_2" ${status==2 ? "" : "style='display:none;'"}>
											| <a href="javascript:;" onclick="updateStatus(this, '${task_id}', 1)">重新执行</a>
								   		</span>
								   		
								   		<%--3已删除 --%>
								   		<span name="operate_3" ${status==3 ? "" : "style='display:none;'"}>
											| <a href="javascript:;" onclick="updateStatus(this, '${task_id}', 0)">恢复</a>
								   		</span>
									</td>
							     </tr>
							    </s:iterator>
							</tbody>
						</table>
					</div>
						<u:page page="${page}" formId="mainForm" />
				</div>
			</div>
		</div>
	</div>

      
<script type="text/javascript">
//查看
function view(task_id){
	location.href="${ctx}/task/view?task_id=" + task_id;
}

//日志
function taskLog(task_id){
	location.href="${ctx}/taskLog/query?task_id=" + task_id;
}

//添加
function add(){
	location.href="${ctx}/task/add";
}

//编辑
function edit(task_id){
	location.href="${ctx}/task/edit?task_id=" + task_id;
}

//修改状态：关闭、启用、删除
function updateStatus(a, task_id, status){
	var status_name="";
	switch(status){
	case 0:	status_name = "关闭";
			break;
	case 1:	status_name = "启用";
			break;
	case 3:	status_name = "已删除";
			break;
	}
	
	if(confirm("确定要"+ $(a).text() +"吗？")){
		$.ajax({
			type: "post",
			url: "${ctx}/task/updateStatus",
			data:{
				task_id : task_id,
				status : status
			},
			success: function(data){
				if(data.result==null){
					alert("服务器错误，请联系管理员");
					return;
				}
				
				if(data.result=="success"){
					$(a).parent().hide();
					$(a).parents("tr").find("[name='operate_"+status+"']").show();
					$(a).parents("tr").find("[name='status_name']").text(status_name);
					alert($(a).text() + "成功");
				}else{
					alert(data.msg);
				}
			}
		});
	}
}
</script>
</body>
</html>