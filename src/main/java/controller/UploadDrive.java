package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import service.file.FileService;

@Controller
@RequestMapping("/")
public class UploadDrive {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/drive")
	public String uploadFiles(HttpServletRequest request, MultipartFile file) {
		
		
		
		return "redirect:/";
	}
		
}
