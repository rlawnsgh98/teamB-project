package board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vo.BoardPageVO;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired private BoardDAO dao;
	
	@Override
	public BoardPageVO board_list(BoardPageVO page) {
		return dao.board_list(page);
	}

}
