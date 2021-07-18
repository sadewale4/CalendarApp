package src.com.samson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalendarMeeting extends CalendarEvent{
    protected MeetingRoom room;
    protected List<Contact> meetingAttendees;
    protected Date endDate;

    //Constructor
    protected CalendarMeeting(String name, Date startDate) {
        super(name, startDate);
    }

    //
    public CalendarMeeting(String name, Date startDate, Date endDate){
        super(name, startDate);
        this.endDate = endDate;
        this.meetingAttendees = new ArrayList<>();
    }

    public Date getEndDate() {
        return endDate;
    }

    /**
     * Returns the start date for the meeting
     * @return {@link Date}
     */
    public Date getStartDate() {
        return eventDate;
    }

    /**
     * Updates start sate for meeting
     * @param startDate start date
     */
    public void setStartDate(Date startDate) {
        this.eventDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CalendarMeeting{" +
                "Name=" + this.name +
                ", Room=" + room +
                ", StartDate=" + this.getStartDate() +
                ", EndDate=" + this.getEndDate() +
                ", meetingAttendees=" + meetingAttendees +
                '}';
    }

    //getter and setter
}
