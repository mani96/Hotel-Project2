package com.hotelProject.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manvir
 */
@Controller
public class index {
    @RequestMapping(value = {"home","index"})
    public ModelAndView HomePage(ModelAndView mv){
        mv = new ModelAndView("index");
        //i want option list for showing rooms types
        //then i will send ajax request to "checkAvailabale.htm"
        return mv;
    }
}
