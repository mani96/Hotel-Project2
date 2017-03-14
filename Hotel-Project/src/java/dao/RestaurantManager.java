
package dao;

import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import wrappers.Item;
/**
 *
 * @author Anirudh
 */
public class RestaurantManager {

    private final JdbcTemplate TEMP;
    private final String INSERT;
    private final String UPDATE;
    private final String SELECT_ALL;
    private final String GET;
    private final String DELETE;

    /**
     * Constructor for the object
     * @param dataSource, DataSource required! You many get that object using the static method available in DataSource class
     */
    public RestaurantManager(DataSource dataSource) {
        TEMP = new JdbcTemplate(dataSource);
        INSERT = "INSERT INTO MENU_ITEMS(ID, NAME, DESCRIPTION, PRICE, SERVES) VALUES (?, ? , ? , ? , ? )";
        UPDATE = "UPDATE MENU_ITEMS SET NAME=?,DESCRIPTION=?,PRICE=?,SERVES=? WHERE ID=?";
        SELECT_ALL = "SELECT * FROM MENU_ITEMS";
        GET = "SELECT * FROM MENU_ITEMS WHERE ID = ";
        DELETE = "DELETE FROM MENU_ITEMS WHERE ID = ?";
    }

    /**
     * This method accepts a Item object that it then uses to insert or update existing one into database
     * @param obj,An object of Item Class! Providing any other object will always return false
     * @return action success boolean
     */
    public Boolean saveOrUpdate(Object obj) {
        if (obj instanceof Item) // object is correct one i.e. it is an item since this class only deals with items!
        {
            Item i = (Item) obj;
            if(this.get(i.getId()) == null)
            {
                // item is new and doesn't exist
                //adding new object using insert
               try
               {
                   TEMP.update(this.INSERT, i.getId(), i.getName(), i.getDescription(), i.getPrice(), i.getServes());
                   return true;
               }
               catch(DataAccessException ex)
               {
                   return false;
               }
            }
            else
            {
                // item is old but requires update
                // placing the new object instead of old one
               try
               {
                   TEMP.update(this.UPDATE, i.getName(), i.getDescription(), i.getPrice(), i.getServes(), i.getId());
                   return true;
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

    /**
     * This returns you the list of all the items
     * @return A list of all items available.
     */
    public List<Item> list() {
        List<Item> listSub = TEMP.query(this.SELECT_ALL, (ResultSet rs, int rowNum) -> {
            Item item = new Item();
            item.setId(rs.getInt("ID"));
            item.setDescription(rs.getString("DESCRIPTION"));
            item.setName(rs.getString("NAME"));
            item.setPrice(rs.getDouble("PRICE"));
            item.setServes(rs.getInt("SERVES"));
            return item;
        });
        return listSub;
    }

    /**
     * This method allows you to delete an item entry record from the database
     * @param id,Item ID for which the data will be removed.
     * @return action success boolean
     */
    public Boolean delete(int id) {
        try
        {
            TEMP.update(this.DELETE, id);
            return true;
        }
        catch(DataAccessException ex)
        {
            return false;
        }
    }

    /**
     * This gets you the item based on the item id provided
     * @param id, Item ID that is provided
     * @return item object with all the details
     */
    public Item get(int id) {
        String query = this.GET + id;
        return TEMP.query(query , (ResultSet rs) -> {
            if (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("ID"));
                item.setDescription(rs.getString("DESCRIPTION"));
                item.setName(rs.getString("NAME"));
                item.setPrice(rs.getDouble("PRICE"));
                item.setServes(rs.getInt("SERVES"));
                return item;
            }
            return null;
        });
    }

    /**
     * This method checks for the presence of that item in the menu.
     * @param id item id to search for
     * @return boolean to confirm if the item exists
     */
    public Boolean itemExists(int id) {
        String query = this.GET + id;
        Item i =  TEMP.query(query , (ResultSet rs) -> {
            if (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("ID"));
                item.setDescription(rs.getString("DESCRIPTION"));
                item.setName(rs.getString("NAME"));
                item.setPrice(rs.getDouble("PRICE"));
                item.setServes(rs.getInt("SERVES"));
                return item;
            }
            return null;
        });
        return i != null;
    }

}
