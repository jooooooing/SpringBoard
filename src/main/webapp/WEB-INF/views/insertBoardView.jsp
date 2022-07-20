<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<style>
table {
	width: 100%;
	border: 1px solid #444444;
	border-collapse: collapse;
}

table th {
	border: 1px solid #444444;
	text-align: center;
	height: 40px;
	background-color: dodgerblue;
	color: cornsilk;
}

table td {
	border: 1px solid #444444;
	text-align: left;
}
</style>

<!-- 현재날짜 구하기 위한 선언 및 형식 지정 -->
<c:set var="date" value="<%=new java.util.Date()%>" />
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd" var="today"/>
</head>
<body>
	<div style="text-align: center;">
		<h3>글쓰기</h3>
		<hr>
		<form action="insertBoard" method="post">
			<table style="width: 700px; margin: auto">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" cols="40" rows="10"></textarea></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><input type="text" name="today" value = "${today}"></td>
				</tr>
			</table>
			<div>
				<input type=button value="목록" OnClick="location.href='getBoardList'">
				<input type="submit" value="등록" />
			</div>
		</form>
	</div>
</body>
</html>