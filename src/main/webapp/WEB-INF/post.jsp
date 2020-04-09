    <%@page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <HTML>
        <HEAD><TITLE>MyHomePage</TITLE>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="<c:url value="/main-css.css"/>">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="ckeditor/ckeditor.js"></script>
        <script src="/js/modal.js"></script>
        <script src="/js/post.js"></script>
        </HEAD>
        <BODY>
        <div class="container">
        <div class="top">
        <div class="logo"><h1 style="display:inline-block;">Song Magician</h1></div>
        <div class="image-box">
        <div class="image-object">
        <button class="btn" onclick="login()">
        <svg class="bi bi-server" width="50px" height="50px" viewBox="0 0 16 16" fill="currentColor"
        xmlns="http://www.w3.org/2000/svg">
        <path d="M13 2c0-1.105-2.239-2-5-2S3 .895 3 2s2.239 2 5 2 5-.895 5-2z"/>
        <path d="M13 3.75c-.322.24-.698.435-1.093.593C10.857 4.763 9.475 5 8 5s-2.857-.237-3.907-.657A4.881 4.881 0 013
        3.75V6c0 1.105 2.239 2 5 2s5-.895 5-2V3.75z"/>
        <path d="M13 7.75c-.322.24-.698.435-1.093.593C10.857 8.763 9.475 9 8 9s-2.857-.237-3.907-.657A4.881 4.881 0 013
        7.75V10c0 1.105 2.239 2 5 2s5-.895 5-2V7.75z"/>
        <path d="M13 11.75c-.322.24-.698.435-1.093.593-1.05.42-2.432.657-3.907.657s-2.857-.237-3.907-.657A4.883 4.883 0
        013 11.75V14c0 1.105 2.239 2 5 2s5-.895 5-2v-2.25z"/>
        </svg>
        </button>
        </div>
        <div class="image-object" >
        <a data-toggle="tooltip " title="facebook">
        <img width="50px" alt="Facebook icon"
        src="https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Facebook_icon.svg/256px-Facebook_icon.svg.png">
        </a>
        </div>
        <div class="image-object">
        <a data-toggle="tooltip " title="92.songj">
        <img width="50px" alt="Instagram simple icon"
        src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Instagram_simple_icon.svg/512px-Instagram_simple_icon.svg.png">
        </a>
        </div>
        </div>
        </div>
        <div class="left-nav">
        <ul class="list-group">
        <c:forEach var="item" items="${menuBean.menus}">
            <c:choose>
                <c:when test="${item.active eq true}">
                    <a href="<c:url value="${item.url}"/>"><li class="list-group-item active">${item.name}</li></a>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="${item.url}"/>"><li class="list-group-item">${item.name}</li></a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        </ul>
        </div>
        <div class="main-container">
        <a href="<c:url value="${link.left}"/>">
                        <svg class="bi bi-arrow-bar-left arrow-left" width="50px" height="50px" viewBox="0 0 16 16" fill="currentColor"
                        xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M5.854 4.646a.5.5 0 00-.708 0l-3 3a.5.5 0 000 .708l3 3a.5.5 0 00.708-.708L3.207
                        8l2.647-2.646a.5.5 0 000-.708z" clip-rule="evenodd"/>
                        <path fill-rule="evenodd" d="M10 8a.5.5 0 00-.5-.5H3a.5.5 0 000 1h6.5A.5.5 0 0010 8zm2.5 6a.5.5 0
                        01-.5-.5v-11a.5.5 0 011 0v11a.5.5 0 01-.5.5z" clip-rule="evenodd"/>
                        </svg>
            </a>
        <div class="contents">
        <c:if test="${user.mode eq 'owner'}">
            <div style="display:inline-block; right:0; z-index:10; position:absolute;" onclick="replacePostModal()" class="btn btn-default">Posting</div>
        </c:if>
        <div class="dropdown">
            <button class="btn btn-defulat dropdown-toggle" type="button" id="dropItem" name="postSelect" data-toggle="dropdown">${subjectList.selectedSubject.name}<span class="caret"></span></button>
        <ul class="dropdown-menu">
            <c:forEach var="item" items="${subjectList.subjectList}">
                <c:if test="${item ne subjectList.selectedSubject}">
                    <li role="presentation"><div role="menuitem" tabindex="-1" onclick=getPostList(this,'${item.id}')>${item.name}</div></li>
                </c:if>
            </c:forEach>
        </ul>
            <div style="display:none;" id="selected_post">${subjectList.selectedSubject.id}</div>
            <div style="display:none;" id="selected_post_name">${subjectList.selectedSubject.name}</div>
        </div>
            <table class="table table-hover" style="width:100%;">
        <thead>
        <tr>
        <th style="display:none;"></th>
        <th style="display:none;"> 내용 미리보기</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성날자</th>
        </tr>
        </thead>
        <tbody id="post_table">
            <c:forEach var="postItem" items="${postList.posts}">
                <tr onclick="getPostContent(this)">
                <td style="display:none;">${postItem.number}</td>
                <td style="display:none;" class="post_content">${postItem.content}</td>
                <td class="post_name" style="width:60%;">${postItem.name}</td>
                    <td>${postItem.owner.name}</td>
                    <td>${postItem.date}</td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
        <div style="text-align:center;">
            <c:if test="${(postList.pageSize) > 1}">
            <ul class="pagination">
            <c:choose>
                <c:when test="${(postList.currentPage-4 <= 1) && (postList.currentPage+4 >= postList.pageSize)}">
                    <c:forEach var="i" begin="1" end="${postList.pageSize}">
                        <li class="page-item"><button class="page-link" onclick=getPage(${i})>${i}</button></li>
                    </c:forEach>
                </c:when>
                <c:when test="(${(postList.currentPage-4 >= 1) && (postList.currentPage+4 < postList.pageSize)}">
                    <li class="page-item"> <a class="page-link" href="/post/page/${postList.currentPage-4}" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span> </a> </li>
                    <c:forEach var="i" begin="${postList.currentPage-3}" end="${postList.currentPage+3}">
                        <li class="page-item"><button class="page-link" onclick=getPage(${i})>${i}</button></li>
                    </c:forEach>
                    <li class="page-item"> <a class="page-link" href="/post/page/${postList.currentPage+4}" aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span></a></li>
                </c:when>
            </c:choose>
        </ul>
        </c:if>
        </div>
        </div>
        <a href="<c:url value="${link.right}"/>">
        <svg class="bi bi-arrow-bar-right arrow-right" width="50px" height="50px" viewBox="0 0 16 16"
        fill="currentColor" xmlns="http://www.w3.org/2000/svg">
        <path fill-rule="evenodd" d="M10.146 4.646a.5.5 0 01.708 0l3 3a.5.5 0 010 .708l-3 3a.5.5 0 01-.708-.708L12.793
        8l-2.647-2.646a.5.5 0 010-.708z" clip-rule="evenodd"/>
        <path fill-rule="evenodd" d="M6 8a.5.5 0 01.5-.5H13a.5.5 0 010 1H6.5A.5.5 0 016 8zm-2.5 6a.5.5 0
        01-.5-.5v-11a.5.5 0 011 0v11a.5.5 0 01-.5.5z" clip-rule="evenodd"/>
        </svg>
        </a>
        </div>
        </div>
        <!-- Modal -->
        <div class="modal fade" id="exampleModalLong" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
        <div class="modal-dialog" role="document">
        <div class="modal-content">
        <div class="modal-header">
        <h5 class="modal-title" id="contents-title"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
        <span aria-hidden="true">&times;</span>
        </button>
        </div>
        <div class="modal-body" id="contents-data">
        </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        </div>
        </div>
        </div>
        </BODY>
        <script>
        $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
        });
        </script>
        </HTML>