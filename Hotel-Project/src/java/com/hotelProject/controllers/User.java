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
 * @author Anirudh
 */

@Controller
public class User {
    
    /**
     *
     * @return
     */
    @RequestMapping(value = {"user"})
    public ModelAndView loadPage()
    {
        
        //dump page info
        return null;
    }
    
    /**
     *
     * @return
     */
    public ModelAndView bookRoom()
    {
        return null;
    }
    
}
