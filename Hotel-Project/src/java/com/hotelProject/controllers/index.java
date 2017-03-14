package com.hotelProject.controllers;


import dao.BookingManager;
import dao.RoomManager;
import dao.UserManager;
import datasource.Datasource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import wrappers.Authenticate;
import wrappers.DateFormatter;
import wrappers.Room;
import wrappers.User;

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

    /**
     *
     * @param mv
     * @return
     */
    @RequestMapping(value = {"home","index"})
    public ModelAndView HomePage(ModelAndView mv){
        mv = new ModelAndView("index");
        //i want option list for showing rooms types
        //then i will send ajax request to "checkAvailabale.htm"
        return mv;
    }
    
    @RequestMapping(value = {"logout"})
    public ModelAndView logout(ModelAndView mv,HttpServletRequest request){
        mv = new ModelAndView("index");
        request.getSession().invalidate();
        return mv;
    }
    
    /**
     *
     * @param auth
     * @param request
     * @return
     */
    @RequestMapping(value = {"authenticate","login"}, method = {RequestMethod.POST})
    public ModelAndView loginUser(@ModelAttribute("Authenticate") Authenticate auth,HttpServletRequest request)
    {
        ModelAndView mv = null;
        if(auth.username.isEmpty() || auth.password.isEmpty())
        {
            // empty username and password redirect to login page again!
            mv = new ModelAndView("index");
            mv.addObject("status","FAILED");
            mv.addObject("reason","Empty username or password!");
        }
        else
        {
            try {
                // ready to process
                UserManager usm = new UserManager(Datasource.getDatasource());
                boolean authenticated = usm.authenticate(auth);
                if(authenticated)
                {
                    User user = usm.get(auth.username);
                    if(user.isAdmin())
                    {
                        // redirect to admin page
                        mv = new ModelAndView("admin");
                        mv.addObject("status","SUCCESS");
                        mv.addObject("reason","User found(Admin) see user session variable.");
                    }
                    else
                    {
                        // redirect to user page
                        mv = new ModelAndView("user");
                        mv.addObject("status","SUCCESS");
                        mv.addObject("reason","User found(Customer) see user session variable.");
                    }
                    // user to be passed in sessions
                    request.getSession().setAttribute("user", user);
                }
                else
                {
                    if(usm.get(auth.username) == null)
                    {
                        // user doesn't exists redirect to register page!
                        mv = new ModelAndView("register");
                        mv.addObject("status","FAILED");
                        mv.addObject("reason","User doesn't exists!");
                    }
                    else
                    {
                        // password wrong redirect to login page!
                        mv = new ModelAndView("index");
                        mv.addObject("status","FAILED");
                        mv.addObject("reason","Wrong Password!");
                    }
                }
            } catch (ClassNotFoundException ex) {
                mv = new ModelAndView("index");
                mv.addObject("status","FAILED");
                mv.addObject("reason","Connection Failed! Reason: " + ex.getMessage());
            }
            
        }
        return mv;
    }
    
    @RequestMapping(value = {"lg"})
    public @ResponseBody String getAvailable(@RequestParam("") Map<String,String> map)
    {
        ObjectMapper mapper = new ObjectMapper();
        if(map.get("checkin") == null ||
                map.get("checkout") == null ||
                map.get("type") == null ||
                map.get("checkin").isEmpty() ||
                map.get("checkout").isEmpty() ||
                map.get("type").isEmpty())
        {
            return null;
        }
        else
        {
            String checkin = DateFormatter.format(map.get("checkin"));
            String checkout = DateFormatter.format(map.get("checkout"));
            int type = Integer.parseInt(map.get("type"));
            try {
                RoomManager rman = new RoomManager(Datasource.getDatasource());
                List<Room> list = rman.list(type);
                if(list.isEmpty())
                {
                    try {
                        return mapper.writeValueAsString(list);
                    } catch (IOException ex) {
                        System.out.println(ex);
                        return null;
                    }
                }
                else
                {
                    List<Room> available = new ArrayList<>();
                    BookingManager man = new BookingManager(Datasource.getDatasource());
                    for (int i = 0; i < list.size(); i++) {
                        if(man.isAvailable(checkin, list.get(i).getRoomNumber()))
                        {
                            available.add(list.get(i));
                        }
                    }
                    
                    try {
                        return mapper.writeValueAsString(list);
                    } catch (IOException ex) {
                        System.out.println(ex);
                        return null;
                    }
                    
                }
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                return null;
            } 
        }
    }
    
}
