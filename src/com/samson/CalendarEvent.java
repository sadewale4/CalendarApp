package src.com.samson;

import java.util.Date;

public abstract class CalendarEvent {
    Date eventDate;
    protected String name, description;
    protected boolean allDay;

    Reoccurence reoccurence;
    Date reoccurenceEndDate;
    Date getReoccurenceStartDate;

    protected CalendarEvent(String name, Date eventDate){
        this.name = name;
        this.eventDate = eventDate;
    }
}
