package src.com.samson;

public class ValidationResult {
    protected ValidationState state;
    protected String message;

    //Constructure
    public ValidationResult(ValidationState state, String message){
        this.state = state;
        this.message = message;
    }

    public ValidationState getState() {

        return state;
    }

    public String getMessage() {

        return message;
    }
}
