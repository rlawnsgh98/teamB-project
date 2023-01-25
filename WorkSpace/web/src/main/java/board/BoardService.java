package board;

import java.util.List;

import vo.BoardPageVO;
import vo.BoardVO;
import vo.ReplyVO;

public interface BoardService {

	//게시판 댓글 정보
	public List<ReplyVO> board_reply(int board_code);
	
	//게시판 상세 정보
	public BoardVO board_info(int board_code);
	
	//목록 조회
	public BoardPageVO board_list(BoardPageVO page);
	
	//조회수 증가처리
	public int board_read(int board_code);
	
}
