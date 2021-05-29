package src.com.samson;

/*
 Attributes

 - Name (First/Last Name)
 - Person Identifier Id (UUID/GUID)
*/
public class Person {
    //public -> All access from any class or methods
    //private -> Restricted to the current class
    //protected -> Only accessible by current class and child class
    
    // hidden class members
    private String firstName, lastName;
    private String id;

    // Constructor
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = firstName + lastName;
    }

    // getter and setters

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getId(){
        return this.id;
    }
}
