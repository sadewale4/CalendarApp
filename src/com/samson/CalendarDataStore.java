package src.com.samson;

import java.util.HashMap;
import java.util.Map;

public class CalendarDataStore {

    protected Map<String, Calendar> mapping;
    protected String defaultContact;

    private static CalendarDataStore instance;

    private CalendarDataStore(){
        mapping = new HashMap<>();
    }

    public Calendar getDefault(){
        return getCalendar(defaultContact);
    }

    public Calendar getCalendar(String contactID){
        Calendar calendar = null;
        if(mapping.containsKey(contactID)){
            calendar = mapping.get(contactID);
        }
        return calendar;
    }

    public boolean registerCalendar(String contactID){
        if(!mapping.containsKey(contactID)){
            mapping.put(contactID, new Calendar());
        }
        return true;
    }

    public void setDefaultContact(String defaultContact) {
        this.defaultContact = defaultContact;
    }

    public static CalendarDataStore getInstance(){
        if(instance == null){
            instance = new CalendarDataStore();
        }
        return instance;
    }

}
