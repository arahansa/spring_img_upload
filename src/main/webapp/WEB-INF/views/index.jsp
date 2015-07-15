<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!--container -->
<div class="container">
	<div class="page-header">
		<h1>Wrinting Page</h1>
		<p class="lead">This page is intended for Writing a article, Uploading
			images with WYSIWYG Editor such as Summernote.</p>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form:form class="form-horizontal" action="/blog" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
				<div class="form-group">
					<label for="nick" class="col-sm-2 control-label">Nick </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nick" name="nick"
							placeholder="Nickname">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-1"></div>
					<div class="col-sm-11">
						<textarea id="summernote" class="form-control summernote" name="content"
							rows="10"></textarea>
					</div>
				</div>

				<div  class="form-group">
					<label for="exampleInputFile" class="col-sm-2 control-label">File
						input</label>
					<div class="col-sm-10" id="fileTable">
						<input type="file"  name="files[0]" class="fileDiv">
						<input type="file"  name="files[1]" class="fileDiv">
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-2"></div>
					<div class="col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
						<button id="addFile"  type="button" class="btn btn-default">파일 폼 추가</button>
					</div>
				</div>

			</form:form>
		</div>
	</div>
</div>
<!--container -->




<!-- Include all compiled plugins (below), or include individual files as needed -->

<script src="/static/vendor/summernote/dist/summernote.min.js"></script>
<script>
	$(document).ready(function() {
		
		$('#summernote').summernote({
			height : 300,
			onImageUpload : function(files, editor, welEditable) {
				console.log(files);
				console.log( files[0] );
				// 얼핏 나는 기억이 IE10이하 낮은버젼에서 FormData()지원되는거 맞았나? 
				// 근데 뭐...썸머노트가 IE8까지는 아직 지원이 안되는 걸로 아는데(망할IEㅠㅠ) 뭐..이정도야..뭐^^?
				// IE8 버려도 괜찮아요. 다같이 쓰지말아요^^; (지원안해주셔도 감사합니다^^) (어차피 전, IE8은 버리고 갑니다^^..아직은...)
				data = new FormData();
				data.append("file", files[0]);
				// http://mycodde.blogspot.kr/2014/09/summernote-wyswig-editor-php-tutorial.html
				//http://stackoverflow.com/questions/30766734/image-isnt-getting-in-editor-php-image-upload
				// editor 에서 정의되지 않은 어쩌고 에러가 떠서, 윗주소에서 찾아서 해결
				var $note = $(this);
				$.ajax({
					data : data,
					type : "POST",
					url : '/blog/imageupload',
					cache : false,
					contentType : false,
					processData : false,
					success : function(url) {
						alert(url);
						$note.summernote('insertImage', url);
					}
				});
			}
		});
		
		$('#addFile').click(function(){
			var fileIndex = $('.fileDiv').length;
			$('#fileTable').append("<input type=\"file\" name=\"files["+fileIndex+"] class=\"fileDiv\">");
		});

	});
</script>


