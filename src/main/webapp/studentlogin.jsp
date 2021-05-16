<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>学生登陆</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <style>
        body{
            background-image: url("${pageContext.request.contextPath}/images/bg1.jpg");
            background-size:cover;
            background-attachment:fixed;
        }

        #loginform{
            margin: auto;
            width: 400px;
            background-color: whitesmoke;
            padding: 50px;
        }
        #banner1{
            font-size: xx-large;
            align-content: center;
            padding-left: 110px;
            padding-top:20px;
            width: 400px;
            margin: auto;
            margin-top: 80px;
            background-color: whitesmoke;
        }
        #submitbtn{
            align-self: center;
            margin-top: 10px;
            margin-left: 110px;
        }
        #message{
            width: 300px;
            margin: auto;

        }
        #vcodediv1{
            float: left;
        }
        #vcodediv2{
            float: left;
            margin-top: 20px;
            margin-left:30px;
        }
    </style>

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script>
        function refreshCode(){
            var vcode = document.getElementById("vcode");
            vcode.src = "${pageContext.request.contextPath}/verifyCodeController/verifyCode?time="+new Date().getTime();
        }
    </script>
</head>
<body>
<div>
    <div id="banner1">学生登陆</div>


    <form id="loginform" action="${pageContext.request.contextPath}/student/studentLogin" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">学号账号</label>
            <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入学号" name="id">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">密码</label>
            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="请输入密码" name="stu_password">
        </div>
        <div class="form-group">
            <div id="vcodediv1">
                <label for="vcode">验证码：</label>
                <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
            </div>
            <div id="vcodediv2"><a href="javascript:refreshCode()"><img src="${pageContext.request.contextPath}/verifyCodeController/verifyCode" title="看不清点击刷新" id="vcode"/></a></div>
        </div>

        <button type="submit" class="btn btn-default" id="submitbtn">登陆</button>
    </form>
    <div class="alert alert-warning alert-dismissible" role="alert" id="message">
        <button type="button" class="close" data-dismiss="alert" >
            <span>&times;</span></button>
        <strong>${requestScope.msg}</strong>
    </div>

</div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
</body>
</html>