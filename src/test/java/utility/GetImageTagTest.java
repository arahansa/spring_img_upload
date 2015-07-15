package utility;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class GetImageTagTest {

	@Test
	public void getImageTest()
	{
		String source = "<br>나의 시작은 엉망인 코드와 함께하는 풋내기 개발자일지 모르나, "
				+ "내일에는 우아한 코드가 함께하는, <img src=\"https://www.google.co.kr/logos/doodles/2015/new-horizons-pluto-flyby-5641113681526784.2-hp.gif\">"
				+ "좋은 습관을 가진 개발자가 되겠지..?^^<br><img src=\"/static/images/mydream.png\"><br> <img src=\"/static/images/mydream2.png\">";
		Document doc = Jsoup.parse(source);
		Elements elements = doc.select("img");
		//흠..생각해보니...내 블로그 같은 경우는 외부에서 이미지 링크를 많이 따올 때도 있었다. 구글이미지 서비스 같은 것 말이지.. ;; 그래서 이미지를 따로 받아야겠군?
		checkElementsRaw(elements);
		System.out.println("=====");
		checkElements(elements);
		//이미지 없을때는 어떻게 될가?
		doc = Jsoup.parse("hello world");
		elements = doc.select("img");
		checkElements(elements);
	}

	public void checkElementsRaw(Elements elements){
		if(elements.size() > 0){
			for (Element element : elements) {
				//Elements elem = element.getElementsByAttributeValueStarting("src", "/static");
				Elements elem = element.getElementsByAttribute("src");
				System.out.println(elem);
			}	
		}else{
			System.out.println("이미지없다");
		}
	}
	
	public String checkElements(Elements elements){
		if(elements.size() > 0){
			String url=null;
			for (Element element : elements) {
				//Elements elem = element.getElementsByAttributeValueStarting("src", "/static");
				Elements elem = element.getElementsByAttribute("src");
				url = elem.toString();
				url = url.substring(url.indexOf("src=\"")+5, url.length()-2);
				System.out.println(url.startsWith("http")+":"+url);
				
			}
			if(!url.startsWith("http")){
				System.out.println(url.substring(url.lastIndexOf("/")+1));
				System.out.println(url.substring(url.lastIndexOf(".")+1));
				assertEquals("mydream2.png", url.substring(url.lastIndexOf("/")+1));
			}
			
			return url;
		}
		return null;
	}
}
