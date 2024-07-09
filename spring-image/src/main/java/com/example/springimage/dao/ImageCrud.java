package com.example.springimage.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springimage.entity.Image;
import com.example.springimage.repo.ImageRepo;

@Repository
public class ImageCrud {
	@Autowired
	private ImageRepo repo;
	
	public Image saveImg(Image img) {
		return repo.save(img);
	}
	
	public Image fetchImg(int id) {
		Optional<Image> db = repo.findById(id);
		if(db!=null) {
			return db.get();
		}
		else {
			return null;
		}
	}
	public Image updateImg(Image img,int id) {
		Optional<Image> db = repo.findById(id);
		if(db!=null) {
			Image i = db.get();
			i.setData(img.getData());
			return repo.save(i);
		}
		else {
			return null;
		}
	}
}
