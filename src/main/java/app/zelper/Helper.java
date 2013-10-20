package app.zelper;

import java.util.Date;

public class Helper {

    public static Integer toInteger(String string, Integer deff) {
        Integer value = deff;
        try {
            
            if (string != null) {
                value = Integer.valueOf(string.toString());
            }
            
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return value;

    }
    
    public static java.sql.Date getSQLDate(Date date){
        
        return new java.sql.Date(date.getTime());
                
        
        
    }
}
