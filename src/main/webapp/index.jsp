<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/2/1
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
    <script>
        $(function (){
/*
            console.log('成功进来了');
*/
            let address = $("#address");
            let sheng = "";
            let shi = "";
            let qu = "";
                getCityByPid(0,'#sheng');
            $("#sheng").change(function (){
                let id = $("#sheng").val();
                getCityByPid(id,'#shi');
                sheng = $("#sheng option:selected").text();
                address.val(sheng);
                $("#shi").empty();
                $("#qu").empty();
            });

            $("#shi").change(function (){
                let id = $(this).val();
                getCityByPid(id,'#qu');
                shi = $("#shi option:selected").text();
                address.val(sheng+shi);
                $("#qu").empty();
            });

            $("#qu").change(function (){
                qu = $("#qu option:selected").text();
                address.val(sheng+shi+qu);
            });

        });
        function getCityByPid(pid,area){
            $.ajax({
                url:"<%=request.getContextPath()%>/Champion",
                data:{pid:pid,m:"queryCity"},
                type:"post",
                dataType:"json",
                success:function (obj){
                    /**
                     * 由于MySQL隐式转换
                     * 此处不给<option>一个value值 默认传<option></option>中间的字符
                     * 若传的是"请选择"三个字 由于隐式转换 则在sql语句中 会变成0
                     */
                    $(area).append("<option value='1'>请选择</option>");
                    for(let c of obj){
                        $(area).append("<option value="+c.id+">"+c.name+"</option>");
                    }
                }
            });
        }
    </script>
</head>
<body>
<a href="Champion?m=query">全部数据</a><br>
<input type="text" id="address"><br>
    <select id="sheng">
    </select>省
    <select id="shi">
    </select>市
    <select id="qu">
    </select>区
</body>
</html>
