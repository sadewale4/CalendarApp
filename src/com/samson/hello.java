package src.com.samson;

import java.util.Date;

class Test {


    public static void main(String[] args) {
        Calendar calendar = new Calendar();
        calendar.addMeeting(new CalendarMeeting("Test Meeting", new Date(), new Date()));
        CalendarMeeting meeting = calendar.getMeetings().get(0);
        System.out.println(meeting);
        System.out.println(meeting.getStartDate());
    }
}