<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>知识门户后台管理系统</title>
<%@include file="/WEB-INF/include/easyui.jsp"%>
<script type="text/javascript">
	$(function() {
		$('#mainMenu').tree({
			url : path+'/getMenu.html',
			parentField : 'pid',
			onClick : function(node) {
				if (node.attributes.url) {
					var src = path + node.attributes.url;
					if (!$.startWith(node.attributes.url, '/')) {	//不是本项目的url，例如www.baidu.com
						src = node.attributes.url;
					}
					var tabs = $('#mainTabs');
					var opts = {
						title : node.text,
						closable : true,
						iconCls : node.iconCls,
						content : $.formatString('<iframe src="{0}" allowTransparency="true" style="border:0;width:100%;height:99%;" frameBorder="0"></iframe>', src),
						border : false,
						fit : true
					};
					if (tabs.tabs('exists', opts.title)) {
						tabs.tabs('select', opts.title);
					} else {
						tabs.tabs('add', opts);
					}
				}
			}
		});
	})
	$(function() {
        initPage();
    });
	function initPage() {
        //读取动态变化的时间
        ReadDateTimeShow();

        //绑定菜单按钮的点击事件
        BindMenuClickEvent();

        //这里实现对时间动态的变化
        var setTimeInterval = setInterval(ReadDateTimeShow, 1000);


    }
	   //读取动态变化的时间
    function ReadDateTimeShow() {
        var year = new Date().getFullYear();
        var month = new Date().getMonth() + 1;
        var day = new Date().getDate();
        var time = new Date().toLocaleTimeString();
        var addDate = year + "年" + month + "月" + day + "日," + time;
        $("#date").text(addDate);
    }
</script>

</head>
    <body class="easyui-layout">  
        <!-- 正上方panel -->  
        <div region="north" style="height:100px;padding:10px;" >
        	<center><h2>欢迎<%=request.getSession().getAttribute("adname") %>登录系统</h2></center>
         
        <div style="text-align: right;">
                当前时间：<b id="date"></b> &nbsp;&nbsp; <a href="./adminloginout.html"><b>注销</b></a>
            </div>
            </div> 
		<!-- 左侧菜单 -->
        <div data-options="region:'west',href:''" title="导航" style="width: 200px; padding: 10px;">
			<ul id="mainMenu"></ul>
		</div>
		
        <!-- 正中间panel -->  
        <div region="center" title="功能区" >  
            <div class="easyui-tabs" id="mainTabs" fit="true" border="false">  
                <div title="欢迎页" style="padding:20px;overflow:hidden;">   
                    <div style="margin-top:20px;">  
                        <h3>你好，欢迎来到后台管理系统</h3>  
                    </div>  
                </div>  
            </div>  
        </div>  
        
        <!-- 右边panel --> 
        <div data-options="region:'east',iconCls:'icon-reload',split:false"
        title="日历信息" style="width: 240px;">
        <div class="easyui-calendar" style="width: 230px; height: 230px;"></div>
        <br>
        <center><div style="width: 230px">努力Coding中</div></center>
    </div>
        
        <!-- 正下方panel -->  
        <div region="south" style="height:50px;" align="center">  
            <label>Author: NO.2  
                	<br/>  
            </label>  
        </div>  
    </body>
</html>
