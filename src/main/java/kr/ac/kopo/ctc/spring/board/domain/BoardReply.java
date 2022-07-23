package kr.ac.kopo.ctc.spring.board.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class BoardReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer replyId; //pk
	
	@Column
	private String content;
	
	@Column
	private String author;
	
	@Column Date createdDate = new Date();
	
	@Column Integer viewCnt;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonManagedReference //참조 통과 어노테이션
	@JoinColumn(name="board_seq")
	private Board board;

	
	
	
	public BoardReply(String content, String author, Date createdDate, Integer viewCnt, Board board) {
		super();
		this.content = content;
		this.author = author;
		this.createdDate = createdDate;
		this.viewCnt = 0; //최초 생성시 조회수 0으로  세팅 
		this.board = board;
	}

	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	
	
	
	

}
