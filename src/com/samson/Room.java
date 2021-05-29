package src.com.samson;

/*

- Room Id (Can be same as Name)
- Access Control (Allow list of people able to book room)
- Max Occupancy
- Name
- Location (Etc. Building #2, Virtual)
*/
public class Room {
    
    private String name, id;
    // Comma delimited list of people that have access to room (bookable)
    private String acl; 

    private Locations location;

    // Constructor
    public Room(String name, Locations location) {
        this.name = name;
        this.id = name;
        this.location = location;
    }


    // getter and setter

    public void setAcl(String acl) {
        this.acl = acl;
    }

    public String getAcl(){
        return this.acl;
    }

    public String getName(){
        return this.name;
    }

    public String getId(){
        return this.id;
    }

    public Locations getLocations(){
        return this.location;
    }
}
