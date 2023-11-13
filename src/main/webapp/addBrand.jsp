<%--
  Created by IntelliJ IDEA.
  User: zhengnan
  Date: 2023/04/05
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="./css/common.css">
</head>
<body>
    <h1>ブランドの追加</h1>
    <form method="post" action="/brand-demo/addOneServlet">
        <div class="item-sec">
            <label for="brandName">ブランドネーム</label>
            <input type="text" name="brandName" id="brandName" />
        </div>
        <div class="item-sec">
            <label for="companyName">企業</label>
            <input type="text" name="companyName" id="companyName" />
        </div>
        <div class="item-sec">
            <label for="ordered">順位</label>
            <input type="text" name="ordered" id="ordered" />
        </div>
        <div class="item-sec">
            <label for="description">詳細</label>
            <textarea name="description" cols="30" rows="8" id="description"></textarea>
        </div>
        <div class="item-sec">
            <label>状態</label>
            <label for="unavailable">有効</label>
            <input type="radio" name="status" value="1" id="unavailable"/>
            <label for="available">無効</label>
            <input type="radio" name="status" id="available" value="0"/>
        </div>
        <div class="btn-group">
            <input type="submit" value="送信">
            <input type="reset" value="リセット">
        </div>
    </form>
</body>
</html>
