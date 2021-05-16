<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <style>
        #appoint_time,#appoint_date,#laboratory_name{
            width: 200px;
        }
        .form-group,#message1,#message2{
            margin-left: 100px;
        }
        #Form{
            width: 450px;
        }
        #submitBtn{
            margin-left: 175px;
        }
        #addform{
            margin-left: 350px;
        }
    </style>
    </style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>新增预约</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

<div class="wrapper">

    <!-- 页面头部 -->
    <header class="main-header">

        <!-- Logo -->
        <a href="#" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>学生</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>实验室预约系统</b></span>
        </a>

        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <img src="${pageContext.request.contextPath}/images/student.jpg" class="user-image" alt="User Image">
                            <span class="hidden-xs">${student.stu_name}</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- User image -->
                            <li class="user-header">
                                <img src="${pageContext.request.contextPath}/images/student.jpg" class="img-circle" alt="User Image">

                                <p>
                                    ${student.stu_name}-${student.id}
                                    <small>上次登陆:${lastLoginTime}</small>
                                </p>
                            </li>

                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="${pageContext.request.contextPath}/studentchangepassword.jsp" class="btn btn-default btn-flat">修改密码</a>
                                </div>
                                <div class="pull-right">
                                    <a href="${pageContext.request.contextPath}/student/studentLogout" class="btn btn-default btn-flat">注销</a>
                                </div>
                            </li>
                        </ul>
                    </li>

                </ul>
            </div>
        </nav>
    </header>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="${pageContext.request.contextPath}/images/student.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${student.stu_name}</p>
                    <i class="fa fa-circle text-success"></i> 在线</a>
                </div>
            </div>

            <ul class="sidebar-menu">
                <li class="header "><strong class="text-blue">菜单</strong></li>

                <li id="admin-index"><a href="${pageContext.request.contextPath}/studentmain.jsp"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

                <!-- 菜单 -->
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-table"></i> <span>我的预约记录</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                    <ul class="treeview-menu">

                        <li id="tables-simple">
                            <a href="${pageContext.request.contextPath}/addnewstudentappointment.jsp">
                                <i class="fa fa-circle-o"></i>新增预约
                            </a>
                        </li>

                        <li id="tables-data">
                            <a href="${pageContext.request.contextPath}/student/findByCondition_My?page=1&size=5&dataTable=laboratory_stu1&id=${sessionScope.student.id}">
                                <i class="fa fa-circle-o"></i> 取消预约/使用上报
                            </a>
                        </li>

                    </ul>
                </li>


                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-cogs"></i> <span>账号管理</span>
                        <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                    </a>
                    <ul class="treeview-menu">

                        <li id="system-setting">
                            <a href="${pageContext.request.contextPath}/studentchangepassword.jsp">
                                <i class="fa fa-circle-o"></i> 修改密码
                            </a>
                        </li>

                        <li id="system-setting">
                            <a href="${pageContext.request.contextPath}/student/studentLogout">
                                <i class="fa fa-circle-o"></i> 退出登陆
                            </a>
                        </li>


                    </ul>
                </li>
                <!-- 菜单 /-->
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <!-- @@master = admin-layout.html-->
    <!-- @@block = content -->

    <div class="content-wrapper">
        <!-- 内容头部 -->
        <section class="content-header">
            <h1>
                我的预约
                <small>新增预约</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/studentmain.jsp"><i class="fa fa-dashboard"></i>学生首页</a></li>
                <li><i class="fa fa-dashboard"></i>我的预约</li>
                <li><i class="fa fa-dashboard"></i>新增预约</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">新增预约</h3>
                </div>

                <div class="box-body">
                    <div class="col-md-6 " id="addform">
                        <!-- general form elements -->
                        <div>
                            <form role="form" action="${pageContext.request.contextPath}/student/addNewStudentAppointment" id="Form">
                                <div class="box-body">

                                    <div class="form-group">
                                        <input type="hidden" value="${sessionScope.student.id}" name="stu_id" id="stu_id">
                                    </div>
                                    <div class="form-group">
                                        <label for="dataTable">选择要预约的实验室</label>
                                        <br>
                                        <select id="dataTable" name="dataTable">
                                            <option value="laboratory_stu1" selected>学生实验室一</option>
                                            <option value="laboratory_stu2">学生实验室二</option>
                                            <option value="laboratory_stu3">学生实验室三</option>
                                            <option value="laboratory_stu4">学生实验室四</option>
                                            <option value="laboratory_stu5">学生实验室五</option>
                                        </select>
                                    </div>


                                    <div class="form-group">
                                        <label for="appoint_date">选择预约日期</label>
                                        <input type="date" class="form-control" id="appoint_date"  name="appoint_date">
                                    </div>

                                    <strong class="text-red" id="message1">  </strong>

                                    <div class="form-group">
                                        <label for="appoint_time">选择要时间段</label>
                                        <br>
                                        <select id="appoint_time" name="appoint_time">
                                            <option value="noSelect">未选择</option>
                                            <option value="上午">上午</option>
                                            <option value="下午">下午</option>
                                            <option value="晚上">晚上</option>
                                        </select>
                                    </div>


                                    <strong class="text-red" id="message2"> </strong>


                                </div>
                                <div class="box-footer">
                                    <button type="submit" class="btn btn-primary" id="submitBtn" >提交</button>
                                </div>
                                <div class="alert alert-warning alert-dismissible" role="alert" id="requestMessage">
                                    <button type="button" class="close" data-dismiss="alert" >
                                        <span>&times;</span></button>
                                    <strong id="requestMsg">${requestScope.msg}</strong>
                                </div>
                            </form>
                        </div>
                    </div>


                </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- @@close -->
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.0
        </div>
        <strong>Copyright &copy;  <a href="https://www.hhu.edu.cn/">河海大学</a> </strong> 计算机与信息学院
    </footer>
    <!-- 底部导航 /-->
</div>


<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
<script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>

    $(document).ready(function() {

        // 选择框
        $(".select2").select2();

        // WYSIHTML5编辑器
        $(".textarea").wysihtml5({
            locale: 'zh-CN'
        });
    });


    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function() {

        // 激活导航位置
        setSidebarActive("admin-datalist");

        // 列表按钮
        $("#dataList td input[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作

    });

    var appoint_time_js = document.getElementById("appoint_time");
    var stu_id_js = document.getElementById("stu_id")
    var appoint_date_js =document.getElementById("appoint_date");
    var dataTable_js = document.getElementById("dataTable");
    var message1 = document.getElementById("message1");
    var message2 = document.getElementById("message2");
    var submitBtn = document.getElementById("submitBtn");

    $(appoint_time_js).blur(function (){

        var stu_id = $(stu_id_js).val();
        var appoint_date = $(appoint_date_js).val();
        var appoint_time = $(appoint_time_js).val();
        var dataTable = $(dataTable_js).val();
        var jsonStr={"stu_id":stu_id,"dataTable":dataTable,"appoint_date":appoint_date,"appoint_time":appoint_time}

        $.ajax({
            url:"${pageContext.request.contextPath}/student/ajaxTestAppointment",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify(jsonStr),
            dataType:"json",
            type:"post",
            success:function (data){

                if(data.rightDate==false){
                    $(message1).html("请选择正确的日期");
                    $(appoint_date_js).val("");
                    $(appoint_time_js).val("noSelect");
                    $(submitBtn).attr("disabled","disabled");
                }

                if(data.count>=2) {
                    $(message2).html("当前时间段预约人数过多")
                    $(appoint_date_js).val("");
                    $(appoint_time_js).val("noSelect");
                    $(submitBtn).attr("disabled", "disabled");
                }

                if(data.alreadyAppoint==true) {
                    $(message2).html("你已经预约过你选择日期的这个时间段了");
                    $(appoint_date_js).val("");
                    $(appoint_time_js).val("noSelect");
                    $(submitBtn).attr("disabled", "disabled");
                }

                if(data.rightDate==true&&data.count<2&&data.alreadyAppoint==false){
                    $(message1).html(" ");
                    $(message2).html(" ");
                    $(submitBtn).removeAttr("disabled");
                }

            }
        });
    });

    var Form = document.getElementById("Form");
    $(Form).submit(function (){
        if($(appoint_time_js).val()=="noSelect"){
            alert("请选择时间段");
            return false;
        }
    });


</script>
</body>

</html>