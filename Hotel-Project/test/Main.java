
import dao.RoomManager;
import datasource.Datasource;







/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anirudh
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        RoomManager manage = new RoomManager(Datasource.getDatasource());
        System.out.println(manage.get(1));
    }
}
