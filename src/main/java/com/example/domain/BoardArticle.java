package com.example.domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class BoardArticle {
    @Id
    @GeneratedValue
    private Long id;
    
    private String nick;
    
    // 원래 글 내용은 레이지 로딩을 해야한다. 여기서는 샘플코딩이므로 생략함^^;
    // 제가 만들어놓은 스프링-블로그 개발기(슬라이드 쉐어)에 손권남님의 위키와 박재성님의 slipp소스를 참고해서, 글 내용-레이지로딩을 했던 얘기를 적었습니다.
    private String content;
    
    // 파일 업로드를 한 개만 하는 것이 아니라 여러개를 할 수도 있다. 그러므로 리스트 형태를 만들어주자.
    // 파일 중복명을 고려를 해봐야 한다. 하지만 서로 다른 경로에서 같은 파일명을 업로드할 수도 있으므로 Set보다는 List를 사용해보았다.
    // 중복 걸러서 저장하는 것은 추후 생각해보자...
    @ElementCollection(fetch = FetchType.EAGER)
	private List<String> uploadfiles;
   
    // 썸네일이 들어갈 파일명이다.
    @Column(name="imgthumbnail")
    private String imgthumbnail;

    
    
    public BoardArticle() {       }
    public BoardArticle(String nick, String content) {
        this.nick = nick;
        this.content = content;
    }

    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }
    public String getNick() {        return nick;    }
    public void setNick(String nick) {        this.nick = nick;    }
    public String getContent() {        return content;    }
    public void setContent(String content) {        this.content = content;    }
    public List<String> getUploadfiles(){return uploadfiles;}
	public void setUploadfiles(List<String> uploadfiles){this.uploadfiles = uploadfiles;}
	
	
	public String getImgthumbnail(){
		//당장은 이렇게 하지만.. 나중에 변경이 된다면?썸네일을 년도별로 저장하다면? 후움..^0^; 
		if(imgthumbnail!=null){
			if(imgthumbnail.startsWith("http")){
				return imgthumbnail;
			}else{
				return "/static/images/thumbnails/"+imgthumbnail;
			}
		}
		return "/static/images/me.jpg";
	}
	public void setImgthumbnail(String imgthumbnail){this.imgthumbnail = imgthumbnail;}
	
	@Override
	public String toString()
	{
		return "BoardArticle [id=" + id + ", nick=" + nick + ", content=" + content + ", uploadfiles=" + uploadfiles
				+ ", imgthumbnail=" + imgthumbnail + "]";
	}
	
	
	
	

	
}
