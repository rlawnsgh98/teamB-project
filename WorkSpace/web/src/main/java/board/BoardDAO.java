package board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import vo.BoardPageVO;

@Repository
public class BoardDAO implements BoardService {
	@Autowired @Qualifier("bteam") private SqlSession sql;
	
	@Override
	public BoardPageVO board_list(BoardPageVO page) {
		page.setTotalList(sql.selectOne("board.total", page));
		page.setList(sql.selectList("board.board_list", page));
		return page;
	}

}
