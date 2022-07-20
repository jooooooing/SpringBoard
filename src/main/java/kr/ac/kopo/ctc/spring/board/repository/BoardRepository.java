package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.data.repository.CrudRepository;

import kr.ac.kopo.ctc.spring.board.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{

}
