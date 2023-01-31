package common;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
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
		
		
		
		//첨부파일 다운로드
		public boolean fileDownload(String filename, String filepath, 
									HttpServletRequest request, HttpServletResponse response) throws Exception {
			//DB: http://localhost/smart/upload/info/2022/12/20/afdlj_abc.png
			//실제 : d://app/smart/upload/info/2022/12/20/afdlj_abc.png
			
			filepath = filepath.replace(appURL(request), "d://app/" + request.getContextPath());
			File file = new File(filepath);
			if(!file.exists()) {
				return false;
			}
			
			String mime = request.getSession().getServletContext().getMimeType(filename);
			response.setContentType(mime);
			
			//첨부파일을 다운로드 하는 것임을 지정
			response.setHeader("content-disposition", "attachment; filename="
								+ URLEncoder.encode( filename, "utf-8"));
			
			//IO : byte(inputstream/outputstream) 			char(reader/writer)
			//FileIO : fileinputstream/fileoutputstream		fileReader/filewriter
			ServletOutputStream out = response.getOutputStream();
			//파일정보를 읽어들여 저장해주는 처리
			FileCopyUtils.copy(new FileInputStream(file), out);
			out.flush();
			
			return true;
		}	
}
