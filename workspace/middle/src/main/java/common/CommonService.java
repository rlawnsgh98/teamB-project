package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CommonService {
	//첨부파일 업로드
		public String fileUpload(String category, MultipartFile file, HttpServletRequest request) {
			//업로드할 물리적 위치
			//D:\Study_Spring\.metadata\.....\smart\resources
			//String path = request.getSession().getServletContext().getRealPath("resources");
			//프로젝트내의 물리적영역이 아니라 고정적인 물리영역에 저장하도록 한다
			String path = "d://app" + request.getContextPath(); // d://app/smart
			// /upload/myinfo/2022/12/20
			String upload = "/upload/" + category 
						  + new SimpleDateFormat("/yyyy/MM/dd").format( new Date() );
			// D:\Study_Spring\.metadata\.....\smart\resources/upload/myinfo/2022/12/20		
			path +=  upload;
			//해당 폴더가 없으면 폴더를 만든다
			File folder = new File( path );
			if( ! folder.exists() ) folder.mkdirs();
			
			//해당 폴더에 첨부한 파일을 저장한다		
			String filename = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
			
			try {
				file.transferTo( new File(path, filename) );
			} catch (Exception e) {
				e.printStackTrace();
			}
			//  http://localhost/smart/upload/myinfo/2022/12/20/afdlj_abc.png		
			return appURL(request) + upload + "/" + filename;		
		}

		// 요청 url의 contextpath
		public String appURL(HttpServletRequest request) {
			return request.getRequestURL().toString().replace(request.getServletPath(), "");
		}
}
