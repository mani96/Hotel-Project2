/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelProject.controllers;

import dao.BookingManager;
import dao.UserManager;
import datasource.Datasource;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import wrappers.Booking;
import wrappers.Search;

/**
 *
 * @author Anirudh
 */

@Controller
public class User {

    /**
     * This will give you all user information and all booking that has been
     * done so far by that user
     *
     * Extract data about booking from "bookings" key Extract data about user
     * from "user" key
     *
     * @param username
     * @return ModelAndView with bookings and user data
     */
    @RequestMapping(value = {"user"})
    public ModelAndView loadPage(@RequestParam("roomNumber") String username) {
        ModelAndView mv = new ModelAndView("admin");

        try {

            UserManager users = new UserManager(Datasource.getDatasource());
            wrappers.User user = users.get(username);

            mv.addObject("user", user);

            // this will give all bookings that have been booked by user so far
            BookingManager books = new BookingManager(Datasource.getDatasource());

            List<Booking> bookings = books.get(Search.USERNAME, username);
            mv.addObject("bookings", bookings);

        } catch (ClassNotFoundException e) {
            mv.addObject("bookings", null);
            mv.addObject("user", null);

        }

        return mv;
    }

    
    
    
    /**
     * This method will allow user to book particular Room from one date to
     * another date.
     *
     * @param values, This contains all information of room User wants to book
     * @return
     */
    @RequestMapping(value = {"bookRoom"})
    public ModelAndView bookRoom(@RequestParam("") Map<String, String> values) {

        ModelAndView mv = new ModelAndView(new RedirectView("index"));
        Booking book = new Booking();

        book.setBooking_id(1);
        book.setRoom_number(Integer.parseInt(values.get("RoomNumber")));

        //I am confused her which one user. I am not sure if we would get username from front page,
//        and I think it is good to user session variables to maintain state ~~~~~~~ NISH ~~~~~~~~
//        book.setUsername(values.get("Username")); 
//        book.setUsername(session.getAttribute("username"));
        book.setStart_date(values.get("StartDate"));
        book.setEnd_date(values.get("EndDate"));
        book.setSpecial_notes(values.get("SpecialNotes"));

        try {
            BookingManager bookings = new BookingManager(Datasource.getDatasource());
            if (bookings.doBooking(book)) {
                mv.addObject("status", "SUCCESS");
                mv.addObject("reason", "Room has been successfully booked");
            } else {
                mv.addObject("status", "FAILED");
                mv.addObject("reason", "Room could not be booked. Please try agian");
            }

        } catch (ClassNotFoundException e) {
            mv.addObject("status", "FAILED");
            mv.addObject("reason", "Database went wrong. Please try agian");
        }
        return mv;
    }

}
