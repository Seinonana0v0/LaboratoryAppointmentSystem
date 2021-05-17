<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/5/17
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        $(function(){
            alert(1);
            var jsonStr ={"tea_id":2000090101}
            $.ajax({
                url:"${pageContext.request.contextPath}/teacher/ajaxShowClassNames",
                data:{"tea_id":2000090101},
                dataType:"json",
                type:"post",
                success:function (data){
                    var classnames_js =document.getElementById("classnames");
                    var classnames = $(classnames_js);

                    $(data).each(function (){
                        alert(this);
                        classnames.append("<option value='"+this+"'>"+this+"</option>");
                    });
                }
            });
        });
    </script>
    <title>Title</title>
</head>
<body>
    <form>
        <select id="classnames">
            <option>请选择</option>
        </select>
    </form>

</body>
</html>
