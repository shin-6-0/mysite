<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Yukyung's Mysite02</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath() %>/assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp"/>
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" src="${pageContext.request.contextPath}/assets/images/goodchun.png" style="width: 120px">
					<h2>Yukyung의 MySite</h2>
					<p>
						▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀<br>
						<br><b>신유경</b><br>
						1996.03.13 / ENTP<br>
						숭의여자고등학교 졸업 (2012.03 - 2015.02)<br>
						경희대학교 전자공학과 졸업 (2016.03 - 2021.02)<br>
						Favorite : <b>춘식이, 아샷추</b><br>
						<br>
						Servlet, JSP, JAVA를 이용해서 만든 사이트 입니다 :)<br><br>
						▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀
						<br><br>
						<b><font size=""><a href="<%=request.getContextPath() %>/guestbook">💛방명록💛</a></font>에 글 남기기</b><br>
					</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>

	</div>
</body>
</html>