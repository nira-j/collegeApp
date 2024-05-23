package com.college.app.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.college.app.model.User;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {

	void init();

	void store(MultipartFile file, String username, String type);

	Stream<Path> loadAll();

	Path load(String filename);

	Resource loadAsResource(String filename);

	void deleteAll();

}