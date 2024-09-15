package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    // Format for date and time (e.g., 2024-08-24 15:30)
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    /**
     * Get the current date and time in the format yyyy-MM-dd HH:mm.
     *
     * @return the current date and time as a string
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DATE_TIME_FORMAT);
    }

}
