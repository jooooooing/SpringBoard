package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

public class BoardItemCondition implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer no;
	private String title;
	private String author;
	
	private Date created;
	private Integer view;
	
	
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getView() {
		return view;
	}
	public void setView(Integer view) {
		this.view = view;
	}

}
