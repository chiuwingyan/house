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
	if(error=="applycheck"){

	alert("你还没完善个人信息，请完善个人信息后再进行申请操作");
	}else if(error=="applysuccess"){
		alert("申请成功，请耐心等待房东联系您！");	
	}
		
	</script>
</head>
<body>
<div>
<div class="result-title">
<h1>房源列表</h1>
</div>
	<form id="houseForm" name="houseForm"
		action="houselist.action"
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
									<td>面积</td>
									<td>价格</td>
									<td>状态</td>
									
									<td>操作</td>
								
									
								</tr>
								<c:forEach items="${houselist}" var="houselist">
									<tr
										style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
										<td>${houselist.houseid }</td>

										<td>${houselist.address}</td>
										<td>${houselist.area}</td>
										<td>${houselist.price}</td>
										<td>${houselist.status}</td>
										<td>
										<c:choose>
										<c:when test="${ houselist.status=='未租赁'}">
													<a class="link-update"
											href="applycheckuserlist.action?id=${houselist.id}">申请看房</a>
											&nbsp;&nbsp; 
												</c:when >
												<c:when test="${ houselist.status=='已租赁'}">
													该房已被租赁
											&nbsp;&nbsp; 
												</c:when >
												<c:otherwise>
												    该房已被申请
												</c:otherwise>
										 </c:choose>
										
											
									</td>		
										
										
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