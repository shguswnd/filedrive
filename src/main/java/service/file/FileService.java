package service.file;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import controller.dto.driveFileDto;

@Service
public class FileService {
	
	private final String PATH = "/files/upload";
	
	public void saveDriveFiles(driveFileDto dto, HttpServletRequest request) {
		ServletContext basicContext = request.getServletContext();
		String basicPath = request.getServletContext().getRealPath("/files/");
		
		System.out.println("basicContext " + basicContext);
		System.out.println("basicPath " + basicPath);
		
	}
}
