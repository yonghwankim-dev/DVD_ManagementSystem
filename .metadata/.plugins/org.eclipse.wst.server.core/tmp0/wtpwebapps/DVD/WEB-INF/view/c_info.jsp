<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/DVD/css/c_info.css">
    <link rel="stylesheet" href="/DVD/css/common.css">
    <title>고객정보 조회</title>
</head>

<body>
    <div class="main">
        <div class="main__table__container">
            <table class="main__table">
                <thead>
                    <tr>
                        <th>C_NUM</th>
                        <th>ID</th>
                        <th>비밀번호</th>
                        <th>이름</th>
                        <th>주민등록번호</th>
                        <th>주소</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach var="customer" items="${c_info_list}">
	                	<tr>
	                        <td>${customer.c_num}</td>			<!-- 회원번호 -->
	                        <td>${customer.id}</td>				<!-- ID -->
	                        <td>${customer.password}</td>		<!-- 비밀번호 -->
	                        <td>${customer.name}</td>			<!-- 이름 -->
	                        <td>${customer.register_num}</td>	<!-- 주민등록번호 -->
	                        <td>${customer.address}</td>		<!-- 주소 -->
	                    </tr>
                	</c:forEach>
                </tbody>
            </table>
        </div>
        <div class="main__search">
            <form action="/DVD/index/c_info" method="post">
                <table class="search__table">
                    <tbody>
                        <tr>
                            <td><input type="text" name="name" placeholder="이름"></td>
                            <td><input type="submit" name="search" value="이름검색"></td>
                            <td rowspan="2"><input type="submit" id="all" name="search" value="전체보기"></td>
                            <td><input type="submit" name="search" value="가족검색"></td>
                        </tr>
                        <tr>
                            <td><input type="text" name="id" placeholder="ID"></td>
                            <td><input type="submit" name="search" value="ID검색"></td>
                            <td><input type="button" id="cancel" class="cancelBtn" onclick="location.href='/DVD/index'" value="취소"></td>
                        </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>
</body>

</html>