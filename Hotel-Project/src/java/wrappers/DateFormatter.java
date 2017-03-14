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
public class DateFormatter {
    
    public static String format(String date)
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
    
}
