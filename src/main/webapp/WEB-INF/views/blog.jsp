<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
    <div class="page-header">
        <h1>Blog page</h1>
        <p class="lead">This page will show your article.</p>
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
		내용 : <br>
		${article.content }
		<hr>
	</c:forEach>
</div><!--container -->