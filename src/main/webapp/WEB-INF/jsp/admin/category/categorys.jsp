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

    <link href="/plugins/jstree/dist/themes/default/style.min.css" rel="stylesheet"/>
    <link href="/plugins/bootstrap-toastr/toastr.min.css" rel="stylesheet" />

    <!-- layout styles -->
    <link href="/admin/css/layout/layout.css" rel="stylesheet"/>
    <link href="/admin/css/layout/custom.css" rel="stylesheet"/>
    <link href="/admin/css/layout/themes/default.css" rel="stylesheet"/>
    <link href="/admin/css/pages/search.css" rel="stylesheet"/>
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
                            <span>카테고리 관리</span>
                        </li>
                    </ul>
                </div>

                <h3 class="page-title"> 카테고리 관리
                    <small> &nbsp; 사이트 카테고리 create & read & upadte & delete</small>
                </h3>

                <div class="note note-danger">
                    <p>기능 추가 예정 - </p>
                </div>

                <div class="row">

                    <div class="col-md-5">

                        <div class="portlet light borderd">

                            <div class="portlet-title">
                                <div class="caption">
                                    <span class="caption-subject bold uppercase">카테고리 목록</span>
                                </div>
                            </div>

                            <div class="portlet-body">
                                <div id="categorytree" style="margin-top:5px;" class="tree-demo">

                                    <ul>
                                        <li id="all-category">
                                            이벤트
                                            <c:if test="${!empty categorys}">
                                                <ul>
                                                    <c:forEach var="item" items="${categorys}">
                                                        <li id="${item.id}" data-depth='${item.depth}'>${item.name}
                                                            <ul>
                                                                <c:forEach var="item2" items="${item.childCategorys}">
                                                                    <li id="${item2.id}" data-jstree='{"depth": "${item2.depth}"}'>${item2.name}
                                                                        <ul>
                                                                            <c:forEach var="item3" items="${item2.childCategorys}">
                                                                                <li id="${item3.id}" data-jstree='{"depth": "${item3.depth}"}'>${item3.name}
                                                                                    <ul>
                                                                                        <c:forEach var="item4" items="${item3.childCategorys}">
                                                                                            <li id="${item4.id}"  data-jstree='{"depth": "${item4.depth}"}'>${item4.name}</li>
                                                                                        </c:forEach>
                                                                                    </ul>
                                                                                </li>
                                                                            </c:forEach>
                                                                        </ul>
                                                                    </li>
                                                                </c:forEach>
                                                            </ul>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </c:if>
                                        </li>
                                    </ul>

                                </div>
                            </div>

                        </div>

                    </div>

                    <div class="col-md-7">

                        <div class="portlet light bordered">
                            <div class="portlet-title">
                                <div class="caption">
                                    <span class="caption-subject font-green-sharp bold uppercase">카테고리 등록 & 수정 </span>
                                </div>
                            </div>

                            <div class="portlet-body form">
                                <form class="form-horizontal" onsubmit="return false;">

                                    <div class="form-group">
                                        <label class="control-label col-md-3">선택한 카테고리</label>
                                        <div class="col-md-9">
                                            <p>
                                                <a href="javascript:;" class="btn btn-info"><i class="fa fa-folder"></i> <span id="selected-name">이벤트</span> </a>
                                                <a href="javascript:;" onclick="addBeforeCategory()" class="btn btn blue"><i class="fa fa-plus"></i> 하위 카테고리 추가 </a>
                                            </p>
                                        </div>
                                    </div>

                                    <div class="form-group" id="savedom" style="display:none">
                                        <label class="control-label col-md-3">카테고리명</label>
                                        <div class="col-md-9">
                                            <input type="text" id="category-name" class="form-control" placeholder="카테고리명">
                                            <span class="help-block">카테고리 이름을 입력하세요</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-offset-3 col-md-9">
                                            <button type="button" class="btn green" id="savebtn" onclick="saveCategory()" style="display:none">저장하기</button>
                                            <button type="button" class="btn green" id="editbtn" onclick="editCategory()" style="display:none">수정하기</button>
                                            <button type="button" class="btn red"   id="deletebtn" onclick="deleteCategory()" style="display:none">삭제하기</button>
                                        </div>
                                    </div>

                                </form>

                            </div>

                        </div>

                    </div>

                </div>

            </div>

        </div>

    </div>

    <jsp:include page="/admin/layout/footer.include"/>
    <script src="/plugins/bootstrap-toastr/toastr.min.js"></script>
    <script src="/plugins/jstree/dist/jstree.min.js"></script>
    <script src="/admin/js/ui-category.js"></script>
    <script src="/admin/js/ui-toastr.js"></script>

    <script>
        jQuery(document).ready(function() {
//            Noynoy.init();
//            Layout.init();
//            Demo.init();
            UIToastr.init();

        });
    </script>
</body>
</html>
