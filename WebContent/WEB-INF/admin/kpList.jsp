<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>客户信息管理</title>
<%@include file="/WEB-INF/include/easyui.jsp"%>
<!-- 对话框的样式 -->
<link href="${path}/css/list.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">  
        var url_pattern;  
        function editKnowledge(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $('#dlg').dialog('open').dialog('setTitle','编辑知识');  
                $('#fm').form('load',row);  
                url_pattern = '<%=request.getContextPath()%>/admin/editKnowledge.html';  
            }  
        }  
        function newKnowledge(){  
            $('#dlg').dialog('open').dialog('setTitle','新建知识');  
          //  $('#fm').form('clear');  
            url_pattern = '<%=request.getContextPath()%>/addUser.html';  
        }  
        function saveKnowledge(){  
             $('#fm').form('submit',{  
                url: url_pattern,  
                onSubmit: function(){  
                    return $(this).form('validate');  
                },  
                success: function(result){  
                    $('#dlg').dialog('close');        // close the dialog  
                    $('#dg').datagrid('reload');    // reload the user data  
                }  
            });  
        }  
        function deleteKnowledge(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('Confirm','确定要删除这个知识点么？',function(r){  
                    if (r){  
                        $.post('<%=request.getContextPath()%>/admin/deleteKnowledge.html',{kid:row.kid},function(result){  
                             $('#dg').datagrid('reload');  
                        },'json');  
                    }  
                    $('#dg').datagrid('reload');  
                });  
            }  
        }  
        function checkKnowledge(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('Confirm','确定通过审核？',function(r){  
                    if (r){  
                        $.post('<%=request.getContextPath()%>/admin/checkKnowledge.html',{kid:row.kid},function(result){  
                        	$('#dg').datagrid('reload');  
                        },'json');  
                    }  
                    $('#dg').datagrid('reload');  
                });  
            }  
        } 
    </script>  

</head>
<body class="easyui-layout" fit="true">
	<div region="center" border="false" style="overflow: hidden;">
		<!-- 用户信息列表 title="用户管理" -->
		<table id="dg" class="easyui-datagrid" fit="true"
			url="${path}/admin/knowledgeList.html" 
			toolbar="#toolbar" 
			pagination="true"
			fitColumns="true" 
			singleSelect="true" 
			rownumbers="true"
			striped="true"
			border="false" 
			nowrap="false">
			<thead>
				 <tr >  
                <th field="kid" width="10" >知识ID</th>  
                <th field="user"  data-options="formatter:function(value,row,index){
                                    if(value.userName){
                                        return value.userName;
                                    }
                                }" width="20">上传者</th>  
                <th field="title" width="30">标题</th>  
                <th field="content" width="60">内容</th>
                <th field="extra" width="20" >说明</th>  
                <th field="category" data-options="formatter:function(value,row,index){
                                    if(value.cname){
                                        return value.cname;
                                    }
                                }" width="10">类别</th>  
                <th field="status" width="10">审核状态</th>     
            </tr>
			</thead>
		</table>

		<!-- 按钮 -->
		 <div id="toolbar">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editKnowledge()">编辑知识</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteKnowledge()">删除知识</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="checkKnowledge()">审核知识</a>  
    </div> 

		<!-- 添加/修改对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:280px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">编辑知识</div>
			<form id="fm" method="post" novalidate>
			<input name="kid" type="hidden">
				<div class="fitem">
					<label>知识标题:</label> <input name="title" class="easyui-textbox"
						required="true">
				</div>
				<div class="fitem">
					<label>知识内容:</label> <input name="content" class="easyui-textbox"
						required="true">
				</div>
				<div class="fitem">
					<label>知识说明:</label> <input name="extra" class="easyui-textbox"
						required="true">
				</div>
			</form>
		
		<div id="dlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveKnowledge()" style="width:90px">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>  
        </div>
		
	</div>
</body>
</html>
