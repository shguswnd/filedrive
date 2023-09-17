package service.file;

import java.io.File;
import java.io.FileOutputStream;

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
		//폴더 생성
		createPath(basicPath);
		createPath(basicPath + "upload/");
		
		if(!dto.getFile().getOriginalFilename().equals("")) {
			FileOutputStream fs = null;
			try {
				createPath(dto.getRealFilePath());
				createPath(dto.getRealFilePath() + dto.getUserid());
				File destFile = new File(dto.getPath() + "/" + dto.getFilename());
				fs = new FileOutputStream(destFile);
				fs.write(dto.getFile().getBytes());
				
				// 파일권한
				destFile.setExecutable(false);
				destFile.setReadable(true);
				destFile.setWritable(false);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					fs.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
	}
	
	private void createPath(String path) {
		File dir = new File(path);
		if(!dir.isDirectory()) {
			dir.mkdir();
		}
	}
}
