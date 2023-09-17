package controller.dto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

@Getter
public class driveFileDto {
	private String userid;
	private MultipartFile file;
	private String path;
	private String realFilePath;
	private String filename;
	
	public driveFileDto(HttpServletRequest request, MultipartFile file) {
		try {
			request.setCharacterEncoding("utf-8");
			this.userid = request.getParameter("email");
			this.file = file;
			this.filename = request.getParameter("filename");

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void setUserid() {
		this.userid = "Test";
	}
	// 파일 이름
	public void fileName(String filename) {
		this.filename = filename;
	}
	// 실제 파일 경로 얻기
	public void findFileRealPath(HttpServletRequest request) {
		this.realFilePath = request.getServletContext().getRealPath("/files/upload/licence/");
	}

	// 파일 경로 얻기
	public void filePath(String path) {
		this.path = path;
	}
	
	public String toString() {
		return "[userid : " + this.userid + "] "+ " [file : "  + this.file + "] " + "realFilePath : " + this.realFilePath + "] " + "[filename : " + this.filename + "] ";
	}
}
