
package datasource;

import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 *
 * @author Anirudh
 */
public class Datasource {
    protected static SimpleDriverDataSource ds;
    private static int count = 0;
    
    public static DataSource getDatasource() throws ClassNotFoundException
    {
        if(count == 0)
        {
            String driverClassName = "com.mysql.jdbc.Driver";
            ds = new SimpleDriverDataSource();
            ds.setDriverClass((Class<Driver>) Class.forName(driverClassName));
            ds.setUrl("jdbc:mysql://anirudh.ddns.net:3306/hotel");
            ds.setUsername("hotel");
            ds.setPassword("dirtyhotel");
            count++;
            return ds;
        }
        else
        {
            return ds;
        }
    }
    
}
