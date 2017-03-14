/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import wrappers.Booking;
import wrappers.Search;

/**
 *
 * @author Anirudh
 */
public class BookingManager {

    private final JdbcTemplate TEMP;
    private final String INSERT;
    private final String UPDATE;
    private final String SELECT_ALL;
    private final String GET;
    private final String DELETE;

    public BookingManager(DataSource dataSource) {
        TEMP = new JdbcTemplate(dataSource);
        INSERT = "INSERT INTO BOOKINGS(BOOKING_ID,USERNAME, ROOM_NUMBER, START_DATE, END_DATE, SPECIAL_NOTES) VALUES (?, ?, ?, ?, ?, ?)";
        UPDATE = "UPDATE BOOKINGS SET USERNAME=?,ROOM_NUMBER=?,START_DATE=?,END_DATE=?,SPECIAL_NOTES=? WHERE BOOKING_ID=?";
        SELECT_ALL = "SELECT * FROM BOOKINGS";
        GET = "SELECT * FROM BOOKINGS WHERE";
        DELETE = "DELETE FROM BOOKINGS WHERE BOOKING_ID=?";
    }

    public Booking get(Search s, Object value) {
        String query = this.GET + " " + s.toString() + "=";
        switch (s.toString()) {
            case "BOOKING_ID":
                query += value;
                break;
            case "USERNAME":
                query += "\'" + value + "\'";
                break;
            case "START_DATE":
                query += "\'" + value + "\'";
                break;
            default:
                break;
        }
        System.out.println(query);
        return TEMP.query(query, (ResultSet rs) -> {
            if (rs.next()) {
                Booking b = new Booking();
                b.setBooking_id(rs.getInt("BOOKING_ID"));
                b.setEnd_date(rs.getString("END_DATE"));
                b.setRoom_number(rs.getInt("ROOM_NUMBER"));
                b.setSpecial_notes(rs.getString("SPECIAL_NOTES"));
                b.setStart_date(rs.getString("START_DATE"));
                b.setUsername(rs.getString("USERNAME"));
                return b;
            }
            return null;
        });
    }
    
    public List<Booking> list() {
        List<Booking> list = TEMP.query(this.SELECT_ALL, new RowMapper<Booking>() {
            @Override
            public Booking mapRow(ResultSet rs, int rowNum) throws SQLException {
                Booking b = new Booking();
                b.setBooking_id(rs.getInt("BOOKING_ID"));
                b.setEnd_date(rs.getString("END_DATE"));
                b.setRoom_number(rs.getInt("ROOM_NUMBER"));
                b.setSpecial_notes(rs.getString("SPECIAL_NOTES"));
                b.setStart_date(rs.getString("START_DATE"));
                b.setUsername(rs.getString("USERNAME"));
                return b;
            }
        });
        return list;
    }
    
    public Boolean delete(int bookingID) {
        try
        {
            return TEMP.update(this.DELETE, bookingID) == 1;
        }
        catch(DataAccessException ex)
        {
            return false;
        }
    }
    public boolean doBooking(Object obj) {
        if (obj instanceof Booking) // object is correct one i.e. it is a room since this class only deals with rooms!
        {
            Booking b = (Booking) obj;
            if (b.getBooking_id() == -99 || this.get(Search.BOOKING_ID, b.getBooking_id()) 
                 == null){
                
               if (b.getBooking_id() == -99) {
                    b.setBooking_id(getLastBookingNumber() + 1);
                }

                try {
                    return TEMP.update(this.INSERT,
                            b.getBooking_id(), b.getUsername().toUpperCase(), b.getRoom_number(), b.getStart_date(), b.getEnd_date(), b.getSpecial_notes()) == 1;
                } catch (DataAccessException ex) {
                    return false;
                }
            }
            else
            {
                // item is old but requires update
                // placing the new object instead of old one
               try
               {
                   return TEMP.update(this.UPDATE, 
                           b.getUsername(), b.getRoom_number(), b.getStart_date(), b.getEnd_date(), b.getSpecial_notes(),b.getBooking_id()) == 1;
               }
               catch(DataAccessException ex)
               {
                   return false;
               }
                
            }
        } else //object isn't correct!
        {
            return false;
        }
    }

    public int getLastBookingNumber()
    {
        return TEMP.query("SELECT MAX(BOOKING_ID)FROM BOOKINGS", (ResultSet rs) -> {
            if (rs.next()) {
                return rs.getInt("MAX(BOOKING_ID)");
            }
            return 0;
        });
    }
    
}
