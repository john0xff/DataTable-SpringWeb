<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JvCRM</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/res/container/css/core.css" />
</head>
<body>
	<div id="main">
		<!-- --------------------------------------------------- -->
		<!-- workspace = login\register\dashboard		 		 -->
		<!-- each workspace has header and main area 			 -->
		<!-- to display content									 -->
		<!-- controllers're deciding which workspace to display	 -->
		<!-- --------------------------------------------------- -->
		<div id="workspace">
			<jsp:include page="${workspace}.jsp" />
		</div>
		
		<!-- footer	-->
		<div id="footer">
			<div id="footer-inline-list">
				<ul>
					<li>© 2014 Bart Bien</li>
					<li><a href="http://www.phoenixjcam.com" target="_blank">phoenixjcam.com</a></li>
					<li><a href="https://github.com/bartbien" target="_blank">github.com/bartbien</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>