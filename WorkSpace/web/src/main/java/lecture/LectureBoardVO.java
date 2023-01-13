package lecture;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class LectureBoardVO {
	
	private String title, content, writer,category;
	private int board_code, readcnt, root, step, lecture_code;
	private Date  writedate;
}
