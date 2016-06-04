<%--
  Created by IntelliJ IDEA.
  User: noynoy
  Date: 2016. 1. 20.
  Time: 오후 2:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="page-sidebar-wrapper">

    <div class="page-sidebar navbar-collapse collapse">

        <ul class="page-sidebar-menu  page-header-fixed " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200" style="padding-top: 20px">
            <li class="sidebar-toggler-wrapper hide">
                <div class="sidebar-toggler"> </div>
            </li>

            <li class="heading">
                <h3 class="uppercase">관리자 메뉴 리스트</h3>
            </li>
            <c:forEach var="item" items="${sidebarMenus}" varStatus="status">
                <li class='nav-item <c:if test="${status.index == 0}">start</c:if> '>
                    <a href="${item.url}" class="nav-link nav-toggle">
                        <i class="${item.icon}"></i>
                        <span class="title">${item.name}</span>
                        <span class="arrow"></span>
                    </a>
                </li>
            </c:forEach>
        </ul>

    </div>

</div>
