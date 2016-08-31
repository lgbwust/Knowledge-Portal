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
          
        function deleteFile(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('Confirm','确定要删除这个文件么？',function(r){  
                    if (r){  
                        $.post('<%=request.getContextPath()%>/admin/deleteFile.html',{fileId:row.fileId},function(result){  
                             $('#dg').datagrid('reload');  
                        },'json');  
                    }  
                    $('#dg').datagrid('reload');  
                });  
            }  
        }  
        function checkFile(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('Confirm','确定通过审核？',function(r){  
                    if (r){  
                        $.post('<%=request.getContextPath()%>/admin/checkFile.html',{fileId:row.fileId},function(result){  
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
			url="${path}/admin/fileList.html" 
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
                <th field="fileId" width="10" >文件ID</th>  
                <th field="user"  data-options="formatter:function(value,row,index){
                                    if(value.userName){
                                        return value.userName;
                                    }
                                }" width="10">上传者</th>  
                <th field="fileName" width="50">文件名</th>  
                <th field="fileDes" width="50">文件说明</th>  
                <th field="fileStatus" width="10">审核状态</th>     
            </tr> 
			</thead>
		</table>

		<!-- 按钮 -->
		 <div id="toolbar">    
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteFile()">删除文件</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="checkFile()">审核文件</a>  
    </div> 
</body>
</html>
