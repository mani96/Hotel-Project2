/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author manvir
 */
//just for testing purpose
@Controller
public class Admin {
    @RequestMapping(value={"Admin"})
    public ModelAndView AdminController(ModelAndView mv){
        mv = new ModelAndView("Admin");
        return mv;
    }
}
