
package app.utiles;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class utiles {
        public static Date stringToDate(String fecha) {
        DateFormat dateFormat =DateFormat.getDateInstance();
        Date date = null;

        try {
            date = dateFormat.parse(fecha);

        } catch (ParseException e) {
            System.out.println("ERROR: Formato de fecha incorrecta");

        } catch (Exception x) {
            
        } finally {
            return date;
        }

    }
}
