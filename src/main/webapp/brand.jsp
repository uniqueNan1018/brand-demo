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
<script>

</script>
<body>
    <div>
        ${user.username}、こんにちは！
    </div>
    <section class="sec-block">
        <input type="button" value="追加" id="addBtn" />
    </section>
    <table border="1">
        <tr>
            <th>番号</th>
            <th>ブランドネーム</th>
            <th>企業</th>
            <th>順位</th>
            <th>詳細</th>
            <th>状態</th>　
            <th>操作</th>　
        </tr>
        <c:forEach items="${brands}" var="brand" varStatus="status">
            <tr>
                <td>${status.count}</td>
    <%--            <td>${brand.id}</td>--%>
                <td>${brand.brandName}</td>
                <td>${brand.companyName}</td>
                <td>${brand.ordered}</td>
                <td>${brand.description}</td>
                <td>
                    <c:if test="${brand.status == 1}">
                        有効
                    </c:if>
                    <c:if test="${brand.status == 0}">
                        無効
                    </c:if>
                </td>
                <td>
                    <a href="#" onclick="modifyHandler(${brand.id})">修正</a>
                    <a href="#">削除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
<script>
    const addBtn = document.getElementById("addBtn");
    addBtn.onclick = () => {
        window.location = "/brand-demo/addBrand.jsp"
    };

    const modifyHandler = (id) => {
        // console.log(id);
        window.location.href = "/brand-demo/selectByIdServlet?id=" + id;
    }

    const deleteHandler = (id) => {

    }
</script>
</html>
