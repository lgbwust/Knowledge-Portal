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
        function editUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $('#dlg').dialog('open').dialog('setTitle','编辑知识');  
                $('#fm').form('load',row);  
                url_pattern = '<%=request.getContextPath()%>/admin/editUser.html';  
            }  
        }  
        function newUser(){  
            $('#dlg').dialog('open').dialog('setTitle','新建知识');  
          //  $('#fm').form('clear');  
            url_pattern = '<%=request.getContextPath()%>/admin/addUser.html';  
        }  
        function saveUser(){  
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
        function deleteUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('Confirm','确定要删除这个用户么？',function(r){  
                    if (r){  
                        $.post('<%=request.getContextPath()%>/admin/deleteUser.html',{userId:row.userId},function(result){  
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
			url="${path}/admin/userList.html" 
			toolbar="#toolbar" 
			pagination="true"
			fitColumns="true" 
			singleSelect="true" 
			rownumbers="true"
			striped="true"
			border="false" 
			nowrap="false">
			<thead>
			  <tr>  
                <th field="userId" width="10" >用户ID</th>  
                <th field="userName" width="10">姓名</th>  
                <th field="userPassword" width="10">密码</th>  
                <th field="userEmail" width="30">电子邮件</th>    
              </tr> 
			</thead>
		</table>

		<!-- 按钮 -->
		 <div id="toolbar">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="newUser()">新建用户</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="editUser()">编辑用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="deleteUser()">删除用户</a>  
    </div> 

		<!-- 添加/修改对话框 -->
		<div id="dlg" class="easyui-dialog"
			style="width:400px;height:280px;padding:10px 20px" closed="true"
			buttons="#dlg-buttons">
			<div class="ftitle">用户操作</div>
			<form id="fm" method="post" novalidate>
			    <div class="fitem">  
                <label>用户ID:</label>  
                <input name="userId" class="easyui-textbox" required="true">  
                </div>
				<div class="fitem">  
                <label>用户名:</label>  
                <input name="userName" class="easyui-textbox" required="true">  
                </div>  
                <div class="fitem">  
                <label>密码:</label>  
                <input name="userPassword" type="password" class="easyui-textbox" required="true">  
                </div>  
                <div class="fitem">  
                <label>电子邮件:</label>  
                <input name="userEmail" class="easyui-textbox" required="true">  
                </div> 
			</form>
		
		<div id="dlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>  
        </div>
		
	</div>
</body>
</html>
