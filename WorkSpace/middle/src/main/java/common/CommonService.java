package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import vo.BoardFileVO;


@Service("common")
public class CommonService {
	
	//첨부파일 업로드
	public String fileUpload(String category, MultipartFile file, HttpServletRequest request) {
		//업로드할 물리적 위치
		// 프로젝트 내 위치 말고 지정 위치에 저장하도록 하기
		String path = "d://app" + request.getContextPath();
//		String path = request.getSession().getServletContext().getRealPath("resources");
		// upload/myinfo/2022/12/20 폴더 경로
		String upload = "/upload/" + category
				+ new SimpleDateFormat("/yyyy/MM/dd").format(new Date());
		path += upload;
		
		//해당 폴더 없으면 만들기
		File folder = new File( path );
		if( ! folder.exists() ) folder.mkdirs();
		
		//해당 폴더에 첨부한 파일을 저장
		String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
		try {
			file.transferTo(new File(path, filename));
		} catch (Exception e) {
			e.printStackTrace();
		} 
		// http://localhost/smart/upload/myinfo/.date./asefl_abc.png
		return appURL(request) + upload + "/" + filename;
	}
		
	
	
	// 요청 url의 contextpath
	public String appURL(HttpServletRequest request) {
		return request.getRequestURL().toString().replace(request.getServletPath(), "");
	}
	
	
	
	
	
}
