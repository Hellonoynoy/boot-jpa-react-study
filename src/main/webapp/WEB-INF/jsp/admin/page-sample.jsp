<%--
  Created by IntelliJ IDEA.
  User: noynoy
  Date: 2016. 1. 20.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--[if IE 8]> <html lang="ko" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="ko" class="ie9 no-js"> <![endif]-->
<!--[if !IE]> <html lang="ko"> <!<![endif]-->
<head>
    <jsp:include page="/admin/layout/global.include"/>

    <!-- layout styles -->
    <link href="/admin/css/layout/layout.css" rel="stylesheet" type="text/css" />
    <link href="/admin/css/layout/custom.css" rel="stylesheet" type="text/css" />
    <link href="/admin/css/layout/themes/default.css" rel="stylesheet" type="text/css"/>
    <link href="/admin/css/pages/search.css" rel="stylesheet" type="text/css" />
    <!-- layout styles -->

</head>
<body class="page-header-fixed page-sidebar-closed-hide-logo page-container-bg-solid page-content-white">

    <jsp:include page="/admin/layout/top.include"/>

    <div class="page-container">

        <jsp:include page="/admin/layout/sidebar.include"/>

        <div class="page-content-wrapper">

            <div class="page-content">

                <div class="page-bar">
                    <ul class="page-breadcrumb">
                        <li>
                            <a href="/src/main/webapp">Home</a>
                            <i class="fa fa-circle"></i>
                        </li>
                        <li>
                            <span>{} 관리</span>
                        </li>
                    </ul>
                </div>

                <h3 class="page-title"> {} 관리
                    <small> &nbsp; {} </small>
                </h3>

                <div class="note note-danger">
                    <p>기능 추가 예정 - </p>
                </div>

            </div>

        </div>

    </div>

    <jsp:include page="/admin/layout/footer.include"/>

</body>
</html>
