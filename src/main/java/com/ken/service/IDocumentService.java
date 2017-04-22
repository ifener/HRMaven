package com.ken.service;

import com.ken.entity.Document;
import com.ken.util.tag.PageModel;

import java.util.List;

/**
 * Created by it on 08/04/2017.
 */
public interface IDocumentService {

    List<Document> findDocument(Document document, PageModel pageModel);

    Integer addDocument(Document document);

    Integer removeDocumentById(Integer id);

    void modifyDocument(Document document);

    Document findDocumentById(Integer id);
}
