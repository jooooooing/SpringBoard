package kr.ac.kopo.ctc.spring.board.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BoardGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id autoincrement
	@Column
	private Integer id;
	
	@Column
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="boardGroup")
	private List<BoardItem> boardItems;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BoardItem> getBoardItems() {
		if (boardItems == null) {
			boardItems = new ArrayList<BoardItem>();
		}
		return boardItems;
	}

	public void setBoardItems(List<BoardItem> boardItems) {
		this.boardItems = boardItems;
	}
	
	public void addBoardItem(BoardItem b) {
		List<BoardItem> boardItems = getBoardItems();
		boardItems.add(b);
	}
	
	@Override
	public String toString() {
		String result = "["+id+"]" + name;
		for (BoardItem b : getBoardItems()) {
			result += "\n" + b.toString();
		}
		return result;
	}
	
	

}
