package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardGroup;

@Repository
public interface BoardGroupRepository extends JpaRepository<BoardGroup, Integer> {
	
}
