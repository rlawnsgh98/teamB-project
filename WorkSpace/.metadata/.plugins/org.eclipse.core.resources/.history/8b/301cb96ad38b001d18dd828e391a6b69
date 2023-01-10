package visual;

import java.util.HashMap;
import java.util.List;

public interface VisualService {
	/* 데이터 객체에 담지 않고 HashMap에 담아 조회 */
	// 부서별 사원 수 조회
	List<HashMap<String, Object>> department();
	// 채용 인원 수(년도별/월별) 조회
	List<HashMap<String, Object>> hirement_year();
	List<HashMap<String, Object>> hirement_month();
	List<HashMap<String, Object>> hirement_top3_year();//상위3위 부서의 채용인원수(년도별)조회
	List<HashMap<String, Object>> hirement_top3_month();//상위3위 부서의 채용인원수(월별)조회
}
