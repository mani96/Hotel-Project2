/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import datasource.Datasource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import wrappers.Booking;
import wrappers.DateUtil;
import wrappers.Room;
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

    /**
     * Constructor for the object
     *
     * @param dataSource, DataSource required! You many get that object using
     * the static method available in DataSource class
     */
    public BookingManager(DataSource dataSource) {
        TEMP = new JdbcTemplate(dataSource);
        INSERT = "INSERT INTO BOOKINGS(BOOKING_ID,USERNAME, ROOM_NUMBER, START_DATE, END_DATE, SPECIAL_NOTES) VALUES (?, ?, ?, ?, ?, ?)";
        UPDATE = "UPDATE BOOKINGS SET USERNAME=?,ROOM_NUMBER=?,START_DATE=?,END_DATE=?,SPECIAL_NOTES=? WHERE BOOKING_ID=?";
        SELECT_ALL = "SELECT * FROM BOOKINGS";
        GET = "SELECT * FROM BOOKINGS WHERE";
        DELETE = "DELETE FROM BOOKINGS WHERE BOOKING_ID=?";
    }

    public List<Booking> customQuery(String query) {
        List<Booking> bookings = TEMP.query(query, new RowMapper<Booking>() {
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
        return bookings;
    }

    /**
     * This gets you the bookings making a search using a specific field for
     * example( BOOKING_ID, USERNAME, START_DATE)
     *
     * @param s, Search that defines the specified field to search on.
     * @param value, Value to search for in the table.
     * @return First entry record in the database
     */
    public List<Booking> get(Search s, Object value) {
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
            case "ROOM_NUMBER":
                query += value;
                break;
            default:
                break;
        }

        List<Booking> bookings = TEMP.query(query, new RowMapper<Booking>() {
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
        return bookings;
    }

    /**
     * This returns you the list of all the bookings
     *
     * @return A list of Bookings available.
     */
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

    /**
     * This method allows you to delete a booking entry record from the database
     *
     * @param bookingID, Booking ID for which the data will be removed.
     * @return action success boolean
     */
    public Boolean delete(int bookingID) {
        try {
            return TEMP.update(this.DELETE, bookingID) == 1;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    /**
     * This method accepts a Booking object that it then uses to insert into
     * database.
     *
     * @param obj, An object of Booking Class! Providing any other object will
     * always return false
     * @return action success boolean
     */
    public boolean doBooking(Object obj) throws ClassNotFoundException {
        if (obj instanceof Booking) // object is correct one i.e. it is a room since this class only deals with rooms!
        {
            Booking b = (Booking) obj;
            if (b.getBooking_id() == -99 || this.get(Search.BOOKING_ID, b.getBooking_id())
                    == null) {

                if (b.getBooking_id() == -99) {
                    b.setBooking_id(getLastBookingNumber() + 1);
                }

                try {
                    return TEMP.update(this.INSERT,
                            b.getBooking_id(), b.getUsername().toUpperCase(), b.getRoom_number(), b.getStart_date(), b.getEnd_date(), b.getSpecial_notes()) == 1;
                } catch (DataAccessException ex) {
                    return false;
                }
            } else {

                //this is code for checking availability
                RoomManager rm = new RoomManager(Datasource.getDatasource());
                Room room = rm.get(b.getRoom_number());

                List<Room> rooms = this.getAvailableRoom(b.getStart_date(), b.getEnd_date(), room.getGuests());

                if (!rooms.contains(room)) {
                    return false;
                }
                //end of checking availible rooms 
                
                try {
                    return TEMP.update(this.UPDATE,
                            b.getUsername(), b.getRoom_number(), b.getStart_date(), b.getEnd_date(), b.getSpecial_notes(), b.getBooking_id()) == 1;
                } catch (DataAccessException ex) {
                    return false;
                }

            }
        } else //object isn't correct!
        {
            return false;
        }
    }

    /**
     * This provides the ID for the last booking number. This must never be used
     * anywhere other than this class
     *
     * @return last BookingID
     */
    private int getLastBookingNumber() {
        return TEMP.query("SELECT MAX(BOOKING_ID)FROM BOOKINGS", (ResultSet rs) -> {
            if (rs.next()) {
                return rs.getInt("MAX(BOOKING_ID)");
            }
            return 0;
        });
    }

    /**
     * This method gets all the available room for specific number of guests
     *
     * @param startDate
     * @param guests
     * @param endDate
     * @return
     */
    public List<Room> getAvailableRoom(String startDate, String endDate, int guests) {
        String query = "SELECT * FROM ROOMS WHERE GUESTS = " + guests + " AND ROOM_NUMBER NOT IN (SELECT ROOM_NUMBER FROM BOOKINGS WHERE BOOKINGS.START_DATE = \"" + startDate + "\")";

        List<Room> list = TEMP.query(query, new RowMapper<Room>() {
            @Override
            public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
                Room r = new Room();
                r.setGuests(rs.getInt("GUESTS"));
                r.setFridge(rs.getBoolean("FRIDGE"));
                r.setTV(rs.getBoolean("TV"));
                r.setWiFi(rs.getBoolean("WIFI"));
                r.setPackageID(rs.getInt("PACKAGE_ID"));
                r.setPackageID(rs.getInt("PACKAGE_ID"));
                r.setPrice(rs.getDouble("PRICE"));
                r.setRoomNumber(rs.getInt("ROOM_NUMBER"));
                return r;
            }
        });

        for (int i = 0; i < list.size(); i++) {
            List<Booking> bks = this.get(Search.ROOM_NUMBER, list.get(i).getRoomNumber());
            for (Booking bk : bks) {
                if (DateUtil.isBetween(startDate, bk.getStart_date(), bk.getEnd_date())
                        || // if my start date is between booking start date and booking enddate
                        DateUtil.isBetween(endDate, bk.getStart_date(), bk.getEnd_date())
                        || // if my end date is between booking start date and booking enddate
                        DateUtil.isBetween(bk.getStart_date(), startDate, endDate)
                        || DateUtil.isBetween(bk.getEnd_date(), startDate, endDate)) {
                    list.remove(i);
                }
            }
        }
        return list;

    }

}
