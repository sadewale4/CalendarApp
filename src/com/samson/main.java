package src.com.samson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class Program {

    static SimpleDateFormat formatter = new SimpleDateFormat("M-dd-yyyy hh:mm:ss a", Locale.ENGLISH);


    static{
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
    }

    public static void main(String[] args) throws ParseException {
        CalendarDataStore.getInstance().setDefaultContact("Sam");
        CalendarDataStore.getInstance().registerCalendar("Sam");
        CalendarDataStore.getInstance().registerCalendar("TJ");
        CalendarDataStore.getInstance().registerCalendar("Frank");
        //testConflict();
        testOverride();
    }

    public static void testConflict() throws ParseException {
        Calendar calendar = CalendarDataStore.getInstance().getDefault();
        ValidationResult result1 = calendar.addMeeting(new CalendarMeeting("Meeting 1", formatter.parse("01-22-2015 10:00:00 AM"),
                formatter.parse("01-22-2015 11:00:00 AM")));

        ValidationResult result2 = calendar.addMeeting(new CalendarMeeting("Meeting 2", formatter.parse("01-22-2015 11:00:00 AM"),
                formatter.parse("01-22-2015 01:00:00 PM")));

        ValidationResult result3 = calendar.addMeeting(new CalendarMeeting("Meeting 3", formatter.parse("01-22-2015 01:00:00 PM"),
                formatter.parse("01-22-2015 02:00:00 PM"), true));

        ValidationResult result4 = calendar.addMeeting(new CalendarMeeting("Meeting 4", formatter.parse("01-22-2015 01:00:00 PM"),
                formatter.parse("01-22-2015 02:00:00 PM"), true));

        System.out.println(String.format("Meetings should be %d equals 3", calendar.getMeetings().size()));
        System.out.println(String.format("Meeting 4 should conflict with meeting 3: %s", result4.getState()));
    }

    public static void testOverride() throws ParseException{
        Calendar calendar = CalendarDataStore.getInstance().getDefault();
        ValidationResult result1 = calendar.addMeeting(new CalendarMeeting("Meeting 1", formatter.parse("01-22-2015 10:00:00 AM"),
                formatter.parse("01-22-2015 11:00:00 AM")));

        ValidationResult result2 = calendar.addMeeting(new CalendarMeeting("Meeting 2", formatter.parse("01-22-2015 11:00:00 AM"),
                formatter.parse("01-22-2015 01:00:00 PM")));

        ValidationResult result3 = calendar.addMeeting(new CalendarMeeting("Meeting 3", formatter.parse("01-22-2015 01:00:00 PM"),
                formatter.parse("01-22-2015 02:00:00 PM")));

        ValidationResult result4 = calendar.addMeeting(new CalendarMeeting("Meeting 4", formatter.parse("01-22-2015 01:00:00 PM"),
                formatter.parse("01-22-2015 02:00:00 PM")), true);

        System.out.println(String.format("Meetings should be %d equals 4", calendar.getMeetings().size()));
        System.out.println(String.format("Meeting 4 should conflict with meeting 3: %s message= %s", result4.getState(), result4.getMessage()));
    }

}