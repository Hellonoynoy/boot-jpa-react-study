<%--
  Created by IntelliJ IDEA.
  User: noynoy
  Date: 2016. 1. 20.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="page-header navbar navbar-fixed-top">
    <div class="page-header-inner ">

        <div class="page-logo">
            <a href="/src/main/webapp"><h4 style="font-size:29px;color:#FFF;">whistle</h4></a>
            <div class="menu-toggler sidebar-toggler"></div>
        </div>

        <a href="javascript:;" class="menu-toggler responsive-toggler" data-toggle="collapse" data-target=".navbar-collapse"> </a>

        <div class="top-menu">
            <ul class="nav navbar-nav pull-right">
                <li class="dropdown dropdown-user">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
                        <img alt="" class="img-circle" src="/admin/images/avatar.png" />
                        <span class="username username-hide-on-mobile"> ${name} </span>
                        <i class="fa fa-angle-down"></i>
                    </a>
                </li>

                <li class="dropdown dropdown-quick-sidebar-toggler">
                    <a href="javascript:;" class="dropdown-toggle">
                        <i class="icon-logout"></i>
                    </a>
                </li>

            </ul>
        </div>

    </div>
</div>

<div class="clearfix"></div>
