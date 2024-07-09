package com.example.springimage.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springimage.entity.Image;

public interface ImageRepo extends JpaRepository<Image, Integer>{
	
}