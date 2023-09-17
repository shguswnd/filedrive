package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import controller.dto.driveFileDto;
import service.file.FileService;

@Controller
@RequestMapping("/")
public class UploadDrive {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/drive")
	public String uploadFiles(HttpServletRequest request, MultipartFile file) {
		
		driveFileDto dto = new driveFileDto(request, file);
		
		//세션값 아직 안남들어 id는 직접 다시 넣는다
		dto.setUserid();
		
		//파일명
		dto.fileName(dto.getFile().getOriginalFilename());
		//real경로 삽입
		dto.findFileRealPath(request);
		//파일 경로
		dto.filePath(dto.getRealFilePath() + dto.getUserid());
		
		
		fileService.saveDriveFiles(dto, request);
		
		
		
		return "redirect:/";
	}
		
}
