package attendance;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AttendanceVO {
	private int lecture_code, member_code, attendance_code; 
	private String state, ok, no, hf, start, end, week;
	private Date attendance_time;

}
