<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	text-align: center;
}

#foot {
	margin-top: 10px;
	text-align: center;
	 display: inline;
}

.search {
    display: inline;
} 
</style> 


</head>
<body>
	<div style="text-align: center;">
		<h1>Poly 자유 게시판</h1>
		<table style="width: 700px; margin: auto">
			<tr>
				<th style="width: 10%">번호</th>
				<th style="width: 50%">제목</th>
				<th style="width: 15%">작성자</th>
				<th style="width: 15%">등록일</th>
				<th style="width: 10%">조회수</th>
			</tr>
			<c:forEach var="board" items="${pageList}">
				<tr>
					<td>${board.seq}</td>
					<td style="text-align: left"><a
						href="getBoard?seq=${board.seq}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.createDate}"
							pattern="yyyy-MM-dd"></fmt:formatDate></td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<div id="foot">
			<input type=button value="목록"
				OnClick="location.href='boardList?page=0&ccPage=1'">
			<input type=button value="글쓰기"
				OnClick="location.href='insertBoardView'">
		</div>
		<div>
 		<c:forEach var="cPage" items="${pageNum}">
 		<a href = "/board/boardList?page=${cPage-1}&cPage=${cPage}">${cPage}</a>
		</c:forEach> 
		</div>
		
		
		<form action="search" method="GET">
			<div class="search">
				<input name="keyword" type="text" placeholder="검색어를 입력해주세요">
			<button>검색하기</button>
			</div>
		</form>
	</div>
</body>
</html>