package com.ken.controller;

import com.ken.entity.Document;
import com.ken.entity.User;
import com.ken.service.IDocumentService;
import com.ken.util.tag.PageModel;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by it on 11/04/2017.
 */
@Controller
public class DocumentController {

    @Autowired
    IDocumentService documentService;

    @RequestMapping(value = "/document/document")
    public ModelAndView selectDocument(Integer currentPageIndex, Document document,ModelAndView modelAndView){
        PageModel pageModel = new PageModel();
        if (currentPageIndex != null) {
            pageModel.setCurrentPageIndex(currentPageIndex);
        }

        List<Document> documents = documentService.findDocument(document,pageModel);
        modelAndView.addObject("documents",documents);
        modelAndView.addObject("document",document);
        modelAndView.addObject("pageModel",pageModel);
        modelAndView.setViewName("document/document");
        return modelAndView;
    }

    @RequestMapping(value = "/document/addDocument")
    public ModelAndView addDocument(String flag, Document document, ModelAndView modelAndView,
                                    HttpServletRequest request) throws IOException {
        if (flag.equals("1")) {
            modelAndView.addObject("document",document);
            modelAndView.setViewName("document/addDocument");
        } else {
            if (document.getFile()!=null && !document.getFile().getOriginalFilename().isEmpty()){
                String fileName = generateFileName(document.getFile().getOriginalFilename());
                String path = request.getServletContext().getRealPath("/uploadImages/");



                File file = new File(path,fileName);
                if (!file.getParentFile().exists()){
                    file.getParentFile().mkdirs();
                }
                document.getFile().transferTo(file);
                document.setFileName(fileName);
            }

            User user = (User)request.getSession().getAttribute("user");
            document.setUser(user);
            documentService.addDocument(document);
            modelAndView.setViewName("redirect:document");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/document/updateDocument")
    public ModelAndView updateDocument(String flag,Document document,ModelAndView modelAndView,HttpServletRequest request) throws IOException {
        if (flag.equals("1")) {
            document = documentService.findDocumentById(document.getId());
            modelAndView.addObject("document",document);
            modelAndView.setViewName("document/updateDocument");
        } else {
            if (document.getFile()!=null){
                String fileName = generateFileName(document.getFile().getOriginalFilename());
                String path = request.getServletContext().getRealPath("/uploadImages/");

                if(document.getFileName()!=null){
                    File originalFile = new File(path+File.separator+document.getFileName());
                    if (originalFile.exists()){
                        originalFile.delete();
                    }
                }

                File file = new File(path+File.separator+fileName);

                document.getFile().transferTo(file);
                document.setFileName(fileName);
            }

            User user = (User)request.getSession().getAttribute("user");
            document.setUser(user);
            documentService.modifyDocument(document);
            modelAndView.setViewName("redirect:document");
        }
        return modelAndView;
    }

    private String generateFileName(String fileName){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssms");
        String currentDt = format.format(new Date());
        String extension = fileName.substring(fileName.lastIndexOf("."));
        int randomNumber = new Random().nextInt(1000);

        return currentDt+"_"+String.valueOf(randomNumber)+extension;
    }

    @RequestMapping(value = "/document/download")
    public ResponseEntity<byte[]> download(Integer id,HttpServletRequest request) throws IOException {
        Document document = documentService.findDocumentById(id);
        String fileName = document.getFileName();
        String path = request.getServletContext().getRealPath("/uploadImages/");

        File file = new File(path,fileName);
        HttpHeaders headers = new HttpHeaders();
        String downloadFileName = new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
        headers.setContentDispositionFormData("attachment",downloadFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}

