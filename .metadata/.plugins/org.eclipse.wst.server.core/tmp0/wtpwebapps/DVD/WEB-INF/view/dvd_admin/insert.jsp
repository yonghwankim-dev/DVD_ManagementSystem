<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD 추가</title>
<link rel="stylesheet" href="/DVD/css/dvd_admin/insert.css">

</head>
<body>
	<form action="/index/dvd_admin/insert" method="post" name="insert_form">
		<h1>DVD 추가</h1>
		<div class="container">
				<label>제목</label><input type="text" name="title" placeholder="제목"></p>
				<label>감독</label><input type="text" name="director" placeholder="감독">
				<label>장르</label><input type="text" name="category" placeholder="장르">
				<label>관람등급</label><input type="text" name="rating" placeholder="관람등급">
				<label>대여가격</label><input type="text" name="borrow_fee" placeholder="대여가격">
				<label>출시일</label><input type="date" name="release_date" placeholder="출시일">
		</div>
		<div class="container">
			<input type="button" class="insertbtn" name="insert" value="추가" onclick="submitInsertPopUp()">
		</div>
	</form>
	
	<script type="text/javascript" src="/DVD/js/dvd_admin.js"></script>
</body>
</html>