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
	private Integer no;
	public Integer getRecnt() {
		return recnt;
	}

	public void setRecnt(Integer recnt) {
		this.recnt = recnt;
	}

	public Integer getRelevel() {
		return relevel;
	}

	public void setRelevel(Integer relevel) {
		this.relevel = relevel;
	}

	public Integer getRootid() {
		return rootid;
	}

	public void setRootid(Integer rootid) {
		this.rootid = rootid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column
	private String title;
	@Column
	private Integer recnt;
	@Column
	private Integer relevel;
	@Column
	private Integer rootid;
	@Column
	private String text;
	
	@Column
	private Integer view;
		
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
