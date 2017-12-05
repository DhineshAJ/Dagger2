package dhineshaj.google.com.daggerexample;

/**
 * Created by Dhinesh AJ on 05-12-2017.
 *
 * Helps us track the relationship between the View and the Presenter in a central place.
 */

public interface Contract {

    // Nested interface

    //Represents the View in MVP.

    interface View{

        void  showMessage(String message);

        void  showError(String error);

    }

    // Represents the Presenter in MVP.

    interface Presenter{

        void loadMessage();

        void saveName(String firstName, String lastName);
    }
}
