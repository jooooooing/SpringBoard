<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./style.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<table>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>등록일</td>
			</tr>
			</div>

			<c:forEach var="allViewList" items="${allView}">
				<tr>
					<td>${allViewList.id}</td>
					<td><a href="/${allViewList.id}"> ${allViewList.title}</a></td>
					<td>${allViewList.author}</td>
					<td>${allViewList.view}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value = "${allViewList.created}"/></td>
					<!--날짜형식 지정  -->
				</tr>
			</c:forEach>
		</table>
		<div id = "btn">
		<button onclick="locaction.href='/write'">글쓰기</button>
		</div>
	</div>
</body>
</html>