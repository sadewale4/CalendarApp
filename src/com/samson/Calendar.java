package src.com.samson;

import java.util.*;

/*
Features

- Schedule a meeting between one or more individual
- Resolving calender conflict
- Finding best time that works for selected group of individual
- Canceling of meeting
- Reschedule meeting to a different time (While taking into account of existing meetings)
- Booking rooms (Finding available room)
- Scheduling meeting against calendar with consideration for time off and vacations.
- State management of meeting (Busy, Free, Available, Out of Office)
*/

public class Calendar {

    protected List<CalendarMeeting> meetings;
    protected List<CalendarHoliday> holidays;
    protected List<CalendarReminder> reminders;
    protected List<CalendarBirthday> birthdays;
    protected CalendarAddressBook addressBook;
    protected StartEndDateValidator startEndDateValidator;

    //Constructor
    public Calendar(){
        meetings = new ArrayList<>();
        holidays = new ArrayList<>();
        startEndDateValidator = new StartEndDateValidator();
    }

    /**
    * Add new meeting
    * @param meeting new meeting to add to calendar
     */

    public ValidationResult addMeeting(CalendarMeeting meeting, boolean override){
        //validate meeting for time conflict
        List<CalendarMeeting> meetings = new ArrayList<>();
        meetings.addAll(this.meetings);

        // Create a Meeting.getattendees
        for(Contact contact : meeting.meetingAttendees){
            //call data store to get contact meeting by contact ID and add it to meeting list
            Calendar calendar = CalendarDataStore.getInstance().getCalendar(contact.getId());
            if(calendar != null){
                meetings.addAll(calendar.getMeetings(meeting.getStartDate(), meeting.getEndDate()));
            }
        }

        ValidationResult result = startEndDateValidator.validate(meetings, meeting);
        if (result.getState() == ValidationState.Success || override) {
            meetings.add(meeting);
        }

        return result;
    }

    //This is how you do method override
    public ValidationResult addMeeting(CalendarMeeting meeting){
        return addMeeting(meeting, false);
    }

    //Getter for meetings
    public List<CalendarMeeting> getMeetings() {
        return Collections.unmodifiableList(meetings);
    }

    //Getter for meetings
    public List<CalendarMeeting> getMeetings(Date startDate, Date endDate) {
        //To Do = Filter meeting that falls between the start and end date
        List<CalendarMeeting> meetings = new ArrayList<>();

        Date start = new Date(startDate.getYear(), startDate.getMonth(),startDate.getDate());
        Date end = new Date(endDate.getYear(), endDate.getMonth(), endDate.getDate(), 23, 59, 0);
        //Increase End date by Days Ahead
        //end = end

        for(CalendarMeeting meeting : this.meetings){
            //Logic for filtering for start (Draw it out prior to writing code)

            //Skip Conditions
            //If meeting startdate >= start & allday = true & end <= meeting enddate

            //Add Conditions
            //If meeting startdate >= start & allday = false & meeting enddate <= end



            meetings.add(meeting);
        }

        return Collections.unmodifiableList(meetings);
    }

}
