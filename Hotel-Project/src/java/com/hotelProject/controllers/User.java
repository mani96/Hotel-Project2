/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelProject.controllers;

import dao.BookingManager;
import datasource.Datasource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import wrappers.Booking;
import wrappers.Search;

/**
 *
 * @author Nish
 */
@Controller
public class User {

    @RequestMapping(value={"redirectUser","user"})
    public ModelAndView redirect(HttpSession session) {
        ModelAndView mv = new ModelAndView("user");
         List<Booking> booking = new ArrayList<>();
        try {
            BookingManager bm = new BookingManager(Datasource.getDatasource());
            wrappers.User u = (wrappers.User)session.getAttribute("user");
            booking = bm.get(Search.USERNAME, u.getUsername());
            mv.addObject("status","SUCCESS");
        } catch (ClassNotFoundException e) {
            mv.addObject("status","FAILED");
        }
        mv.addObject("bookings",booking);
        return mv;
    }

    @RequestMapping(value = {"editUserBooking"}, method = {RequestMethod.POST})
    public 
    ModelAndView editBooking(@RequestParam("") Map<String, String> values, HttpSession session) {
         ModelAndView mv = new ModelAndView("user");
        try {
            BookingManager bm = new BookingManager(Datasource.getDatasource());
            Booking booking = new Booking();

            booking.setBooking_id(Integer.parseInt(values.get("booking_id")));
            booking.setUsername(values.get("username_b"));
            booking.setRoom_number(Integer.parseInt(values.get("room_number")));
            booking.setStart_date(values.get("start_date"));
            booking.setEnd_date(values.get("end_date"));
            booking.setSpecial_notes(values.get("special_notes"));
         
            if (bm.doBooking(booking)) {
                mv.addObject("editResult", "SUCCESS: Booking is updated successfully");
            } else {
                 mv.addObject("editResult", "FAILED: Booking is not updated. Please try again");
            }

        } catch (ClassNotFoundException e) {
             mv.addObject("editResult", "FAILED: Booking is not updated. Please try again");
        }
return mv;
    }

}
