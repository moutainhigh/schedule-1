<div class="pagenum">
		
	<span>
		共<i>${page.totalCount ?c}</i>条记录
		每页显示
		<select onChange="${formId}_changeRowCount(this)" >
			<#list page.pageRowArray as item>
				<#if item==page.pageRowCount>
					<option value="${item ?c}" selected="selected">${item ?c}</option>
				<#else>
					<option value="${item ?c}">${item ?c}</option>
				</#if>
			</#list>
		</select>条
		当前${page.currentPage ?c}/${page.totalPage ?c}页
	</span>
	<#if (page.totalPage>1)>
		<#if (page.currentPage>1)>
			<a href="javascript:;" class="first" title="第一页" onclick="${formId}_getPage(1)">第一页</a>
			<a href="javascript:;" class="prev" title="上一页" onclick="${formId}_getPage(${(page.currentPage-1) ?c})">上一页</a>
		</#if>
		<#if (page.currentPage<page.totalPage)>
			<a href="javascript:;" class="next" title="下一页" onclick="${formId}_getPage(${(page.currentPage+1) ?c})">下一页</a>
			<a href="javascript:;" class="last" title="最后一页" onclick="${formId}_getPage(${page.totalPage ?c})">最后一页</a>
		</#if>
		<span>
			<input type="text" id="${formId}_inputPage" onfocus="inputControl.setNumber(this, 10, 0, false)"/>
			<input type="button" value="GO" class="go" onclick="${formId}_inputPage()"/>
		</span>
	</#if>
</div>

<script type="text/javascript">
	$(function(){
		${formId}_searchForm = $("#${formId}"); //查询的表单
		if($("#${formId}_pageRowCount").length == 0){
			${formId}_searchForm.append("<input type='hidden' id='${formId}_pageRowCount' name='pageRowCount' value='${page.pageRowCount ?c}'/>");
		}
		if($("#${formId}_currentPage").length == 0){
			${formId}_searchForm.append("<input type='hidden' id='${formId}_currentPage' name='currentPage' value='${page.currentPage ?c}'/>");
		}
        if($("#totalCount").length == 0){
			${formId}_searchForm.append("<input type='hidden' id='totalCount' name='totalCount' value='${page.totalCount ?c}'/>");
        }
	});
	
	//选择每页显示行数
	function ${formId}_changeRowCount(select){
		$("#${formId}_pageRowCount").val($(select).val());
		${formId}_getPage(1);
	}
	
	//查询某一页
	function ${formId}_getPage(currentPage){
		if(/^[1-9]\d*$/.test(currentPage)){
			${formId}_searchForm.find("#${formId}_currentPage").val(currentPage);
		}
		${formId}_searchForm.submit();
	}
	
	//输入页号查询
	function ${formId}_inputPage(){
		var currentPage = $("#${formId}_inputPage").val();
		${formId}_getPage(currentPage);
	}
</script>