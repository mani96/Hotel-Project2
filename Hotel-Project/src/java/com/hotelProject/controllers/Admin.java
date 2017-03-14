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
 * @author Anirudh
 */
@Controller
public class Admin {
    
    /**
     *
     * @return
     */
    @RequestMapping(value = {"admin"})
    public ModelAndView loadPage()
    {
        // give a list of all bookings already made
        // give a list of all the rooms numbers in the hotel
        return new ModelAndView("admin");
    }
    
    /**
     *
     * @param room
     * @return
     */
    public ModelAndView addRooms(@ModelAttribute("room") Room room)
    {
        // add room to database please make sure the data is correct and redirect accordingly
        return null;
    }
    
    /**
     *
     * @param room
     * @return
     */
    public ModelAndView editRooms(@ModelAttribute("room") Room room)
    {
        // add room to database please make sure the data is correct and redirect accordingly
        return null;
    }
   
    /**
     *
     * @param id
     * @return
     */
    public ModelAndView deleteRooms(@RequestParam("roomNumber") int id)
    {
        // add room to database please make sure the data is correct and redirect accordingly
        return null;
    }
    
    /**
     *
     * @param data
     * @return
     */
    public ModelAndView getReservation(@ModelAttribute("newWrapper") String data)
    {
        // get the information and store it in the wrapper class and finally give the right result based on the search!
        return null;
    }
    
    
    
}
