<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Spring MVC Image Upload with textEditor</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<!-- Bootstrap -->
<link href="/static/vendor/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<!--Summernote-->
<link rel="stylesheet" href="/static/vendor/font-awesome/css/font-awesome.min.css" />
<!-- include summernote css/js-->
<link href="/static/vendor/summernote/dist/summernote.css"	rel="stylesheet">

<style>
	div.container ol li { line-height: 30px; font-size: 15px; margin-bottom: 10px;}
	div.container h3 { margin-bottom: 20px;}
</style>


<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="/static/vendor/jquery/dist/jquery.min.js"></script>


</head>

<body>

	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">arahansa's Img upload Test</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/">Write</a></li>
					<li><a href="/blog">blogPage</a></li>
					<li><a href="/gallery">galleryPage</a></li>
					<li><a href="/guide">guide</a>
				</ul>
			</div>
			<!--/.nav-collapse -->


		</div>
		<!--container -->
	</nav>

    <sitemesh:write property="body"/>


<script src="/static/vendor/bootstrap/dist/js/bootstrap.min.js"></script>
</body>
</html>
</body>
</html>