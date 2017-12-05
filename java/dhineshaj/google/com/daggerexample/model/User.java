package dhineshaj.google.com.daggerexample.model;

/**
 * Created by Dhinesh AJ on 05-12-2017.
 */

public class User {
    private String firstName, lastName;

    public User(){
      // Default Constructor, it is necessary
    }

    public User(String firstName, String lastName){

        // Parametrized Constructor
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    // Setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getName(){

        return firstName+" "+lastName;
    }

}
