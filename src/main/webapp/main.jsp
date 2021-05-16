<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>实验室预约系统主页</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <style>
        body{
            background-image: url("./images/bg1.jpg");
            background-size:cover;
            background-attachment:fixed;
        }
        #banner{
            background-color:sandybrown;
            border-radius: 5px;
            height: 100px;
            width: 500px;
            text-align: center;
            margin: auto;
            margin-top: 30px;
            padding-top: 5px;
        }
        .box-body{
            width: 1300px;
            height: 300px;
            margin: auto;
            margin-top: 50px;
        }
        .toLogin{
            float: left;
            width: 300px;
            height: 200px;
            margin-left: 100px;
            margin-top: 50px;
            background: orange;
        }
        img{
            width: 100px;
            height: 100px;
            margin-top: 50px;
            margin-left: 10px;
            float: left;
        }
        h2{
            margin-top: 80px;
            float: left;
            margin-left: 10px;
        }
        #img1{

        }
    </style>
</head>
<body>
<div id="banner">
    <h1>欢迎使用实验室预约系统</h1>
</div>

<div class="box-body">
    <div class="toLogin">
        <div>
            <img src="${pageContext.request.contextPath}/images/student.jpg" class="user-image" alt="User Image">
            <a href="${pageContext.request.contextPath}/studentlogin.jsp"><h2>我是学生</h2></a>
        </div>
    </div>

    <div class="toLogin">
        <div>
            <img src="${pageContext.request.contextPath}/images/teacher.jpg" class="user-image" alt="User Image">
            <a href=""><h2>我是老师</h2></a>
        </div>

    </div>

    <div class="toLogin">
        <div>
            <img src="${pageContext.request.contextPath}/images/admin.jpg" class="user-image" alt="User Image">
            <a href="${pageContext.request.contextPath}/adminlogin.jsp"><h2>我是管理员</h2></a>
        </div>

    </div>

</div>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>