package com.mohamad.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class SaleFileUpload {
	
	
		 
	    private List<MultipartFile> saleFiles;
	 
	    public List<MultipartFile> getFiles() {
	        return saleFiles;
	    }
	 
	    public void setFiles(List<MultipartFile> files) {
	        this.saleFiles = files;
	    }
	}

