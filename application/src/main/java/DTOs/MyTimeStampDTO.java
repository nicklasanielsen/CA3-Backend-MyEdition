package DTOs;

import entities.MyTimeStamp;

/**
 *
 * @author Nicklas Nielsen
 */
public class MyTimeStampDTO {

    private final String TIME_STAMP;

    public MyTimeStampDTO(MyTimeStamp myTimeStamp) {
        TIME_STAMP = myTimeStamp.getTimeStamp();
    }

    public String getTimeStamp() {
        return TIME_STAMP;
    }

}
