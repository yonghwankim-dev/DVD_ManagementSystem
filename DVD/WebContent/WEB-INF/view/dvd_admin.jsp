<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/regi_dvds.css">
    <link rel="stylesheet" href="../css/common.css">
    <title>DVD 관리 페이지</title>
</head>

<body>
    <div class="main">
        <form action="" method="post">
            <div class="main__table__container">
                <table class="main__table">
                    <thead>
                        <tr>
                            <th>주연</th>
                            <th>제목</th>
                            <th>장르</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>김윤석</td>
                            <td>추격자</td>
                            <td>공포</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="main__btns">
                <input type="submit" value="추가">
                <input type="submit" value="업데이트">
                <input type="submit" value="삭제">
                <input type="submit" value="새로 고침">
                <input type="button" class="cancelBtn" onclick="location.href='/DVD/index'" value="종료">
            </div>
        </form>
    </div>
</body>

</html>