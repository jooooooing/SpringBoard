<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*,javax.sql.*, java.io.*"%>

<%@ page import="java.util.Calendar"%>
<html>
<head>
<title>새 글 추가</title>
<style type="text/css">
textarea {
	width: 100%;
	text-align: left;
	resize: none;
}
</style>
</head>
<body>
	<FORM METHOD=POST name='fm' action="./DB_Write">
		<table width=650 border=1 cellspacing=0 cellpadding=5>
			<tr>
				<td><b>번호</b></td>
				<td>신규(insert)<input type=hidden name=id value='INSERT'></td>
				<!--hidden 은 사용자가 변경해선 안되는 데이터를 보낼 때 사용-->
			</tr>
			<tr>
				<td><b>제목</b></td>
				<td><input type="text" name=title size=70 maxlength=70
					required></td>
			</tr>
			<tr>
				<td><b>일자</b></td>
				<td></td>
			</tr>
			<tr>
				<td><b>내용</b></td>
				<td><textarea
						style='width: 500px; height: 250px; overflow-y: scroll'
						name=content cols=70 row=600 required></textarea></td>
			</tr>
		</table>
		<table width=650>
			<tr>
				<td width=600></td>
				<td><input type=button value="취소"
					onClick="window.location='./allView'"></td>
				<td><input type=submit value="저장"></td>
			</tr>
		</table>
	</FORM>
</body>
</html>
