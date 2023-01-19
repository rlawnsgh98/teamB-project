package visual;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisualServiceImpl implements VisualService {
	@Autowired private VisualDAO dao; 
	
	@Override
	public List<HashMap<String, Object>> department() {
		return dao.department();
	}

	@Override
	public List<HashMap<String, Object>> hirement_year() {
		return dao.hirement_year();
	}

	@Override
	public List<HashMap<String, Object>> hirement_month() {
		return dao.hirement_month();
	}

	@Override
	public List<HashMap<String, Object>> hirement_top3_year() {
		return dao.hirement_top3_year();
	}

	@Override
	public List<HashMap<String, Object>> hirement_top3_month() {
		return dao.hirement_top3_month();
	}

}
