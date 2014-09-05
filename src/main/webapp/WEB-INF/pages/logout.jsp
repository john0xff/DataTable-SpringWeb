<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>

<div id="header">
	<div id="header-user-panel">
		<c:url value="/logout" var="logoutUrl" />
		<form action="${ logoutUrl }" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
		
		<a href="<%=request.getContextPath()%>/dashboard">
			<img id="header-pic" src="<%=request.getContextPath()%>/res/container/images/clients.png" alt="dashboard" width="42" height="42">
		</a>
		
		<a href="<%=request.getContextPath()%>/dashboard">
			<img id="header-pic" src="<%=request.getContextPath()%>/res/container/images/callcenter.png" alt="dashboard" width="42" height="42">
		</a>
	
	<%-- 	<ul id="header-right-list">
			<li>
			 	<c:if test="${pageContext.request.userPrincipal.name != null}">
			 		User: ${pageContext.request.userPrincipal.name}
			 	</c:if>
			</li>
			<li>
				<a href="javascript:formSubmit()" id="header-link">
					<img src="<%=request.getContextPath()%>/res/container/images/logout.png" alt="Logout" width="42" height="42"> 
					Logout
				</a>
			</li>
		</ul> --%>
		
	</div>
</div>