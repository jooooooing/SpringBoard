package kr.ac.kopo.ctc.spring.board.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import org.springframework.lang.NonNull;

@Entity
public class BoardReply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer replyId;
	
	@NonNull
	@Column(nullable=false, length = 120)
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	private BoardItem boardItem;
	
	@Column
	private String time;
	
	@PrePersist
	public void createdAt() {
		this.time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
	}
	
	@Column(nullable = false, length = 120)
	private String author;
	
	public BoardReply() {}
}
