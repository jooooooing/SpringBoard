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
public class BoardRe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long seq; //pk
	
	@Column
	private String title;
	
	@Column
	private String writer;
	
	@Column Date createdDate = new Date();
	
	@Column Long cnt;
	
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JsonManagedReference //참조 통과 어노테이션
	@JoinColumn(name="board_seq")
	private Board board;

	public BoardRe(String title, String writer, Date createdDate, Long cnt, Board board) {
		this.title = title;
		this.writer = writer;
		this.createdDate = createdDate;
		this.cnt = 0L;
		this.board = board;
	}
	
	public BoardRe(String writer2, Date date, String title2, Board board2) {
		
	}

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getCnt() {
		return cnt;
	}

	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	
	
	

}
