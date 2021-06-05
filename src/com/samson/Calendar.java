package src.com.samson;

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
}
