package src.com.samson;

import java.util.List;

public class StartEndDateValidator extends BaseValidation{
    public ValidationResult validate(List<CalendarMeeting> meetings, CalendarMeeting newMeeting) {
        String message = null;
        ValidationState state = ValidationState.Success;

        for(int i = 0; i < meetings.size(); i++){
            CalendarMeeting meeting = meetings.get(i);
            //If the new meeting enddate > previousmeeting startdate AND new meeting enddate < previousmeeting enddate, then the end date of the new meeting is in between
            boolean endDateInBetween = newMeeting.getEndDate().after(meeting.getStartDate()) && newMeeting.getEndDate().before(meeting.getEndDate());

            //if the new meeting startdate > previous meeting startdate AND new meeting startdate < previousmeeting endate, then the start date of the new meeting is in between
            boolean startDateInBetween = newMeeting.getStartDate().after(meeting.getStartDate()) && newMeeting.getStartDate().before(meeting.getEndDate());

            //If both start and end dates overlap perfectly
            boolean dateOverlap = newMeeting.getStartDate().equals(meeting.getStartDate()) && newMeeting.getEndDate().equals(meeting.getEndDate());

            if(endDateInBetween || startDateInBetween || dateOverlap){
                state = ValidationState.Conflict;
                message = "There is a conflict between this meeting and another meeting in your calendar";
                break;

            }
        }

        return new ValidationResult(state, message);
    }
}
