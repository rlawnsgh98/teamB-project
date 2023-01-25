package board;

import vo.BoardPageVO;

public interface BoardService {

	//목록 조회
	public BoardPageVO board_list(BoardPageVO page);
	
}
