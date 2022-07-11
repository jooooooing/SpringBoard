package kr.ac.kopo.ctc.spring.board.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Integer>, JpaSpecificationExecutor<BoardItem>, PagingAndSortingRepository<BoardItem, Integer> {
	Optional<BoardItem> findOneByAuthor(String author);
	
//	Page<BoardItem> findAllByType(String author, Pageable pageable);
	
	List<BoardItem> findAllByTitleContaining(String title, PageRequest pageRequest);
	List<BoardItem> findAllByTitleContaining(String title);
}
