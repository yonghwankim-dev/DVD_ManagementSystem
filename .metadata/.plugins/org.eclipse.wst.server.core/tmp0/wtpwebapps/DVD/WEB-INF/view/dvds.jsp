<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- DVD 검색 결과 페이지 -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/DVD/css/dvds.css">
    <link rel="stylesheet" href="/DVD/css/common.css">
    <title>DVD 검색 결과</title>
</head>

<body>
    <div class="main">
        <div class="main__table__container">
            <table class="main__table">
                <thead>
                    <tr>
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
        <div class="main__cancel">
            <input type="button" class="cancelBtn" onclick="location.href='/DVD/index/dvd_srch'" value="종료">
        </div>
    </div>
</body>

</html>