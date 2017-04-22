package com.ken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by it on 09/04/2017.
 */
@Controller
public class FormController {

    @RequestMapping(value = "/{jspName}")
    public String toForm(@PathVariable String jspName){
        return jspName;
    }
}
