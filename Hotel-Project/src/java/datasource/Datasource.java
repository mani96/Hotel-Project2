
package datasource;

import java.sql.Driver;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

/**
 *
 * @author Anirudh
 */
public class Datasource {

    /**
     * Simple Driver DataSource connection variable
     */
    protected static SimpleDriverDataSource ds;
    private static int count = 0;
    
    /**
     * This method provides you the DataSource object for all the connections<br>
     * It will be required by almost all dao objects.
     * @return DataSource object
     * @throws ClassNotFoundException
     */
    public static DataSource getDatasource() throws ClassNotFoundException
    {
        if(count == 0)
        {
            String driverClassName = "com.mysql.jdbc.Driver";
            ds = new SimpleDriverDataSource();
            ds.setDriverClass((Class<Driver>) Class.forName(driverClassName));
            ds.setUrl(new ConnectionBuilder()
                    .setPort(3006)
                    .setHost("anirudh.ddns.net")
                    .setDatabase("hotel")
                    .setProtocol("jdbc:mysql")
                    .build().toString());
            ds.setUsername(Connection.getUSERNAME());
            ds.setPassword(Connection.getPASSWORD());
            count++;
            return ds;
        }
        else
        {
            return ds;
        }
    }
    
}
