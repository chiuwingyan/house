<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>房屋租赁系统</title>
    <link rel="stylesheet" type="text/css" href="/house/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="/house/css/main.css"/>
    <script type="text/javascript" src="/house/js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="/house/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="/house/js/jquery.validate.min.js"></script>
   <style>
   

.error {
  
  font-size:13px;
  color: red;
  
}

   </style>
    <script type="text/javascript">
    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#myform").validate({
        	
            rules : {
            	houseid : {
                    required : true,
                },
               
                address : {
                    required : true,
                  
                },
                area : {
                    required : true,
                    min: 0
                  
                },
                price: {
                    required : true,
                    min: 0
                  
                }
                
            },
            messages : {
            	houseid : {
                    required : "房屋id不能为空！",
                },
               
                address : {
                    required : "地址不能为空！",
                  
                },
                area : {
                    required : "面积不能为空！",
                    min:"请输入正确的面积"
                  
                },
                price: {
                    required :  "价格不能为空！",
                    min:"请输入正确的租金"
                  
                }
                
            }
        });
    })
	</script>
	
</head>
<body>

<div class="result-title">
<h1>更新房源</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form action="findhouseidupdate.action" method="post" id="myform" name="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                    <input type="hidden" name="id" value="${houselist.id}"/>
                        <tbody>
                                <th><i class="require-red">*</i>房屋id：</th>
                                <td>
                                    <input class="common-text required" value="${houselist.houseid}" id="houseid" name="houseid" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>地址：</th>
                                <td><input class="common-text" name="address" value="${houselist.address }" id="address" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>面积：</th>
                                <td><input class="common-text" name="area" value="${houselist.area }" id="area" size="50" type="text" ></td>
                            </tr>
                           <tr>
                                <th><i class="require-red">*</i>租金：</th>
                                <td><input class="common-text" name="price" value="${houselist.price }" id="price" size="50" type="text"></td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>状态：</th>
                              <td>
                                <select name="status" id="status" class="required">
                                
                                <option value="已租赁" <c:if test="${houselist.status == '已租赁'}">selected</c:if>>已租赁</option>  
                            <option value="未租赁" <c:if test="${houselist.status == '未租赁'}">selected</c:if>>未租赁</option> 
                                </select>
                            </td>
                            </tr>
								<tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
							<tr>
                                <font id="error" color="red">${error }</font>
                            </tr>	
                        </tbody></table>
                </form>
          </div>
          </div>
    
</body>
</html>