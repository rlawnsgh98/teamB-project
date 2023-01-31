package enrolment;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrolmentServiceImpl implements EnrolmentService{
	@Autowired private EnrolmentDAO dao;

	@Override
	public int enrolment_kt(HashMap<String, String> tempMap) {
		return dao.enrolment_kt(tempMap);
	}
}
