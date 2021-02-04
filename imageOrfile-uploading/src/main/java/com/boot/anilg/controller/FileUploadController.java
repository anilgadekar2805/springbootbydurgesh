package com.boot.anilg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.boot.anilg.helper.FileUploadHelper;

@RestController
public class FileUploadController {

	@Autowired
	FileUploadHelper fileUploadHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> saveFile(@RequestParam("file") MultipartFile file) {
		try {
			//request file validation
			if (file.isEmpty())
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Request must contain file");
			System.out.println("file types : " + file.getContentType());

			if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("application/pdf"))
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("only  image/jpeg or application/pdf  content type are required");

			boolean isSavedFile = fileUploadHelper.saveFile(file);

			if (isSavedFile)
				//return ResponseEntity.ok("file successfully uploaded");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body("something wend wrong, server not responding , please try leter");

	}
}
