<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글상세</title>
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

#foot {
	margin-top: 10px;
	text-align: center;
}
</style>


</head>
<body>
<div style="text-align: center;">
    <h1>상세조회</h1>
    <form action="updateBoard" method="post">
        <input type="hidden" name="seq" value="${board.seq}"/>
        <table style="width: 700px; margin: auto">
            <tr>
            <th>제목</th>
                <td><input type="text" name="title" value="${board.title}"/></td>
            </tr>
            <tr>
            <th>작성자</th>
                <td><input type="text" name="writer" value="${board.writer}"/></td>
            </tr>
            <tr>
            <th>내용</th>
                <td><textarea name="content" cols="70" rows="10">${board.content}</textarea></td>
            </tr>
            <tr>
            <th>등록일</th>
                <td><fmt:formatDate value="${board.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
            </tr>
            <tr>
            <th>조회수</th>
                <td>${board.cnt}</td>
            </tr>
        </table>
                    <div id = "foot">
                        <input type="button" value="삭제"  OnClick="location.href='deleteBoard?seq=${board.seq}'"/>
                        <input type="button" value="목록"  OnClick="location.href='getBoardList'"/>
                        <input type="submit" value="수정"/>
                        <input type="button" value="댓글"/>
                    </div>
    </form>
</div>
</body>
</html>