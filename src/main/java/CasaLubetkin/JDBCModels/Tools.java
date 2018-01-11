/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasaLubetkin.JDBCModels;

import java.util.GregorianCalendar;

/**
 * This class has tools for the manipulation of the models
 * Creation date 11/01/2018.
 * Last Update 11/01/2018.
 * @author Gonzalez,Cristian.
 */
public class Tools {

    /**
     * Function that returns the difference in days between 2 dates.
     * @param date1 is the first date for the difference.
     * @param date2 It is the second date for the difference.
     * @return the difference in days between 2 dates.
     */
    
    public static int differenceOfDates(GregorianCalendar date1,GregorianCalendar date2){
        long difms = date2.getTimeInMillis() - date1.getTimeInMillis();
        long difd = difms / (1000 * 60 * 60 * 24);
        return (int) Math.abs(difd);
    }
}
