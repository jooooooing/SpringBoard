package kr.ac.kopo.ctc.spring.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

@Entity
@DynamicInsert
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincrement
	@Column (name="seq")
	private Long seq; //pk
	@Column
	private String title; //제목
	@Column //(updatable = false) //update시점에 막음
	private String writer; //작성자
	@Column
	private String content; //내용
	@Column
	private Date createDate = new Date(); //생성일자
	
	@Column
	private Long cnt; //조회수
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

}
