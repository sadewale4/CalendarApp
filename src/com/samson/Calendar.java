package src.com.samson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
}
