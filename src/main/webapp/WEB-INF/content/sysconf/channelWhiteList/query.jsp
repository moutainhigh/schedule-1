<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<title>通道白名单配置</title>
<style type="text/css">
.ctltable{
	border-collapse: collapse;
	table-layout:fixed}
.ctltable td {
	text-overflow:ellipsis;
	overflow:hidden;
	white-space: nowrap;
	padding:10px
}
</style>
</head>
<body menuId="65">
	<!--Action boxes-->
	<div class="container-fluid">
		<hr>
		<div class="row-fluid">
			<div class="span12">
				<div class="widget-box">
				
					<!-- 批量导入通道白名单弹出框 -->
					<div class="modal hide fade" id="importExcelBox" tabindex="-1" role="dialog" data-backdrop="static" data-keyboard="keyboard">
						<div class="modal-header"><!-- <button class="close" type="button" data-dismiss="modal">X</button> -->
							<h3 id="myModalLabel">批量导入通道白名单 &nbsp;&nbsp;&nbsp;<font size="1">360等浏览器请点击网址栏右侧浏览器图标取消兼容模式</font></h3>
							<font color="red">*批量导入耗费系统资源较多，请避免在系统高峰期使用</font>
						</div>
						<div class="modal-body text-center">
							<form class="form-horizontal" method="post" id="mainForm">
								<input type="file" id="importInput" name="upload" accept=".xls"/>
							</form>
							<div class="controls">
								<span id="msg" style="color:red;" style="display:none;"></span><br/>
								<span id="tips" style="display:none;">点击<a href='${ctx}/channelWhiteList/exportError' target='_blank'><font color="green">下载</font></a>未导入的列表</span>
							</div>
						</div>
						<div class="modal-footer">
						<a href="${ctx}/channelWhiteList/exportError" target="_blank" style="margin-left: 10px;">下载上次导入失败的信息(如果存在)</a>&nbsp;&nbsp;&nbsp;
						<a href="#" class="btn" data-dismiss="modal" onclick="closeImport()">关闭</a>
						<a href="#" class="btn btn-primary" onclick="importExcel(this)">导入</a>
						</div>
					</div>
					<div class="widget-title">
						<span class="icon"> <i class="fa fa-th"></i>
						</span>
						<h5></h5>
 						<u:authority menuId="102"> 
 							<span class="label label-info" data-toggle="modal" data-target="#importExcelBox" > 
 									<a href="javascript:;" onclick="">批量导入通道白名单</a> 
 							</span> 
 						</u:authority> 
						<u:authority menuId="102">
						<span class="label label-info">
								<a href="javascript:;" onclick="add()">添加通道白名单</a>
						</span>
						</u:authority>
						<div class="search">
							<form method="post" id="mainForm" action="${ctx}/channelWhiteList/query">
								<ul>
									<li><input type="text" name="text" value="<s:property value="#parameters.text"/>" maxlength="40" placeholder="手机号" class="txt_250" /></li>
									<li>
										<u:select id="channel_id" value="${param.channel_id}" placeholder="通道号" sqlId="channel" />
									</li>
									<li><input type="submit" value="搜索" /></li>
								</ul>
							</form>
						</div>
					</div>
					<div class="widget-content nopadding">
						<table class="table table-bordered table-striped ctltable">
							<thead>
								<tr>
									 <th style='width:5%'>序号</th>
					                 <th style='width:10%'>通道号</th>
					                 <th style='width:40%'>手机号码</th>
					                 <th style='width:20%'>备注</th>
					                 <th style='width:15%'>更新时间</th>
					                 <th style='width:10%'>操作</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="page.list">
								<tr>
							      <td style='width:10%'>${rownum}</td>
							      <td>${cid}</td>
							      <td>${phone}</td>
							      <td>${remarks}</td>
							      <td>${createtime}</td>
							      <td>
							     	 <u:authority menuId="103"><a href="javascript:;" onclick="edit('${id}')">编辑</a></u:authority> 
							     	 <u:authority menuId="104">| <a href="javascript:;" onclick="delchannelWhiteList(this, '${id}')">删除</a> </u:authority>
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
	<script type="text/javascript" src="${ctx}/js/layer/layer.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#importExcelBox').on('hide.bs.modal', function () {
				  closeImport();
			})
		});
	
		//添加
		function add() {
			location.href = "${ctx}/channelWhiteList/add";
		}
		
		//编辑
		function edit(id) {
			location.href = "${ctx}/channelWhiteList/edit?id=" + id;
		}

		//修改状态：删除
		function delchannelWhiteList(a, id) {
			if (confirm("确定要" + $(a).text() + "吗？")) {
// 				location.href = "${ctx}/channelWhiteList/delete?id=" + id;
				$.ajax({
					type : "post",
					url : "${ctx}/channelWhiteList/delete?id=" + id,
					success : function(data) {
						if (data.result == null) {
							alert("服务器错误，请联系管理员");
							return;
						}
						alert(data.msg);
						if (data.result == "success") {
							window.location.reload();
						}
					}
				});
			}
		}
		
		//Excel批量导入关键字
		function importExcel(btn) {
			/* if($.browser.msie&&($.browser.version == "8.0")){ 
				layer.msg("批量导入不支持ie8或关闭浏览器的兼容模式");
				return;
			} */
			var confirmIndex = layer.confirm('确定要导入这些数据吗', {
				  btn: ['确认','取消'] //按钮
				}, function(){
			$("#msg").hide();
			var indexs = "" ;
			var options = {
					beforeSubmit : function() {
						$(btn).attr("disabled", true);
						index = layer.load(1, {
						    shade: [0.5,'#fff'] //0.1透明度的白色背景
						});
					},
					success : function(data) {
						layer.close(index);
						$(btn).attr("disabled", false);
						
						if(data==null){
							$("#msg").text("服务器错误，请联系管理员").show();
							return;
						}
						if($.browser.msie&&($.browser.version == "8.0")){ 
							data = data.replace('<PRE>','');
							data = data.replace('</PRE>','');
						}
						$("#msg").text(data).show();
						if(data.lastIndexOf("!")!= -1){
							$("#tips").show();
						}
					},
					url : "${ctx}/channelWhiteList/import",
					type : "post",
					timeout:30000000
				};
			$("#mainForm").ajaxSubmit(options);
			layer.close(confirmIndex);
		}, function(){
			layer.close(confirmIndex);
		  return;
		});
}
		
		function closeImport(){
			$("#msg").hide();
			window.location.reload();
		}
	</script>
</body>
</html>