package controller.dto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

@Getter
public class driveFileDto {
	private String userid;
	private MultipartFile path;
	private String realFilePath;
	private String filename;
	
	public driveFileDto(HttpServletRequest request, MultipartFile file) {
		try {
			request.setCharacterEncoding("utf-8");
			this.userid = request.getParameter("email");
			this.path = file;
			this.realFilePath = request.getParameter("realFilePath");
			this.filename = request.getParameter("filename");

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	// 실제 파일 경로 얻기
	public void findFileRealPath(HttpServletRequest request) {
		this.realFilePath = request.getServletContext().getRealPath("/files/upload/licence/");
	}
}
