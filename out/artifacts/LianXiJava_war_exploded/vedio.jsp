<%--
  Created by IntelliJ IDEA.
  User: 14408
  Date: 2021/3/13
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--jstl-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 屏蔽tomcat 自带的 EL表达式 -->
<%@ page isELIgnored="false" %>
<html>
<head>
    <!-- basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- mobile metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <!-- site metas -->
    <title></title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- site icon -->
    <link rel="icon" href="${pageContext.request.contextPath}/images/fevicon.png" type="image/png" />
    <!-- bootstrap css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <!-- site css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" />
    <!-- responsive css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/responsive.css" />
    <!-- color css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/color.css" />
    <!-- select bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.css" />
    <!-- scrollbar css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfect-scrollbar.css" />
    <!-- custom css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" />
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="dashboard dashboard_1">
<div class="full_container">
    <div class="inner_container">
        <!-- Sidebar  -->
        <nav id="sidebar">

        </nav>
        <!-- end sidebar -->
        <!-- right content -->
        <div id="content">
            <!-- topbar -->
            <div class="topbar" id="topbar">

            </div>
            <!-- end topbar -->
            <!-- dashboard inner -->
            <div class="midde_cont">
                <div class="container-fluid">
                    <div class="row column_title">
                        <div class="col-md-12">
                            <div class="page_title">
                                <h2>CSS</h2>
                            </div>
                        </div>
                    </div>
                    <!-- row -->
                    <div class="row column4 graph">
                        <!-- tab style 视频 -->
                        <c:forEach items="${list}" var="vedio">
                            <div class="col-md-6">
                                <div class="white_shd full margin_bottom_30">
                                    <div class="full graph_head">
                                        <div class="heading1 margin_0">
                                            <h2>${vedio.vName}</h2>
                                        </div>
                                    </div>
                                    <div class="full inner_elements">
                                        <div class="row">
                                            <div class="col-md-12">
                                                <video width="520" height="300" controls>
                                                    <source src="/${vedio.vAddress}"
                                                            type="video/mp4">
                                                </video>
                                            </div>
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </c:forEach>
                        <!-- end dashboard inner -->
                    </div>
                    <!-- jQuery -->
                    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
                    <script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
                    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
                    <!-- wow animation -->
                    <script src="${pageContext.request.contextPath}/js/animate.js"></script>
                    <!-- select country -->
                    <script src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
                    <!-- owl carousel -->
                    <script src="${pageContext.request.contextPath}/js/owl.carousel.js"></script>
                    <!-- chart js -->
                    <script src="${pageContext.request.contextPath}/js/Chart.min.js"></script>
                    <script src="${pageContext.request.contextPath}/js/Chart.bundle.min.js"></script>
                    <script src="${pageContext.request.contextPath}/js/utils.js"></script>
                    <script src="${pageContext.request.contextPath}/js/analyser.js"></script>
                    <!-- nice scrollbar -->
                    <script src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
                    <script>
                        var ps = new PerfectScrollbar('#sidebar');
                    </script>
                    <!-- custom js -->
                    <script src="${pageContext.request.contextPath}/js/custom.js"></script>
                    <script src="${pageContext.request.contextPath}/js/chart_custom_style.js"></script>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!--sidebar-->
<script>
    $(function(){
        $.ajax({
            type:"get",
            url:"/pages/sidebar.jsp",
            async:true,
            success:function(data){
                $("#sidebar").html(data);
            }
        });
    });

</script>
<!--topbar-->
<script>
    $(function(){
        $.ajax({
            type:"get",
            url:"/pages/topbar.jsp",
            async:true,
            success:function(data){
                $("#topbar").html(data);
            }
        });
    });

</script>
</html>
