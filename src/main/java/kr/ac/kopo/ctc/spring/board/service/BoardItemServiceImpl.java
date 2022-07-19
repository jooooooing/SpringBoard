package kr.ac.kopo.ctc.spring.board.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.spring.board.domain.BoardItem;
import kr.ac.kopo.ctc.spring.board.repository.BoardItemRepository;

@Service
public class BoardItemServiceImpl implements BoardItemService {

	@Autowired
	BoardItemRepository boardItemRepository;

//	@Override
//	public void test() {
//		System.out.println("BoardItemServiceimpl.test() 메소드 호출");
//	}
//
//	@Override
//	public void testAopBefore() {
//		System.out.println("BoardItemServiceimpl.testAopBefore() 메소드 호출");
//
//	}
//
//	@Override
//	public void testAopAfter() {
//		System.out.println("BoardItemServiceimpl.testAopAfter() 메소드 호출");
//
//	}
//
//	@Override
//	public String testAopAfterReturning() {
//		System.out.println("BoardItemServiceimpl.testAopAfterReturning() 메소드 호출");
//		return "Success";
//	}
//
//	@Override
//	public void testAopAfterThrowing() {
//		System.out.println("BoardItemServiceimpl.testAopAfterThrowing() 메소드 호출");
//		throw new RuntimeException("runtime exception 발생");
//
//	}
//
//	@Override
//	public void testAopAround() {
//		System.out.println("BoardItemServiceimpl.testAopAround() 메소드 호출");
//
//	}
//
//	@Override
//	public void testPointcutBefore() {
//		System.out.println("BoardItemServiceimpl.testPointcutBefore() 메소드 호출");
//
//	}
//
//	@Override
//	public void testPointcutAfter() {
//		System.out.println("BoardItemServiceimpl.testPointcutAfter() 메소드 호출");
//	}
//
//	@Override
//	public String testPointcutAfterReturning() {
//		System.out.println("BoardItemServiceimpl.testPointcutAfterReturning() 메소드 호출");
//		return "Success";
//	}
//
//	@Override
//	public void testPointcutAfterThrowing() {
//		System.out.println("BoardItemServiceimpl.testPointcutAfterThrowing() 메소드 호출");
//		throw new RuntimeException("runtime exception 발생");
//	}
//
//	@Override
//	public void testPointAround() {
//		System.out.println("BoardItemServiceimpl.testPointAround() 메소드 호출");
//
//	}
//
//	@Override
//	public String testNoTransactional() {
//		BoardItem boardItem = boardItemRepository.findById(5).get();
//		boardItem.setAuthor("update1 no Trans");
//		boardItemRepository.save(boardItem);
//		
//		throw new RuntimeException("Spring Boot No Transactional Test");
//		
//	}
//
//	@Override
//	@Transactional
//	public String testTransactional() {
//		BoardItem boardItem = boardItemRepository.findById(6).get();
//		boardItem.setAuthor("update1 Trans");
//		boardItemRepository.save(boardItem);
//		
//		throw new RuntimeException("Spring Boot Transactional Test");
//	}
//
//	@Override
//	public String testNoAop() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String testAop() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public List<BoardItem> selectItemAll() {
		List<BoardItem> list = boardItemRepository.findAll();
		return list;
	}

	@Override
	public Optional<BoardItem> selectItemOne(Integer id) {
		Optional<BoardItem> boardItem = boardItemRepository.findById(id);
		return boardItem;
	}

	@Override
	public void deleteItem(Integer id) {
		boardItemRepository.deleteById(id);
	}

	@Override
	public void updateItem(BoardItem boardItem) {
		
	}

	@Override
	public void insertItem(BoardItem boardItem) {
		boardItemRepository.
	}

	@Override
	public void countView(Integer id) {
		boardItemRepository.updateCnt(id);
	}

}