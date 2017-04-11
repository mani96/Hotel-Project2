/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelProject.controllers;

import dao.RoomManager;
import datasource.Datasource;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import wrappers.Room;

/**
 *
 * @author manvir
 */
//just for testing purpose
@Controller
public class Admin {

    @RequestMapping("redirectAdmin")
    public ModelAndView redirect()
    {
        return new ModelAndView("admin");
    }
    
    @RequestMapping(value = {"addRoom"})
    public @ResponseBody String addRooms(@RequestParam("") Map<String, String> values) {
        ModelAndView mv = new ModelAndView(new RedirectView("index"));
        Room room = new Room();
        room.setRoomNumber(Integer.parseInt(values.get("RoomNumber")));
        room.setFridge(Boolean.valueOf(values.get("Fridge")));
        room.setTV(Boolean.valueOf(values.get("TV")));
        room.setWiFi(Boolean.valueOf(values.get("WiFi")));
        room.setPrice(Double.valueOf(values.get("price")));
        room.setGuests(Integer.parseInt(values.get("roomType")));
        try {
            RoomManager rooms = new RoomManager(Datasource.getDatasource());
            if (rooms.saveOrUpdate(room)) {
                return "SUCCESS:Room is saved successfully!";
            } else {
                return "FAILED:Room could not be saved. Try again.";
            }

        } catch (ClassNotFoundException e) {
            return "FAILED:Something went wrong! Try again!";
           
        }
    }
    
    @RequestMapping(value = {"getAllRooms"}, method = {RequestMethod.GET}, produces="application/json")
    public @ResponseBody List<Room> getAllRooms()
    {
        try {
            RoomManager rooms = new RoomManager(Datasource.getDatasource());
            return rooms.list();
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
    
    @RequestMapping(value = {"deleteRoom"}, method = {RequestMethod.GET})
    public @ResponseBody String deleteRooms(@RequestParam("roomNumber") int id) {
        // add room to database please make sure the data is correct and redirect accordingly
        //ModelAndView mv = new ModelAndView(new RedirectView("admin"));
        String result ="";
        try {
            RoomManager rooms = new RoomManager(Datasource.getDatasource());
            if (rooms.delete(id)) {
          
                result =  "Room is deleted successfully";
               // mv.addObject("status", "SUCCESS");
               // mv.addObject("reason", "Room is deleted successfully");
            } else {
                result = "FAILED: Room could not be delted. Try again";
               // mv.addObject("status", "FAILED");
               // mv.addObject("reason", "Room could not be delted. Try again.");
            }

        } catch (ClassNotFoundException e) {
            result = "FAILED: Database went wrong. Please try agian";
           // mv.addObject("status", "FAILED");
           // mv.addObject("reason", "Database went wrong. Please try agian");
        }

        return result;
    }

//    @RequestMapping(value = {"addRoom", "editRoom"}, method = {RequestMethod.GET})
    public ModelAndView getReservation(@ModelAttribute("newWrapper") String data) {
        // get the information and store it in the wrapper class and finally give the right result based on the search!
        return null;
    }

}
