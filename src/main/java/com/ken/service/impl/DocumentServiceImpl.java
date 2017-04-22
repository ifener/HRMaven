package com.ken.service.impl;

import com.ken.entity.Document;
import com.ken.mapper.DocumentMapper;
import com.ken.service.IDocumentService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by it on 09/04/2017.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class DocumentServiceImpl implements IDocumentService {

    @Autowired
    DocumentMapper documentMapper;

    @Override
    public List<Document> findDocument(Document document, PageModel pageModel) {
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("document",document);
        Integer recordCount = documentMapper.count(params);
        pageModel.setRecordCount(recordCount);
        if (recordCount>0){
            params.put("pageModel",pageModel);
        }
        return documentMapper.selectByPage(params);
    }

    @Override
    public Integer addDocument(Document document) {
        return documentMapper.add(document);
    }

    @Override
    public Integer removeDocumentById(Integer id) {
        return documentMapper.delete(id);
    }

    @Override
    public void modifyDocument(Document document) {
        documentMapper.update(document);
    }

    @Override
    public Document findDocumentById(Integer id) {
        return documentMapper.selectById(id);
    }
}
