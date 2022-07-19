<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./style.css"/>
<meta charset="UTF-8">
<title>BoardItem List</title>
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

			<c:forEach var="allView" items="${boardItems}">
				<tr>
					<td>${allView.id}</td>
					<td><a href="/board/oneView?id=${allView.id}"> ${allView.title}</a></td>
					<td>${allView.author}</td>
					<td>${allView.view}</td>
					<td><fmt:formatDate pattern="yyyy-MM-dd" value = "${allView.created}"/></td>
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