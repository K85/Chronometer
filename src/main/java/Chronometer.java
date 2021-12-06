import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Data
public class Chronometer {

    private Calendar startTime;
    private Calendar stopTime;

    public Calendar start() {
        return this.startTime = Calendar.getInstance();
    }

    public Calendar stop() {
        return this.stopTime = Calendar.getInstance();
    }

    public void reset() {
        this.startTime = null;
        this.stopTime = null;
    }

    public static String getTimeString(Calendar calendar) {
        return SimpleDateFormat.getTimeInstance(SimpleDateFormat.MEDIUM).format(calendar.getTime());
    }

}
