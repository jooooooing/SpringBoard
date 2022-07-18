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

		<table>

		<tr>
			<td>
				<b>번호</b>
			</td>
			<td>
				<input type='hidden' name="id" value=글번호>${allView.id}</td>
		</tr>

		<tr>
			<td>
				<b>제목</b>
			</td>
			<td>
				<input type='hidden' name="title" value=제목>${allViewList.title}</td>
		</tr>

		<tr>
			<td>
				<b>일자</b>
			</td>
			<td>
				<input type='hidden' name="today" value=날짜><fmt:formatDate pattern="yyyy-MM-dd" value = "${allViewList.created}"/></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td>${allViewList.view}</td>
		</tr>

		<td>내용</td>
		<td>
			<textarea>${allViewList.text}
		</textarea>
		</td>
		</tr>
	</table> 


<table>
<tr>
		<td></td>
		<td><input type=button value="목록" OnClick="location.href='allView.jsp'"></td>
		<td><input type=button value="수정" OnClick="location.href='updateView.jsp'"></td>
		<td><input type=button value="삭제" OnClick="location.href='delete.jsp'"></td>
</tr>
</table>

</body>
</html>