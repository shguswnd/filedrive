package vo.drive;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Drive {
	private String userid;
	private MultipartFile path;
	private String realFilePath;
	private String filename;
	
	@Builder
	public Drive(String userid, MultipartFile path, String realFilePath, String filename) {
		this.userid = userid;
		this.path = path;
		this.realFilePath = realFilePath;
		this.filename = filename;
	}
	
	public Drive(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.userid =  request.getParameter(userid);
		this.path = null;
		this.realFilePath = "/";
		this.filename = request.getParameter(filename);
	}
}
