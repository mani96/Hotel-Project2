/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wrappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anirudh
 */
public class DateUtil {
    
    public static String parseToDbFormat(String date)
    {
        try
        {
            Date d = new SimpleDateFormat("MM/dd/yyyy").parse(date);
            return new SimpleDateFormat("yyyy-MM-dd").format(d);
        }
        catch(ParseException ex)
        {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
    }
    
    public static String parseToCanFormat(String date)
    {
        try
        {
            Date d = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            return new SimpleDateFormat("MM/dd/yyyy").format(d);
        }
        catch(ParseException ex)
        {
            return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
    }
    
    public static boolean isAfter(String firstDate, String secondDate)
    {
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(secondDate);
            return !(new Date().after(start) || end.before(new Date()) || end.before(start) || start.equals(end));
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static boolean isBefore(String firstDate, String secondDate)
    {
        try {
            Date start = new SimpleDateFormat("yyyy-MM-dd").parse(firstDate);
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(secondDate);
            return (new Date().after(start) || end.before(new Date()) || end.before(start) || start.equals(end));
        } catch (ParseException e) {
            return false;
        }
    }
    
    public static boolean isBetween(String checkDate, String startDate, String endDate)
    {
        if(isBefore(checkDate,startDate) && isAfter(checkDate,endDate))
        {
            return true;
        }
        return false;
    }
    
}
