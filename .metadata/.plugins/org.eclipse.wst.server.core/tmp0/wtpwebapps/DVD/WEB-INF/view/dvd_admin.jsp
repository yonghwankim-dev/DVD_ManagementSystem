<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/DVD/css/dvd_admin.css">
    <link rel="stylesheet" href="/DVD/css/common.css">
    <title>DVD 관리 페이지</title>
</head>

<body>
    <div class="main">
        <form action="/DVD/index/dvd_admin" method="post">
            <div class="main__table__container">
                <table class="main__table">
                    <thead>
                        <tr>
                        	<th><input type="checkbox" nmae="allchk" onclick="selectAll(this)"></th>
                        	<th>제목</th>
	                        <th>감독</th>
	                        <th>장르</th>
	                        <th>관람등급</th>
	                        <th>대여가격</th>
	                        <th>출시일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dvd" items="${dvd_list}">
		                	<tr>
		                		<td><input type="checkbox" name="chk" value="${dvd.d_num}"></td>
		                        <td>${dvd.title}</td>
		                        <td>${dvd.director}</td>
		                        <td>${dvd.category}</td>
		                        <td>${dvd.rating}</td>
		                        <td>${dvd.d_borrow_fee}</td>
		                        <td>${dvd.release_date}</td>
		                    </tr>
                		</c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="main__btns">
                <input type="button" name="cmd" value="추가" onclick="openInsertPopUp()">
                <input type="submit" name="cmd" value="수정">
                <input type="submit" name="cmd" value="삭제">
                <input type="submit" name="cmd" value="새로 고침">
                <input type="button" class="cancelBtn" onclick="location.href='/DVD/index'" value="종료">
            </div>
        </form>
    </div>
    
    <script type="text/javascript" src="/DVD/js/dvd_admin.js"></script>   
    <script type="text/javascript" src="/DVD/js/jquery-3.6.0.min.js"></script>
</body>

</html>