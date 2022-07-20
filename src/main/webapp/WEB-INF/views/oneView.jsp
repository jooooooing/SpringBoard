<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./style.css" />
<meta charset="UTF-8">
<title>BoardItem oneView</title>
</head>
<body>
	<table>

		<tr>
			<td><b>번호</b></td>
			<td><input type='hidden' name="id" value=글번호>${boardItem.id}
			</td>
		</tr>

		<tr>
			<td><b>제목</b></td>
			<td><input type='hidden' name="title" value=제목>${boardItem.title}</td>
		</tr>
		<tr>
			<td><b>작성자</b></td>
			<td><input type='hidden' name="author" value=제목>${boardItem.author}</td>
		</tr>

		<tr>
			<td><b>일자</b></td>
			<td><input type='hidden' name="today" value=날짜>
			<fmt:formatDate pattern="yyyy-MM-dd" value="${boardItem.created}" /></td>
		</tr>
		<tr>
			<td><b>조회수</b></td>
			<td>${boardItem.view}</td>
		</tr>
		
		<tr>
		<td><b>내용</b></td>
		<td><textarea>${boardItem.content}
		</textarea></td>
		</tr>
	</table>


	<table>
		<tr>
			<td></td>
			<td><input type=button value="목록"
				OnClick="location.href='./allView'"></td>
			<td><input type=button value="수정"
				OnClick="location.href='./updateView?id=${boardItem.id}'"></td>
			<td><input type=button value="삭제"
				OnClick="location.href='./DB_Delete?id=${boardItem.id}'"></td>
		</tr>
	</table>

</body>
</html>