package kr.ac.kopo.ctc.spring.board.dto;

public class Pagination {
	private Integer ppPage;	//<<: 첫 페이지로
	private Integer pPage;	//< : 이전 숫자 그룹의 첫 페이지로
	
	private Integer nPage;	//> : 다음 숫자 그룹의 첫 숫자
	private Integer nnPage;	//>> : 마지막 페이지로
	
	private Integer cPage;	// 현재 페이지
	private Integer startPage;	// 현재 그룹의 시작 페이지 번호
	private Integer lastPage;	// 현재 그룹의 마지막 페이지 번호
	
	private Integer countPerpage;	// 한 페이지에 나올 숫자 목록
	private Integer pageSize;	//한 페이지 목록 수
	private Integer totalCount;	//전체 목록 수
	private Integer totalPage;	//전체 페이지 수
	public Integer getPpPage() {
		return ppPage;
	}
	public void setPpPage(Integer ppPage) {
		this.ppPage = ppPage;
	}
	public Integer getpPage() {
		return pPage;
	}
	public void setpPage(Integer pPage) {
		this.pPage = pPage;
	}
	public Integer getnPage() {
		return nPage;
	}
	public void setnPage(Integer nPage) {
		this.nPage = nPage;
	}
	public Integer getNnPage() {
		return nnPage;
	}
	public void setNnPage(Integer nnPage) {
		this.nnPage = nnPage;
	}
	public Integer getcPage() {
		return cPage;
	}
	public void setcPage(Integer cPage) {
		this.cPage = cPage;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getLastPage() {
		return lastPage;
	}
	public void setLastPage(Integer lastPage) {
		this.lastPage = lastPage;
	}
	public Integer getCountPerpage() {
		return countPerpage;
	}
	public void setCountPerpage(Integer countPerpage) {
		this.countPerpage = countPerpage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


}
