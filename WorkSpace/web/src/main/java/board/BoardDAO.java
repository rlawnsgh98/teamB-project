package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.BoardPageVO;
import vo.BoardVO;
import vo.ReplyVO;

@Repository
public class BoardDAO implements BoardService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public BoardPageVO board_list(BoardPageVO page) {
		page.setTotalList(sql.selectOne("board.total", page));
		page.setList(sql.selectList("board.board_list", page));
		return page;
	}

	@Override
	public BoardVO board_info(int board_code) {
		BoardVO vo = sql.selectOne("board.board_info", board_code);
		vo.setFileList(sql.selectList("board.file_list", board_code));
		return vo;
	}

	@Override
	public int board_read(int board_code) {
		return sql.update("board.board_read", board_code);
	}

	@Override
	public List<ReplyVO> board_reply(int board_code) {
		return sql.selectList("board.board_reply", board_code);
	}

}
