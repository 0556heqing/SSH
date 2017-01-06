<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
		<%@ include file="/WEB-INF/jsp/public/common.jspf" %>
	</head>

	<body>

 	<table cellspacing="0" cellpadding="0" class="TableStyle">
       
        <!-- 表头-->
        <thead>
            <tr align=center  valign=middle  id=TableTitle>
                <td width="100">id</td>
                <td width="100">姓名</td>
            </tr>
        </thead>
        
        <!--显示数据列表-->
        <tbody id="TableData" class="dataContainer"  datakey="testList">
        <s:iterator value="recordList"> 
            <tr class="TableDetail1 template">
                <td>${id}&nbsp;</td>
                <td>${name}&nbsp;</td>
            </tr>
        </s:iterator> 
            
        </tbody>
    </table>

		<!-- 分页信息 -->
		<s:form action="classes_page"></s:form>
		<%@ include file="/WEB-INF/jsp/public/pageView.jspf" %>
	</body>
</html>
