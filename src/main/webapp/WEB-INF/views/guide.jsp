<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<h3>하고싶은 얘기들</h3>
	<ol>
		<li>주의 : 
			샘플코드를 핑계로-_-그냥 컨트롤러 하나에 꽉꽉 넣었습니다^.^  <br> 
			브라우저 버젼별 애로사항이 있을 수도 있습니다.. <br>
			생각의 흐름대로.. 함수로 안 빼고, 변수 잘 하나로 안 합치고 그때그때 필요한 것 바로 보일 수 있게 적었다.<br>
			문체가 종종 다르다. 
		</li>
		
		<li> 처음엔 썸머노트+이미지 조합만 해보려고 했는데.. 일이 점점 커지더라-_-; JPA매핑해서..파일자료실까지 대충 어쩌다 구현이 되었다..;; </li>
	
		<li>
			 시연  후, 검색 결과 안나오는 것 보여드리고,<br>(이미지 업로드는 있었지만..음.. 일반적 파일 업로도
			있었고.. 뭐.. 웹에디터에서의 특히 썸머노트에서의 .. 이미지 업로드 예제가 없었다. )<br>
			(영문 구글링도 마찬가지로 찾기 힘들었다. 내 구글링이 부족한지는 모르겠지만...)<br> 
			<a href="https://www.google.co.kr/search?num=30&newwindow=1&rlz=1C1ASRM_enKR614KR614&es_sm=93&q=%EC%8A%A4%ED%94%84%EB%A7%81+%EC%9D%B4%EB%AF%B8%EC%A7%80+%EC%97%85%EB%A1%9C%EB%93%9C&oq=%EC%8A%A4%ED%94%84%EB%A7%81+%EC%9D%B4%EB%AF%B8%EC%A7%80+%EC%97%85%EB%A1%9C%EB%93%9C&gs_l=serp.3..35i39l2j0j0i30j0i8i30l2.3101765.3104272.0.3104389.28.16.2.0.0.7.171.1619.0j12.12.0....0...1c.1j4.64.serp..21.7.730.kzfWePpQGPQ" target="_blank">
			링크</a>
			<br>아참..스프링부트에서도 이미지 업로드해야되는데.. 부트는 jar파일 내부에 모두 들어가있는 형태라 조금 더 분석이 필요하다.
			<br>(아마.. 빌드 설정에서 설정파일뿐만 아니라.. exclude packing 하는 설정 본 것같은데-_-흠흠..) 암튼 잘 안나오더라. 
		</li>
	
		<li>설정 (config, domain)</li>

		<li> 쓰기 -> (중간에 이미지 업로드, blog 페이지로 이동 과정) + 한글파일명 처리 + 썸네일</li>

		<li>
			개발에 입문한지는 오래되지 않았지만, 지금까지 공부한 것들을 약간의 친절함을 섞어서 매뉴얼로 만들었었다.. 지금까지 매뉴얼을 만들어 보며
			슬슬 영문으로도 바꿔서 올려볼 생각이다..이 프로그램도 그렇고.. 준비중인 다른 프로그램도..음..  영어가 어눌해도 <b>코드</b>로 얘기해보면 되니깐...  <br>
			처음 JPA를 인도인에게 유튜브로 배우면서.. 한국도 똑똑한 사람들이 많은데..왜 인도인만큼의 IT강국 대접을 못 받나 생각했다..(아.. 아닌가?^^;) <br>
			유튜브나 강좌사이트들을 보면 인도인이 만들어놓은 강좌도 꽤 많던데, 한국인들도 강좌를 많이 만들고 오픈소스를 많이 풀어놓으면 세계속에서의 IT
			한국 이미지가 더 좋아지고 개발자들의 해외진출도 더 쉬워지지 않을까?.. 허세같지만 뭐..-_-;;앞으로 조금씩..영어블로깅을..
		</li>
			
		

		<li>썸머노트 감사합니다. 여름엔 역시 썸머노트 ^0^; <a href="http://summernote.org/" target="_blank">썸머노트 사이트 링크!</a></li>
	</ol>
	
	<h3>자료들&링크들</h3>
	<ul>
		<li><iframe width="640" height="360" src="https://www.youtube-nocookie.com/embed/sI6Plh82Krc" frameborder="0" allowfullscreen></iframe></li>
		<li>소스주소 <a href="https://github.com/arahansa/spring_img_upload" target="_blank">https://github.com/arahansa/spring_img_upload</a></li>
		<li>이미지 썸네일 자바 선택 참고 블로그. 경험담이 좋다.^^ : http://paxcel.net/blog/java-thumbnail-generator-imagescalar-vs-imagemagic/</li>
		<li>아 그냥 여기로 가자.. ;; http://gubok.tistory.com/423</li>
	</ul>
	<hr>
	<h3>만든이 : 아라한사</h3>
	<ul>
		<li>코멘트 : 튜토리얼과 코드로 얘기하고 싶습니다. (https://www.facebook.com/me.adunhansa)</li>
		<li>코멘트2 : 이런 형식의 소스파일+가이드가 붙은 JPA 튜토리얼 만드는 중입니다. 기대해주세요는 아니고..제가 이상하게, 할일이 많아져서 좀 늦을 수도 있습니다-_-a</li>
		<li>아참, JPA가 궁금하시다면 이번에 나올 JPA책을 사보시는 것도^^? <a href="http://bit.ly/holyeye_jpabook" target="_blank">JPA 신간서적링크!</a> </li>
		<li><img src="/static/images/me.jpg" width="200px" height="200px"><br></li>
		<li><span style="color:white">
		스프링의 requestMapping에서는 6가지 정도의 속성설정을 할 수가 있다.  value, method, params, headers, consumes, produces 가 있는데 이중에서..<br>
		 produces는 서버에서 클라이언트로 보낼 속성을 지정할 수가 있었다 (토비 이일민님 감사합니다.)<br>
		01. 한글 파일설정:  produces="text/plain;charset=UTF-8"</span></li>
		
		
	</ul>
	<br><br><br><br><br><br><br><br><br>
	
</div>
<!--container -->