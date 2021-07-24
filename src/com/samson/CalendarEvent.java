package src.com.samson;

import java.util.Date;

public abstract class CalendarEvent {
    protected Date eventDate;
    protected String name, description;
    protected boolean allDay;

    protected Reoccurence reoccurence;
    protected Date reoccurenceEndDate;
    protected Date getReoccurenceStartDate;

    protected CalendarEvent(String name, Date eventDate){
        this.name = name;
        this.eventDate = eventDate;
    }

    public boolean isAllDay() {
        return allDay;
    }
}
