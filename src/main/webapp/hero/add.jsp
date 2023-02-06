<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        /**
         * 准备就绪函数
         * 里面放事件
         *
         */
        $(function(){
            $.ajax({
                url:"<%=request.getContextPath()%>/Champion",
                data:{m:"getHero"},
                type:"post",
                dataType:"json",
                success:function(resp){
                    let select = $("#pid");
                    for(let type of resp){
                        let option = "<option value='"+type.id+"'>"+type.career+"</option>";
                        select.append(option);
                    }
                }
            })

            $("#btn").click(function() {
                $.ajax({
                    url:"<%=request.getContextPath()%>/Champion?m=insert",
                    data:$("#f").serialize(),
                    dataType:"json",
                    type:"post",
                    success:function (resp){
                        if(resp){
                            location = "<%=request.getContextPath()%>/Champion?m=query";
                        }
                    }
                });
            });
        });


    </script>
</head>
<body>
<form id="f">
    <table>
        <tr>
            <td>名称</td>
            <td>
                <input type="text" name="name" id="name">
            </td>
        </tr>
        <tr>
            <td>星级</td>
            <td>
                <input type="radio" name="star" class="star" value="1">一星
                <input type="radio" name="star" class="star" value="2">二星
                <input type="radio" name="star" class="star" value="3">三星
            </td>
        </tr>
        <tr>
            <td>职业</td>
            <td>
                <select name="pid" id ="pid">
                    <option>请选择</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>昵称</td>
            <td>
                <input type="text" name="nickname" id="nickname">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="添加" id="btn">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
