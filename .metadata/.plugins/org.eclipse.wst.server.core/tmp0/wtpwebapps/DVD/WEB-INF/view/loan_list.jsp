<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/loan_list.css">
    <title>대여목록</title>
</head>
<body>
    <div class="main">
        <h2>대여목록</h2>
        <div class="main__container">
            <form action="/DVD/index/loan_list" method="post">
                <select name="category">
                    <option>이름</option>
                </select>
                <input type="text" name="content">
                <input type="submit" name="search" value="검색">
                <input type="submit" name="search" value="전체보기">
                <input type="button" class="cancelBtn" name="cancel" onclick="location.href='/DVD/index'" value="종료">
            </form>
        </div>
    </div>
    
</body> 
</html>