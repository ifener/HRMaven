package com.ken.controller;

import com.ken.entity.Notice;
import com.ken.entity.User;
import com.ken.service.INoticeService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by it on 11/04/2017.
 */
@Controller
public class NoticeController {

    @Autowired
    INoticeService noticeService;

    @RequestMapping(value = "notice/notice")
    public ModelAndView selectNotice(Integer currentPageIndex, Notice notice,ModelAndView modelAndView){
        PageModel pageModel = new PageModel();
        if (currentPageIndex != null) {
            pageModel.setCurrentPageIndex(currentPageIndex);
        }

        List<Notice> notices = noticeService.findNotice(notice,pageModel);
        modelAndView.addObject("notices",notices);
        modelAndView.addObject("notice",notice);
        modelAndView.addObject("pageModel",pageModel);
        return modelAndView;
    }

    @RequestMapping(value = "notice/toAddNotice")
    public ModelAndView toAddNotice(Notice notice,ModelAndView modelAndView){
        modelAndView.addObject("notice",notice);
        modelAndView.setViewName("notice/addNotice");
        return modelAndView;
    }

    @RequestMapping(value = "notice/addNotice")
    public ModelAndView addNotice(Notice notice, ModelAndView modelAndView, HttpSession session){
        User user = (User) session.getAttribute("user");
        notice.setUser(user);
        noticeService.addNotice(notice);
        modelAndView.setView(new RedirectView("notice"));
        return modelAndView;
    }

    @RequestMapping(value = "notice/updateNotice")
    public ModelAndView updateNotice(String flag,Notice notice,ModelAndView modelAndView){
        if (flag.equals("1")) {
            notice = noticeService.findNoticeById(notice.getId());
            modelAndView.addObject("notice",notice);
            modelAndView.setViewName("notice/updateNotice");
        } else {
            noticeService.modifyNotice(notice);
            modelAndView.setView(new RedirectView("notice"));
        }

        return modelAndView;
    }

    @RequestMapping(value = "notice/preview")
    public ModelAndView preview(Integer id,ModelAndView modelAndView){
        Notice notice = noticeService.findNoticeById(id);
        modelAndView.addObject("notice",notice);
        modelAndView.setViewName("notice/preview");
        return modelAndView;

    }
}
