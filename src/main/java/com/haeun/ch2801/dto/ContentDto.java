package com.haeun.ch2801.dto;

//데이터 이동 객체 클래스
public class ContentDto {
	
	private int mid;			//게시글 번호
	private String mwriter;		//글쓴이
	private String mcontent;	//한줄글 내용
	
	public ContentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContentDto(int mid, String mwriter, String mcontent) {
		super();
		this.mid = mid;
		this.mwriter = mwriter;
		this.mcontent = mcontent;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMwriter() {
		return mwriter;
	}

	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}
}
