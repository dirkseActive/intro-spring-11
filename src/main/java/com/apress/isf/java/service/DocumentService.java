package com.apress.isf.java.service;

import java.util.List;

import com.apress.isf.java.model.Document;

/**
 * @author dirkseActive
 * @since 4/25/2017
 * Updated: 5/31/2017 for REST, ch. 12
 */
public interface DocumentService {
	
	public List<Document> getAllDocuments();
	public Document findDocumentById(String id);
	public Document saveDocument(String id, Document document);
	public Document removeDocumentById(String id);
	public boolean updateLocationFromDocumentId(String documentId, String location);
	
	//public void createNewType(Type type);
	//public void updateType(Type type);
	//public void removeTypeById(String id);
	//public List<Type> getAllDefinedTypes();
	//public Type getTypeById(String id);
	//public void createNewDocument(Document document);
	//public void removeDocumentById(String id);
	//public void updateDocument(Document document);
	//public void updateLocationFromDocumentId(String documentId, String location);
}
