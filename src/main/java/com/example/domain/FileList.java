package com.example.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileList {
	private List<MultipartFile> files;
	
	public List<MultipartFile> getFiles() {
		return files;
	}
	
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	@Override
	public String toString()
	{
		return "FileList [files=" + files + "]";
	}
	
	
}
