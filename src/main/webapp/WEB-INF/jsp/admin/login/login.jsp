<%--
  Created by IntelliJ IDEA.
  User: noynoy
  Date: 2016. 1. 20.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <title>Wiiple | Administrator Login</title>
    <link href="/webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/webjars/bootstrap-switch/3.3.2/dist/css/bootstrap3/bootstrap-switch.min.css" rel="stylesheet"/>
    <link href="/admin/css/components.css" rel="stylesheet"/>
    <link href="/admin/css/plugins.css" rel="stylesheet"/>
    <link href="/admin/css/pages/login.css" rel="stylesheet"/>
    <script src="/webjars/jquery/2.1.3/dist/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.2/dist/js/bootstrap.min.js"></script>
    <script src="/webjars/bootstrap-switch/3.3.2/dist/js/bootstrap-switch.min.js"></script>
</head>
<body class="login">

    <div class="logo">
        <img src="/images/footer_logo2.png" alt="logo"/>
    </div>

    <div class="content">
        <form class="login-form" onsubmit="return false">
            <h3 class="form-title">Login to your account</h3>
            <div class="alert alert-danger display-hide">
                <button class="close" data-close="alert"></button>
                <span> 입력하신 정보와 일치하는 회원이 없습니다. </span>
            </div>
            <div class="form-group">
                <label class="control-label visible-ie8 visible-ie9">UserId</label>
                <div class="input-icon">
                    <i class="fa fa-user"></i>
                    <input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="UserId" id="adminId" /> </div>
            </div>
            <div class="form-group">
                <label class="control-label visible-ie8 visible-ie9">Password</label>
                <div class="input-icon">
                    <i class="fa fa-lock"></i>
                    <input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="Password" id="password" /> </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn green pull-right"> Login </button>
            </div>
        </form>
    </div>

    <script>

        $(function () {
            $("#adminId, #password").keypress(function () {
                if(!$(".alert").hasClass('display-hide'))
                    $(".alert").addClass('display-hide');
            });

            $("button").click(function () {

                var data = {
                    'userId' : $("#adminId").val(),
                    'password' : $("#password").val()
                }

                if(data.userId.length != 0 && data.password.length != 0) {
                    $.post("/api/login", data)
                            .success(function(response) {
                                if(response == 'none')
                                    $(".alert").removeClass('display-hide');
                                else
                                    window.location.href = response;
                            });

                }

            });

        });


    </script>

</body>
</html>
