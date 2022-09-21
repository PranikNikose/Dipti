package com.pranik.spring;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SpringFileUploadControler {

	@GetMapping("/index")
	public String hello() {
		return "uploader";
	}

	@PostMapping("/upload")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String fileName = file.getOriginalFilename();
		System.out.println("fileName:-" + fileName);
		try {
			file.transferTo(new File("D:\\UploadedFiles\\" + fileName));
			System.out.println("File Transfered");
		} catch (Exception e) {
			System.out.println("Error");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		System.out.println("Uploded");
		return ResponseEntity.ok("File Uploaded Succesfully");
	}

}
