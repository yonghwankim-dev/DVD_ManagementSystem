<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DVD 추가</title>
<link rel="stylesheet" href="/DVD/css/dvd_admin/update.css">

</head>
<body>
	<form action="/DVD/index/dvd_admin/update" method="post" name="update_form">
		<h1>DVD 수정</h1>
		<div class="container">
				<label style="hidden"><input type="hidden" name="d_num" value="${updatedDVD.d_num}"/></label>
				<label>제목</label><input type="text" name="title" placeholder="제목" value="${updatedDVD.title}"></p>
				<label>감독</label><input type="text" name="director" placeholder="감독" value="${updatedDVD.director}">
				<label>장르</label><input type="text" name="category" placeholder="장르" value="${updatedDVD.category}">
				<label>관람등급</label><input type="text" name="rating" placeholder="관람등급" value="${updatedDVD.rating}">
				<label>대여가격</label><input type="text" name="borrow_fee" placeholder="대여가격" value="${updatedDVD.d_borrow_fee}">
				<label>출시일</label><input type="date" name="release_date" placeholder="출시일" value="${updatedDVD.release_date}">
		</div>
		<div class="container">
			<input type="submit" class="btn" name="update" value="수정">
		</div>
	</form>
	
	<script type="text/javascript" src="/DVD/js/dvd_admin.js"></script>
	<script type="text/javascript" src="/DVD/js/jquery-3.6.0.min.js"></script>
</body>
</html>