/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.eset2.web.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Helper class to have quick access to formated timestamps of current time.
 * @author Mischa Wenger
 */
public class DateConverter {

    
    /**
     * Converts milliseconds into the format: dd.mm.yyyy HH:mm:ss.
     * @param timeInMillis since 1970 passed
     * @return formated date.
     */
    public static String longToString(long timeInMillis) {
        Date date = new Date(timeInMillis);
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return formatter.format(date);
    }
    
    /**
     * Provides current time formated as a string: dd.mm.yyyy HH:mm:ss
     * @return the current date and time
     */
    public static String currentTimeAsString(){
        return longToString(System.currentTimeMillis());
    }
}
