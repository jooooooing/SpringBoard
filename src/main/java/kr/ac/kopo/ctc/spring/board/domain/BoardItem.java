package kr.ac.kopo.ctc.spring.board.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class BoardItem {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincrement
	@Column
	private Integer id;
	@Column
	private String author;
	@Column
	private Date created;
	
	@Column
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@Column(columnDefinition = "integer default 0", nullable = false)
	private Integer view;

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public String getcontent() {
		return content;
	}

	public void setcontent(String content) {
		this.content = content;
	}

	public BoardGroup getBoardGroup() {
		return boardGroup;
	}

	public void setBoardGroup(BoardGroup boardGroup) {
		this.boardGroup = boardGroup;
	}
	
	@JsonBackReference //순환참조방지
	@ManyToOne(optional=false)
	@JoinColumn(name="boardGroup_id")
	private BoardGroup boardGroup;
	
	@Override
	public String toString() {
		String result = "[BoardItem_" +id+"] ";
		return result;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Integer getView() {
		return view;
	}
	public void setView(Integer view) {
		this.view = view;
	}

}
