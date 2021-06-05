package src.com.samson;

import java.util.Date;

public abstract class CalendarEvent {
    Date eventDate;
    protected String name, description;
    boolean allDay;

    Reoccurence reoccurence;
    Date reoccurenceEndDate;
    Date getReoccurenceStartDate;

    protected CalendarEvent(String Name, Date eventDate){

    }
}
