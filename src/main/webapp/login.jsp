<%--
  Created by IntelliJ IDEA.
  User: zhengnan
  Date: 2023/04/05
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>ログイン</title>
        <link rel="stylesheet" href="./css/common.css">
    </head>
    <body>
        <h1>ログイン</h1>
        <c:if test="${errMsg!=''}">
            <div class="error-msg">${errMsg}</div>
        </c:if>
        <form action="/brand-demo/selectUserServlet" method="post">
            <div>
                <label for="username">ユーザーネーム</label>
                <input type="text" name="username" id="username" value="${cookie.username.value}" />
            </div>
            <div>
                <label for="password">パスワード</label>
                <input type="password" name="password" id="password" value="${cookie.password.value}">
            </div>
<%--            --%>
            <div>
                <label for="password">次回から自動で入力</label>
                <input type="checkbox" name="remember" value="1">
            </div>
            <div class="btn-group">
                <input type="submit" value="ログイン">
                <input type="reset" value="リセット">
            </div>
        </form>
        <div class="btn-group">
            <a href="register.jsp">アカウントはありませんか？　今すぐ登録</a>
        </div>
    </body>
</html>
