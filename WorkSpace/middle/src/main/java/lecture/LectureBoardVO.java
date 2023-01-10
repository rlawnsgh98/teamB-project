package lecture;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class LectureBoardVO {
	
	private String title, content, writer, writedate, category;
	private int board_code, readcnt, root, step, lecture_code;
}
