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
    <script type="text/javascript" src="/house/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="/house/js/jquery-ui-datepicker.js"></script>
    <script type="text/javascript" src="/house/js/jquery.validate.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/house/css/jquery-ui.css"/>
   <style>
   

.error {
  
  font-size:13px;
  color: red;
  
}

   </style>
    <script type="text/javascript">
    $().ready(function() {
        // 在键盘按下并释放及提交后验证提交表单
        $("#date").datepicker();
        
        $("#myform").validate({
        	
            rules : {
            	date : {
                    required : true,
                },
               
                content : {
                    required : true,
                  
                }
            },
            messages : {
            	date : {
                    required : "日期不能为空",
                },
               
                content : {
                    required : "日程不能为空",
                  
                }
            }
        });
    })
    
    
	</script>
	
</head>
<body>

<div class="result-title">
<h1>添加日程</h1>
</div>
<div class="result-content">
<div class="sidebar-title">
        <form action="/house/schedule/insertschedule.action" method="post" id="myform" name="myform" enctype="multipart/form-data" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                                <th><i class="require-red">*</i>日期：</th>
                                <td>
                                    <input class="common-text required" value="${schedule.date}" id="date" name="date" size="50" type="text" readonly>
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>日程：</th>
                                 <td><textarea class="common-text" name="content"  id="content" style="width:430px;height:80px;">${schedule.content}</textarea></td>
                                 
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