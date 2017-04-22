package com.ken.controller;

import com.ken.entity.Position;
import com.ken.service.IPositionService;
import com.ken.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by it on 10/04/2017.
 */
@Controller
public class PositionController {

    @Autowired
    IPositionService positionService;

    @RequestMapping(value = "/position/position")
    public ModelAndView selectPosition(Integer currentPageIndex , Position position,ModelAndView modelAndView){
        PageModel pageModel = new PageModel();
        if (currentPageIndex!=null){
            pageModel.setCurrentPageIndex(currentPageIndex);
        }

        List<Position> positions = positionService.findPosition(position,pageModel);
        modelAndView.addObject("pageModel",pageModel);
        modelAndView.addObject("positions",positions);
        modelAndView.addObject("position",position);
        modelAndView.setViewName("position/position");
        return modelAndView;
    }

    @RequestMapping(value = "/position/addPosition")
    public ModelAndView addPosition(String flag,Position position,ModelAndView modelAndView){
        if (flag.equals("1")){
            modelAndView.setViewName("position/addPosition");
        } else {
            positionService.addPosition(position);
            modelAndView.setViewName("redirect:/position/position");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/position/updatePosition")
    public ModelAndView updatePosition(String flag,Position position,ModelAndView modelAndView){
        if (flag.equals("1")){
            modelAndView.setViewName("position/updatePosition");
        } else {
            positionService.modifyPosition(position);
            modelAndView.setViewName("redirect:/position/position");
        }
        return modelAndView;
    }

}
