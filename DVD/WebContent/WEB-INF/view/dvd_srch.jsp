<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/DVD/css/dvd_search.css">
    <link rel="stylesheet" href="/DVD/css/common.css">
    <title>DVD 검색</title>
</head>

<body>
    <div class="main">
        <div class="main__container">
            <form action="" method="post">
                <div class="main__row">
                    <select name="category" class="main__category">
                        <option>주연</option>
                    </select>
                </div>
                <div class="main__row">
                    <input type="text" name="content" class="main__input">
                </div>

                <div class="main__row">
                    <label><input type="radio" class="main__release" name="release" value="recent" checked>최신순</label>
                    <label><input type="radio" class="main__release" name="release" value="old">과거순</label>
                </div>

                <div class="main__row">
                    <input type="submit" value="검색">
                    <input type="button" class="cancelBtn" onclick="location.href='/DVD/index'" value="취소">
                </div>
            </form>
        </div>
    </div>
</body>

</html>