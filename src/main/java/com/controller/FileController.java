package com.controller;

import com.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin
@RestController
public class FileController {
		@Autowired
	    private FileService fileService;
	    @PostMapping("/upload")
	    public ResponseEntity<Object>  upload(@RequestParam("file") MultipartFile multipartFile) {
	    	
	        return ResponseEntity.ok(fileService.upload(multipartFile));
	    }
}
