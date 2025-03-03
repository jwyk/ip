package bob.parser;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * Handles the parsing and printing of dates to the Deadline and Event Classes.
 *
 */
public class DateParser {

    /**
     * Returns a LocalDateTime object from a string containing date and time.
     * <p>
     * This function will fail if the string doesn't contain the correct format
     * <p>
     * DateTime Format: YYYY/MM/dd HHmm (Year/Month/Day 24Hr Time)
     *
     * @param dateTime The string containing the date and time.
     * @return LocalDateTime object.
     */
    public static LocalDateTime getDate(String dateTime){

        //Pattern: YYYY/MM/dd HHmm
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HHmm");

        if (isValidFormat(dateTime,dateTimeFormatter)) {
            try {
                return LocalDateTime.parse(dateTime,dateTimeFormatter);
            } catch (DateTimeException e) {
                System.out.println("Date Time Error");
                return null;
            }
        } else {
            return null;
        }
    }


    /**
     * Returns a formatted string from a LocalDateTime object
     * <p>
     * DateTime Format: MMM d YYYY HHmm (Month Day Year 24Hr Time)
     *
     * @param dateTime The LocalDateTime containing the date and time.
     * @return Formatted string
     */
    public static String printDate(LocalDateTime dateTime) {

        return dateTime.format(DateTimeFormatter.ofPattern("MMM d yyyy HHmm"));
    }

    /**
     * Checks if a string matches the given DateTimeFormatter pattern.
     *
     * @param dateTime The string to check.
     * @param formatter  The DateTimeFormatter with the desired pattern.
     * @return true if the string matches the format, false otherwise.
     */
    public static boolean isValidFormat(String dateTime, DateTimeFormatter formatter) {
        try {
            LocalDateTime.parse(dateTime, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
