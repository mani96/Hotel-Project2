/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wrappers.Room;

/**
 *
 * @author manvir
 */
//just for testing purpose
@Controller
public class Admin {
    @RequestMapping(value={"admin"})
    public ModelAndView AdminController(ModelAndView mv){
        mv = new ModelAndView("admin");
        return mv;
    }
    public ModelAndView addRooms(@ModelAttribute("room") Room room)
    {
        // add room to database please make sure the data is correct and redirect accordingly
        return null;
    }
    
    public ModelAndView editRooms(@ModelAttribute("room") Room room)
    {
        // add room to database please make sure the data is correct and redirect accordingly
        return null;
    }
   
    public ModelAndView deleteRooms(@RequestParam("roomNumber") int id)
    {
        // add room to database please make sure the data is correct and redirect accordingly
        return null;
    }
    
    public ModelAndView getReservation(@ModelAttribute("newWrapper") String data)
    {
        // get the information and store it in the wrapper class and finally give the right result based on the search!
        return null;
    }
    
}
