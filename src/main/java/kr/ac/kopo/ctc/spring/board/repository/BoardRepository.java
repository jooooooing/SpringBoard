package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import kr.ac.kopo.ctc.spring.board.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

	List<Board> findAll(Sort by); //역순 출력을 위한 메소드

}
