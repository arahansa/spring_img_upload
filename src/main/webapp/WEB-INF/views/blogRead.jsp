<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="page-header">
		<h1>Blog page</h1>
		<p class="lead">This page will show your article.</p>
	</div>

	${article.id}번 글 , 글쓴이 : ${article.nick }<br>
	<c:forEach items="${article.uploadfiles }" var="files">
			파일명 : <a href="/static/uploadfiles/${files }">${files}</a>
		<br>
	</c:forEach>
	내용 : <br> ${article.content }
	<hr>
	<a href="javascript:history.go(-1)">뒤로가기</a>
</div>
<!--container -->