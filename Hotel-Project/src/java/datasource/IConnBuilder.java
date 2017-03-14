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
public interface IConnBuilder {
    ConnectionBuilder setHost(String host);
    ConnectionBuilder setProtocol(String protocol);
    ConnectionBuilder setDatabase(String datbase);
    ConnectionBuilder setPort(int port);
    Connection build();
}
