<%--
  Created by IntelliJ IDEA.
  User: 14408
  Date: 2021/3/14
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/colors.css" />
    <!-- select bootstrap -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-select.css" />
    <!-- scrollbar css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/perfect-scrollbar.css" />
    <!-- custom css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css" />
    <!-- calendar file css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/semantic.min.css" />
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="inner_page login">
<div class="full_container">
    <div class="container">
        <div class="center verticle_center full_height">
            <div class="login_section">
                <div class="logo_login">
                    <div class="center">
                        <img width="210" src="${pageContext.request.contextPath}/images/logo/logo.png" alt="#" />
                    </div>
                </div>
                <div class="login_form">
                    <form id="form">
                        <fieldset>
                            <div class="field">
                                <label class="label_field">Username</label>
                                <input type="text" name="username" placeholder="Username" />
                            </div>
                            <div class="field">
                                <label class="label_field">Password</label>
                                <input type="password" name="password" placeholder="Password" />
                            </div>
                            <div class="field">
                                <label class="label_field hidden">hidden label</label>
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input"> Remember Me</label>
                                <a class="forgot" href="">Forgotten Password?</a>
                            </div>
                            <div class="field margin_0">
                                <label class="label_field hidden">hidden label</label>
                                <button id="login" type="button" class="main_bt">登录</button>
                                <span id="loginInfo" ></span>
                                <a class="forgot" href="">注册</a>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- wow animation -->
<script src="${pageContext.request.contextPath}/js/animate.js"></script>
<!-- select country -->
<script src="${pageContext.request.contextPath}/js/bootstrap-select.js"></script>
<!-- nice scrollbar -->
<script src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
<!--      <script>-->
<!--         var ps = new PerfectScrollbar('#sidebar');-->
<!--      </script>-->

<!-- custom js -->
<script src="${pageContext.request.contextPath}/js/custom.js"></script>



<script>
    $("#login").click(function (){
        $.post("${pageContext.request.contextPath}/user/login",$("#form").serialize(),function (info){
            if(info=="1"){
                location.href="${pageContext.request.contextPath}/study.html";
            }else{
                $("#loginInfo").html("密码错误");
            }
        },"text")
    })
</script>
</body>
</html>