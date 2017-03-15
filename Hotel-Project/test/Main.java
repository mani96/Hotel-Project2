
import wrappers.DateUtil;





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
    public static void main(String[] args) {
        
        System.out.println(DateUtil.isBetween("2017-03-11","2017-03-15","2017-03-18")); // false
        System.out.println(DateUtil.isBetween("2017-03-14","2017-03-15","2017-03-18")); // false
        System.out.println(DateUtil.isBetween("2017-03-17","2017-03-15","2017-03-18")); // true
        System.out.println(DateUtil.isBetween("2017-03-18","2017-03-15","2017-03-18")); // false
        System.out.println(DateUtil.isBetween("2017-03-19","2017-03-15","2017-03-18")); // false
        System.out.println(DateUtil.isBetween("2017-07-17","2017-03-15","2017-03-18")); // false
        
        
    }
}
