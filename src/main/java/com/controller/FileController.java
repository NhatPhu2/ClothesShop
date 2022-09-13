package com.controller;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.service.FileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collection;

@CrossOrigin
@RestController
public class FileController {
		@Autowired
	    private FileService fileService;
	    @PostMapping("/upload")
	    public ResponseEntity<Object>  upload(@RequestParam("file") MultipartFile multipartFile) {
	    	
	        return ResponseEntity.ok(fileService.upload(multipartFile));
	    }

//		@PostMapping("/googleDrive/upload")
//	public ResponseEntity<> uploadGoogle(@RequestPart("file") MultipartFile multipartFile){
//
//		}




}
