<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<script src="<%=path%>/js/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${role}
</body>
<script type="text/javascript">
$(function() {
$.ajax({
	type: "get",
	url: "<%=path%>/test/test5.action",
	dataType: 'json',
	success: function(data) {
		console.log(data);
	},
	error: function() {
		return false;
	}
});
});
</script>
</html>