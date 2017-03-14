
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

    public RestaurantManager(DataSource dataSource) {
        TEMP = new JdbcTemplate(dataSource);
        INSERT = "INSERT INTO MENU_ITEMS(ID, NAME, DESCRIPTION, PRICE, SERVES) VALUES (?, ? , ? , ? , ? )";
        UPDATE = "UPDATE MENU_ITEMS SET NAME=?,DESCRIPTION=?,PRICE=?,SERVES=? WHERE ID=?";
        SELECT_ALL = "SELECT * FROM MENU_ITEMS";
        GET = "SELECT * FROM MENU_ITEMS WHERE ID = ";
        DELETE = "DELETE FROM MENU_ITEMS WHERE ID = ?";
    }

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

    public List<Object> list() {
        List<Object> listSub = TEMP.query(this.SELECT_ALL, (ResultSet rs, int rowNum) -> {
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

    public Object get(int id) {
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
