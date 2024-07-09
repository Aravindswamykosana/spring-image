package com.example.springimage.controller;

import java.io.IOException;

import javax.imageio.ImageTypeSpecifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springimage.dao.ImageCrud;
import com.example.springimage.entity.Image;
@RestController
public class Main {
	
	@Autowired
	private ImageCrud crud;
	
	@PostMapping("/saveimg")
	public ResponseEntity<Image> saveImg(@RequestBody MultipartFile img) throws IOException {
		Image img1=new Image();
		img1.setData(img.getBytes());
		img1.setName(img.getName());
		img1.setType(img.getContentType());
		crud.saveImg(img1);
		return new ResponseEntity<Image>(img1,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<byte[]>fetchImg(@RequestParam int id){
		Image i=crud.fetchImg(id);
		byte[] data = i.getData();
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);
		return new ResponseEntity<byte[]>(data,headers,HttpStatus.FOUND);
	}
	@PostMapping("/updateimg")
	public ResponseEntity<Image> updateImg(@RequestBody MultipartFile img,@RequestParam int id) throws IOException{
		Image img1=new Image();
		img1.setData(img.getBytes());
		img1.setName(img.getName());
		img1.setType(img.getContentType());
		crud.updateImg(img1,id);
		return new ResponseEntity<Image>(img1,HttpStatus.ACCEPTED);
	}
}