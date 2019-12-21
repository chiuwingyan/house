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
	</script>
	<style type="text/css">
	
	
	</style>
	<script type="text/javascript">
	var error="${param.error}";
	if(error=="applysuccess"){

	alert("申请已提交，请耐心等待管理员的处理。如需查看进度，可前往“我的退租申请”中查看");
	}else if(error=="deletesucess"){
		alert("删除成功");
	}
	</script>
</head>
<body>
<div>
<div class="result-title">
<h1>退租申请</h1>
</div>
	<form id="houseForm" name="houseForm"
		action="/house/applyout/findallapplyout.action"
		method=post >
						 <div class="result-title">
                    <div class="result-list">
                      
                        
                    </div>
                </div>

					<div class="result-content">
						<table id=grid
							class="result-tab" width="100%">
							<tbody>
								<tr
									style="FONT-WEIGHT: bold; FONT-STYLE: normal; BACKGROUND-COLOR: #eeeeee; TEXT-DECORATION: none">
									
									
									<td>房屋id</td>
									<td>地址</td>
									<td>状态</td>
									<td>申请人</td>
									<td>申请人身份证号</td>
									<td>申请人联系电话</td>
									<td>操作</td>
									
								</tr>
								<c:forEach items="${applyout}" var="applyout">
								
									<tr
										style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
										<td>${applyout.house_id}</td>

										<td>${applyout.address}</td>
										
										<td>${applyout.status}</td>
										<c:forEach items="${applyout.userlist}" var="userlist">
										<td>${userlist.name}</td>
										<td>${userlist.idcard}</td>
										<td>${userlist.phone}</td>
										
										<td>
										<c:choose>
										<c:when test="${applyout.status=='申请中'}">
										<a class="link-update"
											href="/house/applyout/agreeapplyout.action?id=${applyout.id }"
											onclick="return window.confirm('确定要同意退租吗？')">同意</a>
											&nbsp;&nbsp; 
											
											<a class="link-del"
											 href="/house/applyout/refuseapplyout.action?id=${applyout.id }"
											onclick="return window.confirm('确定要拒绝吗？')">拒绝</a>
											</c:when >
											<c:otherwise>
												 <a class="link-del"
											 href="/house/applyout/deleteapplyout.action?id=${applyout.id}"
											onclick="return window.confirm('确定要删除该记录吗？')">删除</a>
												</c:otherwise>
										 </c:choose>
										 </td>
										</c:forEach>
										
									</tr>

								</c:forEach>

							</tbody>
						</table>
						</div>
					

						<tr>
						<tr>
							<span id=pagelink>
								<div style="LINE-HEIGHT: 20px; HEIGHT: 20px; TEXT-ALIGN: right; margin-top:10px">
									共[<B>${p.total}</B>]条记录，共[<B>${p.pages}</B>]页
									,

									<c:if test="${ p.pageNum > 1 }">
													[<A href="javascript:to_page(${p.prePage})">前一页</A>]
												</c:if>
										<input type="hidden" name="page" id="page" value=""/>
									第<B>${p.pageNum}</B>页

									<c:if test="${ p.pageNum < p.pages }">
													[<A href="javascript:to_page(${p.nextPage})">后一页</A>] 
												</c:if>

									
								</div>
							</span>
						
						</tr>
						</tbody>
					
					

					
						</tbody>
				

					</form>
</div>
 <script language=javascript>
	// 提交分页的查询的表单
	function to_page(page) {
		if (page) {
			$("#page").val(page);
		}
		document.houseForm.submit();
	}
</script>
</body>
</html>