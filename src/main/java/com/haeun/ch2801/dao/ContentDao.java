package com.haeun.ch2801.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.haeun.ch2801.dto.ContentDto;

//데이터 접속객체 클래스
public class ContentDao implements IDao {
	
	JdbcTemplate template;

	@Autowired		//bean에서 생성한 template이 자동 주입(생성)
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ContentDao() {
		super();
	}

	@Override	//추상메소드 오버라이딩
	public ArrayList<ContentDto> listDao() {
		
		String sql = "SELECT * FROM simple_board ORDER BY mid DESC";
		
		//줄 단위로 하나씩 불러오기
		ArrayList<ContentDto> dtos = (ArrayList<ContentDto>) template.query(sql, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
		
		
		return dtos;
	}

	@Override	//추상메소드 오버라이딩
	public void writeDao(final String mwriter, final String mcontent) {
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "INSERT INTO simple_board(mid, mwriter, mcontent) VALUES(simple_board_seq.nextval, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, mwriter);
				pstmt.setString(2, mcontent);
				
				return pstmt;
			}
		});
		
	}

	@Override
	public void deleteDao(final String mid) {
		
		String sql = "DELETE FROM simple_board WHERE mid=?";
		
		this.template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(mid));
				
			}
			
		});
		
				
	}
	
	
	
}
