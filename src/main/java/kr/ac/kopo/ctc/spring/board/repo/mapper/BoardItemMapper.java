package kr.ac.kopo.ctc.spring.board.repo.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;

@Mapper
@Repository
public interface BoardItemMapper {
	
	List<BoardItem> findOneByCondition(BoardItemCondition condition);
	List<BoardItem> findAll();
	List<BoardItem> findAllByCondition(BoardItemCondition condition, RowBounds rowBounds);
	List<BoardItem> selectAllPage(BoardItemCondition condition, RowBounds rowBounds);
	
	Optional<BoardItem> insertOne();
	Optional<BoardItem> deleteOne();
	Optional<BoardItem> updateOne();
}
