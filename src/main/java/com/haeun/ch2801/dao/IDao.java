package com.haeun.ch2801.dao;

import java.util.ArrayList;

import com.haeun.ch2801.dto.ContentDto;

public interface IDao {
	
	//추상메소드 선언
	public ArrayList<ContentDto> listDao();	//리스트 불러오기
	public void writeDao(String mwiter, String mcontent);	//글쓰기
	
}
