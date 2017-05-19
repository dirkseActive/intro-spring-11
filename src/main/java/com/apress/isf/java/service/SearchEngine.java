package com.apress.isf.java.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;

import com.apress.isf.java.model.Document;
import com.apress.isf.java.model.Type;

/**
 * @author dirkseActive
 * @since 4/25/2017
 *
 */

public interface SearchEngine {

	public List<Document> findByType(Type documentType);
	
	public List<Document> listAll();
	
	public List<Document> findByLocation(String location);
}
