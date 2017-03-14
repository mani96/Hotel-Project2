/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

/**
 *
 * @author Anirudh
 */
public class ConnectionBuilder implements IConnBuilder{
    
    private Connection connection;
        
    public ConnectionBuilder()
    {
        connection = new Connection();
    }
    
    @Override
    public ConnectionBuilder setProtocol(String protocol) {
        connection.setProtocol(protocol);
        return this;
    }

    @Override
    public ConnectionBuilder setHost(String host) {
        connection.setHost(host);
        return this;
    }

    @Override
    public ConnectionBuilder setDatabase(String database) {
        connection.setDatabase(database);
        return this;
    }

    @Override
    public Connection build() {
        return this.connection;
    }

    @Override
    public ConnectionBuilder setPort(int port) {
        connection.setPort(port);
        return this;
    }
    
}
