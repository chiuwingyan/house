<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/house/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/house/css/main.css"/>
    <script type="text/javascript" src="/house/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/house/js/libs/modernizr.min.js"></script>
    <style>
   
    a:hover{
    cursor:pointer;
    }
    </style>
    <script language=javascript>
	// 提交分页的查询的表单
	function to_page(url1){

                
                 $.ajax({ url:url1,
                         type:"post",
                         async : false, 
                        
                        success:function(data){
                                // 你的具体操作
                                // alert(data);
                                $("#inside").html(data);
                                alert("成功");
                                
                        },
                        error: function() {  
                            alert("失败，请稍后再试！");  
                        }  
                });
        }
	
</script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on sendRequest" href="javascript::void(0)" onclick="to_page('toindex.action')">首页</a></li>
               
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>欢迎您，${sessionScope.user.username}！</li>
               
                <li><a href="javascript:if(confirm('确实要退出登录吗?'))location='/house/login.action'">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
     <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a class="a"><i class="icon-font">&#xe003;</i>房源信息</a>
                    <div class="p"><ul class="sub-menu">
                        <li><a href="/house/houselist.action"><i class="icon-font">&#xe008;</i>房源列表</a></li>
                        
       
                    </ul>
                    </div>
                </li>
                <li>
                    <a class="a"><i class="icon-font">&#xe018;</i>租赁信息</a>
                 <div class="p"><ul class="sub-menu">
                        <li><a href="/house/zulist/myzulist.action"><i class="icon-font">&#xe017;</i>我的租赁</a></li>
                        <li><a href="/house/checkout/getmycheckout.action"><i class="icon-font">&#xe037;</i>已退租列表</a></li>
                        
                    </ul>
                    </div>
                </li>
                <li>
                    <a class="a"><i class="icon-font">&#xe018;</i>我的申请</a>
                <div class="p"><ul class="sub-menu">
                        <li><a href="/house/getmyapply.action"><i class="icon-font">&#xe017;</i>看房申请列表</a></li>
                        <li><a href="/house/applyout/getmyapplyout.action"><i class="icon-font">&#xe037;</i>退租申请列表</a></li>
                        
                    </ul>
                    </div>
                </li>
                <li>
                    <a class="a"><i class="icon-font">&#xe018;</i>租金信息</a>
               <div class="p">     <ul class="sub-menu">
                        <li><a href="/house/paid/mytopaidlist.action"><i class="icon-font">&#xe017;</i>待缴租金</a></li>
                       	<li><a href="/house/paid/findmypaid.action"><i class="icon-font">&#xe017;</i>已缴租金</a></li>
                        
                    </ul></div>
                </li>
                <li>
                    <a class="a"><i class="icon-font">&#xe018;</i>报障模块</a>
                   <div class="p">    <ul class="sub-menu">
                        <li><a href="/house/wrong/showaddwrong.action"><i class="icon-font">&#xe017;</i>我要报障</a></li>
                       	<li><a href="/house/wrong/mywronglist.action"><i class="icon-font">&#xe017;</i>未处理报障</a></li>
                        <li><a href="/house/wrong/findmysolve.action"><i class="icon-font">&#xe017;</i>已处理报障</a></li>
                    </ul></div>
                </li>
                <li>
                    <a class="a"><i class="icon-font">&#xe018;</i>其他操作</a>
                  <div class="p">   <ul class="sub-menu">
                        <li><a href="/house/findhasuserlist.action"><i class="icon-font">&#xe017;</i>账户绑定</a></li>
                       	
                        
                    </ul></div>
                </li>
            </ul>
        </div>
     </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用本系统！</span></div>
        </div>
        
        <div class="result-wrap" id="inside">
       <jsp:include page="${mainPage==null?'../admin/index.jsp':mainPage}"></jsp:include>
            </div>
        </div>
        
    </div>
    <!--/main-->
</div>
</body>
</html>