package board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.BoardPageVO;
import vo.BoardVO;
import vo.ReplyVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired private BoardDAO dao;
	
	@Override
	public BoardPageVO board_list(BoardPageVO page) {
		return dao.board_list(page);
	}

	@Override
	public BoardVO board_info(int board_code) {
		return dao.board_info(board_code);
	}

	@Override
	public int board_read(int board_code) {
		return dao.board_read(board_code);
	}

	@Override
	public List<ReplyVO> board_reply(int board_code) {
		return dao.board_reply(board_code);
	}

}
