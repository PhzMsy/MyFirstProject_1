<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
            $(".update").click(function (){
                let id = $(this).next().val();
                location = "hero/update.jsp?id="+id;
            });

            $(".delete").click(function (){
                let id = $(this).prev().val();
                $.ajax({
                    url:"<%=request.getContextPath()%>/Champion?m=delete&id="+id,
                    dataType:"json",
                    success:function (resp){
                        if(resp){
                            // 刷新页面
                            location.reload();
                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<table>
    <tr>
        <td></td>
        <td>编号</td>
        <td>姓名</td>
        <td>星级</td>
        <td>定位</td>
        <td>
            操作 |||<input type="button" value="添加" id="add">
        </td>
    </tr>
    <c:forEach items="${champion}" var="u">
        <tr>
            <td></td>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.star}</td>
            <td>${u.hero.career}</td>
            <td>
                <!-- $(this).next().val(); -->
                <input type="button" value="修改" class="update">
                <input type="hidden" value="${u.id}">
                <input type="button" value="删除" class="delete">
            </td>
            <td></td>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    // 获取id是add的元素
    let add = document.getElementById("add");
    // 绑定点击事件
    add.onclick = function (){
        // 跳转
        location = "<%=request.getContextPath()%>/hero/add.jsp";
    }
</script>
</html>
