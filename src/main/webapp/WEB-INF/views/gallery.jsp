<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="page-header">
        <h1>Gallery page</h1>
        <p class="lead">This page will show your article with thumbnails.</p>
    </div>
	
	<c:if test="${empty articles}">
		<hr>
		아무런 글이 없습니다. 
	</c:if>
	
	<c:forEach items="${articles}" var="article">
		${article.id}번 글 , 글쓴이 : ${article.nick }<br>
		<c:forEach items="${article.uploadfiles }" var="files">
			파일명 : <a href="/static/uploadfiles/${files }">${files}</a><br>
		</c:forEach>
		썸네일 (썸네일을 누르면 해당 글로 이동한다!) : <br>
		<a href="/blog/${article.id }"><img src="${article.imgthumbnail }" width="150px" height="150px"></a>
		<hr>
	</c:forEach>
</div><!--container -->