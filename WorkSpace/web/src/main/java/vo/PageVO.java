package vo;

public class PageVO {
	
	//검색관련
	private String search="all", keyword="", viewType="list";
	
	private int pageList = 10;
	private int blockPage = 10;
	//총 목록, 페이지, 블록 번호
	private int totalList, totalPage, totalBlock;
	//각 페이지의 시작, 끝 목록번호
	private int beginList, endList;
	//현재 페이지
	private int curPage = 1;
	//현재 블럭 번호, 끝 페이지번호, 시작 페이지번호
	private int curBlock, endPage, beginPage;
	
	//
	public void setTotalList(int totalList) {
		this.totalList = totalList;
		
		//총 페이지 수 계산
		totalPage = totalList / pageList;
		if( totalList % pageList > 0 ) ++totalPage;
		
		//총 블럭 수 계산
		totalBlock = totalPage / blockPage;
		if( totalPage % blockPage > 0 ) ++totalBlock;
		
		//각 페이지의 시작/끝 목록번호
		endList = totalList - (curPage - 1) * pageList;
		beginList = endList - (pageList - 1);
		
		//현재 블럭 번호
		curBlock = curPage / blockPage;
		if( curPage % blockPage > 0 ) ++curBlock;
		endPage = curBlock * blockPage;				//블럭의 끝 페이지 번호
		beginPage = endPage - (blockPage - 1); 		//블럭의 시작 페이지 번호
		
		//끝 페이지 번호가 총 페이지 수보다 클수 없으므로 총 페이지 수를 끝 페이지번호로 함
		if( totalPage < endPage ) endPage = totalPage;
	}
	
	
	public String getViewType() {
		return viewType;
	}

	public void setViewType(String viewType) {
		this.viewType = viewType;
	}
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getPageList() {
		return pageList;
	}
	public void setPageList(int pageList) {
		this.pageList = pageList;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getTotalList() {
		return totalList;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}
	public int getBeginList() {
		return beginList;
	}
	public void setBeginList(int beginList) {
		this.beginList = beginList;
	}
	public int getEndList() {
		return endList;
	}
	public void setEndList(int endList) {
		this.endList = endList;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getCurBlock() {
		return curBlock;
	}
	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	
}
