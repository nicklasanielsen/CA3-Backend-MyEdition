package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nicklas Nielsen
 */
public class MyTimeStamp {

    private final String TIME_STAMP;

    public MyTimeStamp() {
        TIME_STAMP = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").format(new Date());
    }

    public String getTimeStamp() {
        return TIME_STAMP;
    }

}
