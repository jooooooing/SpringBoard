<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	width : 90px;
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

textarea{
	resize: none;

}

#boardTxt {
	width: 590px; 
	height: 200px; 
}

#reply {
	width: 550px; 
	height: 20px; 
}
</style>
<script>
	function submitFormBoardContent(mode) {
		var myform = document.boardContent;
		if (mode == 1) {
			myform.action = "/board/boardUpdateForm";
		}
		if (mode == 2) {
			myform.action = "/board/deleteBoard";
		}
	}

	function submitFormBoardReplyDepthOne(mode) {
		var myform = document.boardReplyDepthOne;
		if (mode == 1) {
			myform.action = "/board/createBoardReply";
		}
	}

	function submitFormBoardReplyDepthTwo(mode) {
		var myform = document.articleReplyDepthTwo;
		if (mode == 1) {
			myform.action = "/board/creatBoardReply";
		}
	}
</script>

</head>
<body>
	<div style="text-align: center;">
		<h1>상세조회</h1>
		<form action="updateBoard" method="post">
			<input type="hidden" name="seq" value="${board.seq}" />
			<table style="width: 700px; margin: auto">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${board.title}" /></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" value="${board.writer}" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea id = "boardTxt" name="content">${board.content}</textarea></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><fmt:formatDate value="${board.createDate}"
							pattern="yyyy-MM-dd"></fmt:formatDate></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${board.cnt}</td>
				</tr>
			</table>
			<div id="foot">
				<input type="button" value="삭제"
					OnClick="location.href='deleteBoard?seq=${board.seq}'" /> <input
					type="button" value="목록" OnClick="location.href='boardList'" /> <input
					type="submit" value="수정" />
			</div>
		</form>
		<br>
		<form name="boardReplyDepthOne" method="post">
			<table style="width: 700px; margin: auto">
				<tr>
					<th>작성자</th>
					<th>댓 글</th>
				</tr>
				<tr>
					<td><input id =replyWirter type=text name=replyWriter required='required'></td>
					<td><textarea id ="reply"
							name=replyContent required='required'></textarea>
					</td>
				</tr>
			</table>

			<input type=submit value="댓글 작성" onclick="submitFormBoardReplyDepthOne(1)"> 
			<input type=hidden name=depth value=1> 
			<input type=hidden name=replyId value="${board.seq}">
		</form>

	</div>
</body>
</html>