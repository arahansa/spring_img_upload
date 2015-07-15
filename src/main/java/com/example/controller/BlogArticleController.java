package com.example.controller;

import static org.imgscalr.Scalr.OP_ANTIALIAS;
import static org.imgscalr.Scalr.OP_BRIGHTER;
import static org.imgscalr.Scalr.pad;
import static org.imgscalr.Scalr.resize;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;

import org.imgscalr.Scalr.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.domain.BoardArticle;
import com.example.domain.FileList;
import com.example.repository.ArticleRepository;

@Controller
@RequestMapping("/blog")
public class BlogArticleController {

	private static final String FILE2 = "file";
	private static final String ARTICLE = "article";
	private static final String STATIC_IMAGES_THUMBNAILS = "/static/images/thumbnails/";
	private static final String UPLOADIMG = "/static/uploadimg/";
	private static final String UPLOADFILES = "/static/uploadfiles/";
	private static final Logger LOGGER = LoggerFactory.getLogger(BlogArticleController.class);

	@Autowired
	ArticleRepository repository;
	@Autowired
	ServletContext servletContext;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model)
	{
		Sort sort = new Sort(Sort.Direction.DESC, "id");
		model.addAttribute("articles", repository.findAll(sort));
		System.out.println("webapproot:"+servletContext.getRealPath("/"));
		return "blog";
	}
	@RequestMapping("/{articleid}")
	public String getId(@PathVariable Long articleid, Model model)
	{
		model.addAttribute(ARTICLE, repository.findOne(articleid));
		return "blogRead";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(BoardArticle article, FileList fileList) throws IOException
	{
		/** 01. 파일 저장 처리들... */
		LOGGER.debug("files :{}" + fileList);
		List<MultipartFile> files = fileList.getFiles();
		List<String> uploadfiles = new ArrayList<>();
		int sizeFile = files.size();
		System.out.println("파일 사이즈 :" + sizeFile);

		LOGGER.debug("file Upload Processing...");
		for (int i = 0; i < sizeFile; i++) {
			MultipartFile multipartFile = files.get(i);
			
			// 나중에 파일 리스트 업로드 처리를 가정해보자. 파일 리스트가, 1-5번까지 있다고 할 때
			// 중간에 2, 4 번째 혹은 1,4번에서 파일을 선택안한경우는
			// 리스트에서 이름이 비게 된다. 이럴 경우를 대비해서 이름을 검사하고 업로드처리시킨다.
			// 바꿈 : isEmpty 로 바꾸다.아아아;; 
			// TODO 파일명이 중복되서 업로드 하는 경우를 고려해야함.
			if (!multipartFile.isEmpty()) {
				LOGGER.debug("업로드 파일 이름 : {}", multipartFile.getOriginalFilename());
				String webappRoot = servletContext.getRealPath("/");
				String filename = webappRoot + UPLOADFILES + multipartFile.getOriginalFilename();
				File file = new File(filename);
				multipartFile.transferTo(file);
				uploadfiles.add(multipartFile.getOriginalFilename());
			}
		}
		article.setUploadfiles(uploadfiles);

		/**
		 * 02. 글에서 추출해서 <img> 태그가 걸려있으면 썸네일을 만들어보자 스프링 공홈에도 썸네일 만들기 예제가 있으나,
		 * 네티기반이고 잠깐 본 결과 콘솔쪽으로 만든 것같았는데, 자바 썸네일 이미지 만들기가 그리 복잡한 것이 아닌것 같아, 간단히
		 * 적용해보도록 하겠다.
		 * */

		String source = article.getContent();
		Document doc = Jsoup.parse(source);
		Elements elements = doc.select("img");
		String url = checkElements(elements);
		String localIP = InetAddress.getLocalHost().getHostAddress();
		if (url != null) {
			if (url.startsWith("http://"+localIP)) {
				LOGGER.debug("썸네일 생성 작업 처리 시작.. ");
				String webAppRoot = servletContext.getRealPath("/");
				url = url.substring(url.lastIndexOf("/") + 1);
				String ext = url.substring(url.lastIndexOf(".") + 1);
			
				File file = new File(webAppRoot + UPLOADIMG + url);
				BufferedImage img = ImageIO.read(file);
				BufferedImage thumbnail = createThumbnail(img);

				File thumbnailoutput = new File(webAppRoot + STATIC_IMAGES_THUMBNAILS + url);
				ImageIO.write(thumbnail, ext, thumbnailoutput);
			}
			article.setImgthumbnail(url);
		}
		LOGGER.debug("article : {}", article);
		repository.save(article);
		return "redirect:/blog";
	}

	public String checkElements(Elements elements)
	{
		if (elements.size() > 0) {
			Elements elem = elements.get(0).getElementsByAttribute("src");
			String url = elem.toString();
			int pos = url.indexOf("src=\"") + 5;
			url = url.substring(pos, url.indexOf("\"", pos));
			LOGGER.debug("img url :{}",url);
			// System.out.println(url.startsWith("http")+":"+url);
			return url;
		}
		return null;
	}

	public static BufferedImage createThumbnail(BufferedImage img)
	{
		// Create quickly, then smooth and brighten it.
		img = resize(img, Method.SPEED, 150, OP_ANTIALIAS, OP_BRIGHTER);
		// Let's add a little border before we return result.
		return pad(img, 4);
	}

	/** 에디터에서 받는 이미지 업로드 처리 부분^^ */
	// TODO : 01. Check file extension. 혹시라도 모르니 확장자검사를 해서 에러처리를 해야 한다.
	// TODO : 02. Naming duplicated file name 중복파일명에 대해서 이름처리를 하게 해야 한다
	// TODO : 03. 한글파일명 업로드!? 시연해보면서 고칠 것!!
	// 아, 우선 한글 처리 시.. (new String(파일명.getBytes(),"UTF-8") 이거 안해줘도 되는 것같다..)
	@RequestMapping(value = "/imageupload", method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String imageUpload(MultipartHttpServletRequest request) throws IOException
	{
	
		
		// 01. 리퀘스트에서 멀티파트파일을 받아서
		MultiValueMap<String, MultipartFile> multiFileMap = request.getMultiFileMap();
		List<MultipartFile> list = multiFileMap.get(FILE2);
		MultipartFile multipartFile = list.get(0);
		LOGGER.debug(multipartFile.getOriginalFilename());

		// 02. 파일을 전송하고
		String webappRoot = servletContext.getRealPath("/");
		String filename = UPLOADIMG + multipartFile.getOriginalFilename();
		File file = new File(webappRoot + filename);
		multipartFile.transferTo(file);

		// 03. 마지막에 최종 주소를 반환한다.
		// requet.getServername 을 하니, ajax에서 보내는 값이 리퀘스트 정보에 안떠서 InetAddress로
		// 받았다.
		String localIP = InetAddress.getLocalHost().getHostAddress();
		// http://를 붙여줘야 에디터 창에서 불러올 수가 있다. 음.. 자바스크립트내에서 붙일까? 일단 그냥 적자.
		return "http://" + localIP+ ":" + request.getServerPort() + filename;
	}

	// --------------------------------------------------------------

	@PostConstruct
	public void setup()
	{
		repository.deleteAll();
		BoardArticle article = new BoardArticle();
		article.setContent("나의 시작은 엉망인 코드와 함께하는 풋내기 개발자일지 모르나, 내일에는 우아한 코드가 함께하는, 좋은 습관을 가진 개발자가 되겠지..?^^"
				+ "<br><br><img src=\"/static/images/mydream.png\">");
		article.setNick("arahansa");
		repository.save(article);
	}

}
