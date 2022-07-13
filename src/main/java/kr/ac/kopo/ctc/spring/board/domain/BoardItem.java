package kr.ac.kopo.ctc.spring.board.domain;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BoardItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincrement
	@Column
	private Integer id;
	@Column
	private Integer no;
	@Column
	private String title;
	@Column
	private String author;
	@Column
	private Date created;
	@Column
	private Integer view;
		
	public BoardGroup getBoardGroup() {
		return boardGroup;
	}

	public void setBoardGroup(BoardGroup boardGroup) {
		this.boardGroup = boardGroup;
	}
	@ManyToOne(optional=false)
	@JoinColumn(name="BoardGroup_id")
	private BoardGroup boardGroup;
	
	@Override
	public String toString() {
		String result = "[BoardItem_" +id+"] " + no;
		return result;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
