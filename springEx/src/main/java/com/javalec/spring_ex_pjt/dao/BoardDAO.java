package com.javalec.spring_ex_pjt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.javalec.spring_ex_pjt.dto.BoardDTO;
import com.javalec.spring_ex_pjt.util.Constant;

public class BoardDAO {
	DataSource dataSource = null;
	JdbcTemplate template=null;
	public BoardDAO() {
		template = Constant.template;
	}
	public ArrayList<BoardDTO> list() {
		
		String query = "select * from mvc_board order by bGroup desc,bStep asc";
		return (ArrayList<BoardDTO>) template.query(query, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));

	}
	
	public void write(final String name,final String title, final String content) {
		
		template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, mvc_board_seq.currval, 0, 0)";
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(1, name);
				pstm.setString(2, title);
				pstm.setString(3, content);
				
				return pstm;
			}
		});
	}
	
	public BoardDTO content_view(int id) {
		
		upHit(id);
		String query = "select * from mvc_board where bId=" + id;
		return template.queryForObject(query, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
	}
	
	public void modify(int id, String name, String title, String content) {
		
		String query = "update mvc_board set bName='"+name+"', bTitle='"+title+"', bContent='"+content+"' where bId="+id;
		template.update(query);
		
	}
	
	public void reply(final int id,final String name,final String title,final String content,final int hit, final int group, final int step, final int indent) {
		upStep(id,step,group);
		
		template.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (mvc_board_seq.nextval, ?, ?, ?, 0, ?, ?, ?)";
				PreparedStatement pstm = con.prepareStatement(query);
				pstm.setString(1, name);
				pstm.setString(2, title);
				pstm.setString(3, content);
				pstm.setInt(4, group);
				pstm.setInt(5, step+1);
				pstm.setInt(6, indent+1);
				
				return pstm;
			}
		});
	}
	
	public void delete(int id) {
		
		String query = "delete from mvc_board where bId="+id;
		template.update(query);
	}
	
	public void upHit(int id) {
		String query = "update mvc_board set bHit = bHit+1 where bId = "+id;
		template.update(query);
	}
	
	public void upStep(int id,int step,int group) {
		String query = "update mvc_board set bStep=bStep+1 where bGroup="+group+"and bStep>"+step;
		template.update(query);
	}
}
