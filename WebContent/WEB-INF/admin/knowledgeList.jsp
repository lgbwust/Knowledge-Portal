<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>用户信息列表</title>  
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/default/easyui.css">  
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/icon.css">  
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/themes/color.css">  
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/easyui/demo/demo.css">  
<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.min.js"></script>  
<script type="text/javascript" src="<%=request.getContextPath() %>/easyui/jquery.easyui.min.js"></script>  
<style type="text/css">  
        #fm{  
            margin:0;  
            padding:10px 30px;  
        }  
        .ftitle{  
            font-size:14px;  
            font-weight:bold;  
            padding:5px 0;  
            margin-bottom:10px;  
            border-bottom:1px solid #ccc;  
        }  
        .fitem{  
            margin-bottom:5px;  
        }  
        .fitem label{  
            display:inline-block;  
            width:80px;  
        }  
        .fitem input{  
            width:160px;  
        }  
    </style>  
</head>  
<body>  
    <h2>知识信息列表</h2>  
    <p>You can add User,or Edit_User、Delete_User if you selected an user</p>  
    <table id="dg" title="知识操操作" class="easyui-datagrid" style="width:700px;height:250px"  
            url="<%=request.getContextPath()%>/admin/knowledgeList.html"  
            toolbar="#toolbar" pagination="true"  
            rownumbers="true" fitColumns="true" singleSelect="true">  
        <thead>  
            <tr >  
                <th field="kid" width="30" >知识ID</th>  
                <th field="user"  data-options="formatter:function(value,row,index){
                                    if(value.userName){
                                        return value.userName;
                                    }
                                }" width="50">上传者</th>  
                <th field="title" width="30">标题</th>  
                <th field="content" width="50">内容</th>
                <th field="extra" width="30" >说明</th>  
                <th field="category" data-options="formatter:function(value,row,index){
                                    if(value.cname){
                                        return value.cname;
                                    }
                                } width="50">类别</th>  
                <th field="status" width="30">审核状态</th>     
            </tr>  
        </thead>  
    </table>  
    <div id="toolbar">  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新建用户</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="checkUser()">审核</a>  
    </div>  
      
    <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"  
            closed="true" buttons="#dlg-buttons">  
        <div class="ftitle">用户信息</div>  
        <form id="fm" method="post" novalidate>  
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
    </div>  
    <div id="dlg-buttons">  
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">保存</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>  
    </div>  
    <script type="text/javascript">  
        var url_pattern;  
        function editUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $('#dlg').dialog('open').dialog('setTitle','Edit User');  
                $('#fm').form('load',row);  
                url_pattern = '<%=request.getContextPath()%>/updateUser.html';  
            }  
        }  
        function newUser(){  
            $('#dlg').dialog('open').dialog('setTitle','New User');  
          //  $('#fm').form('clear');  
            url_pattern = '<%=request.getContextPath()%>/addUser.html';  
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
        function destroyUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('Confirm','确定要删除这个用户么？',function(r){  
                    if (r){  
                        $.post('<%=request.getContextPath()%>/deleteUser.html',{id:row.id},function(result){  
                             $('#dg').datagrid('reload');  
                        },'json');  
                    }  
                    $('#dg').datagrid('reload');  
                });  
            }  
        }  
        function checkUser(){  
            var row = $('#dg').datagrid('getSelected');  
            if (row){  
                $.messager.confirm('Confirm','确定要删除这个用户么？',function(r){  
                    if (r){  
                        $.post('<%=request.getContextPath()%>/checkUser.html',{id:row.id},function(result){  
                             $('#dg').datagrid('reload');  
                        },'json');  
                    }  
                    $('#dg').datagrid('reload');  
                });  
            }  
        } 
    </script>  
</body>  
</html>