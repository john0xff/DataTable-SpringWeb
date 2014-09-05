<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/res/container/css/dashboard.css" />

<jsp:include page="logout.jsp" />
<div id="line"></div>
<div id="body">
	
	<!-- expander -->
	<%-- <jsp:include page="${ leftColumn }.jsp" /> --%>
	<%-- <jsp:include page="../widgets/expander.jsp" /> --%>
	

	<!-- --------------------------------------------------- -->
	<!-- main table to display data from db or files 		 -->
	<!-- --------------------------------------------------- -->
	<div id="mainColumn">
		<jsp:include page="${ mainColumn }.jsp" />
	</div>
</div>