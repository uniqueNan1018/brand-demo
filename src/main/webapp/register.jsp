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
        <title>Title</title>
        <link rel="stylesheet" href="./css/common.css">
    </head>
    <body>
        <h1>新規ユーザー登録</h1>
        <c:if test="${errMsg != null}">
            <div class="error-msg">
                ${errMsg}
            </div>
        </c:if>
        <form action="/brand-demo/userRegisterServlet" method="post">
            <div>
                <label for="username">ユーザーネーム</label>
                <input type="text" name="username" id="username" />
            </div>
            <div>
                <label for="password">パスワード</label>
                <input type="password" name="password" id="password">
            </div>
            <div>
                <label>性別</label>
                <label for="male">男</label>
                <input type="radio" name="gender" value="男" id="male"/>
                <label for="female">女</label>
                <input type="radio" name="gender" id="female" value="女"/>
            </div>
            <div>
                <label for="addr">住所</label>
                <textarea id="addr" name="addr" rows="3" cols="20"></textarea>
            </div>
            <div class="check-img-container">
                <label>認証コード</label>
                <input type="text" name="checkCode" id="checkCode" />
                <img id="checkCodeImage" src="/brand-demo/checkCodeServlet">
                <a id="changeImg" href="#">良く見えません</a>
            </div>
            <div class="btn-group">
                <input type="submit" value="登録">
                <input type="reset" value="リセット">
            </div>
        </form>
    </body>
    <script>
        document.getElementById("changeImg").onclick = () => {
            let milliseconds = new Date().getMilliseconds();
            document.getElementById("checkCodeImage").src = "/brand-demo/checkCodeServlet?" + milliseconds;
        }
    </script>
</html>
