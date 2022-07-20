package kr.ac.kopo.ctc.spring.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.ac.kopo.ctc.spring.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
