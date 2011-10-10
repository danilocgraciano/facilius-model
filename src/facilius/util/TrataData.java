package facilius.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Graciano
 */
public class TrataData {

    public static final String MASCARA_DATA_BD = "yyyy-MM-dd";
    public static final String MASCARA_DATA = "dd/MM/yyyy";

    public static java.util.Date stringToDate(String str) throws ParseException {
        if (str == null || str.trim().isEmpty())
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(MASCARA_DATA);
        return formatter.parse(str);
    }

    public static String dateToString(java.util.Date date) {
        return dateToString(date, MASCARA_DATA);
    }
    public static String dateToString(java.util.Date date, String mask) {
        if (date == null || mask == null || mask.trim().isEmpty())
            return null;
        SimpleDateFormat formatter = new SimpleDateFormat(mask);
        return formatter.format(date);
    }

    public static String dateToStringDB(java.util.Date date) {
        return dateToString(date,MASCARA_DATA_BD);
    }
}
