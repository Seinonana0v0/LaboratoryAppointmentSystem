<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>实验室使用上报</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <script language="JavaScript"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <!-- 页面meta /-->
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
                实验室使用上报
                <small>上报信息</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="${pageContext.request.contextPath}/studentmain.jsp"><i class="fa fa-dashboard"></i>学生首页</a></li>
                <li><a href="${pageContext.request.contextPath}/student/findByCondition_My?page=1&size=5&dataTable=laboratory_stu1&id=${sessionScope.student.id}"><i class="fa fa-dashboard"></i>取消预约/使用上报</a></li>
                <li><a href="#"><i class="fa fa-dashboard"></i>使用上报</a></li>
            </ol>

        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->

            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">上报信息</h3>
                </div>
                    <form role="form" id="Form" action="${pageContext.request.contextPath}/student/setStatusReported" method="post" enctype="multipart/form-data">
                        <div class="box-body">
                            <div class="form-group">
                                <input type="hidden" name="dataTable" value="${requestScope.realDataTable}">
                            </div>
                            <div class="form-group">
                                <label for="dataTable">实验室名称</label>
                                <input type="text" class="form-control" id="dataTable" readonly value="${requestScope.dataTable}">
                            </div>
                            <div class="form-group">
                                <label for="aid">预约记录编号</label>
                                <input type="text" class="form-control" id="aid" readonly value="${requestScope.aid}" name="aid">
                            </div>

                            <div class="form-group">
                                <label for="appoint_date">预约日期</label>
                                <input type="text" class="form-control" id="appoint_date" readonly value="${requestScope.appoint_date}">
                            </div>

                            <div class="form-group">
                                <label for="appoint_time">预约时间段</label>
                                <input type="text" class="form-control" id="appoint_time" readonly value="${requestScope.appoint_time}">
                            </div>

                            <div>
                                <strong>是否发热</strong>
                                是<input type="radio"  value="yes" name="healthy1" >
                                否<input type="radio"  value="no" name="healthy1" checked>
                            </div>
                            <br>

                            <div>
                                <strong>七天内是否有不良症状</strong>
                                是<input type="radio"  value="yes" name="healthy2">
                                否<input type="radio"  value="no" name="healthy2" checked>
                            </div>

                            <br>
                            <div class="form-group">
                                <label for="exampleInputFile">请上传核酸检测结果</label>
                                <input type="file" id="exampleInputFile" name="upload">

                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="submit" class="btn btn-primary">上报</button>
                        </div>
                    </form>
                </div>
            </div>

        <!-- 正文区域 /-->


    <!-- @@close -->
    <!-- 内容区域 /-->

        <!-- 底部导航 -->
        <footer class="main-footer">
            <div class="pull-right hidden-xs">
                <b>Version</b> 1.0.8
            </div>
            <strong>Copyright &copy;  <a href="https://www.hhu.edu.cn/">河海大学</a> </strong> 计算机与信息学院
        </footer>
        <!-- 底部导航 /-->
        </section>
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
        setSidebarActive("admin-blank");
    });


    $(document).ready(function() {
        var requestMsg = document.getElementById("requestMsg").innerHTML;
        if(requestMsg!=null&&requestMsg!=""){
            alert(requestMsg);
        }
    });

    //检验上报日期
    function checkDate(){
        var flag = false;
        var strDate = document.getElementById("appoint_date").value;
        var date = new Date(strDate).getTime();
        var now_date = new Date().getTime();
        if((now_date-date)>0&&(now_date-date)<86400000){
            flag = true;
        }else {
            alert("需在预约日期的当日内上报");
            flag = false;
        }
        return flag;

    }



    var Form = document.getElementById("Form");

    function checkHealthy1(){
        var flag = true;

        var healthy1 = document.getElementsByName("healthy1");

        if(healthy1[0].checked){
            alert("健康状况异常,不可上报!");
            flag = false;
        }

        return flag;
    }

    function checkHealthy2(){
        var flag = true;

        var healthy2 = document.getElementsByName("healthy2");

        if(healthy2[0].checked){
            alert("健康状况异常,不可上报!请及时");
            flag = false;
        }

        return flag;

    }

    function checkFile(){
        var flag = true;
        var upload = document.getElementsByName("upload")
        if(upload[0].value.length<=0){
            alert("请上传核酸检测结果")
            flag = false;
        }

        return flag;

    }

    $(Form).submit(function (){
        if(checkDate()&&checkFile()&&checkHealthy1()&&checkHealthy2()){
            alert("上报成功");
            return true;
        }else {
            return false;
        }
    });

</script>
</body>
</html>