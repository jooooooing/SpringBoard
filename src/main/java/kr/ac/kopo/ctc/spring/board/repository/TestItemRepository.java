package kr.ac.kopo.ctc.spring.board.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.TestItem;

@Repository
public interface TestItemRepository extends JpaRepository<TestItem, Long>, JpaSpecificationExecutor<TestItem> {
	Optional<TestItem> findOneById (Long id);
	
	List<TestItem> findAllById(Long id);
}
