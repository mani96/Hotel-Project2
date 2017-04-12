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
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = {"edit", "book"}, method = {RequestMethod.GET}, produces = "application/json")
    public @ResponseBody
    String editBooking(@RequestParam("") Map<String, String> values) {
        try {
            BookingManager bm = new BookingManager(Datasource.getDatasource());
            Booking booking = new Booking();

            booking.setBooking_id(Integer.parseInt(values.get("booking_id")));
            booking.setUsername(values.get("username"));
            booking.setRoom_number(Integer.parseInt(values.get("room_number")));
            booking.setStart_date(values.get("start_date"));
            booking.setEnd_date(values.get("end_date"));
            booking.setSpecial_notes(values.get("special_notes"));

            if (bm.doBooking(booking)) {
                return "SUCCESS: Booking is updated successfully";
            } else {
                return "FAILED: Booking is not updated. Please try again";
            }

        } catch (ClassNotFoundException e) {
            return "FAILED: Booking is not updated. Please try again";
        }
    }

}
