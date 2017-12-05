package dhineshaj.google.com.daggerexample.presenter;

import javax.inject.Inject;

import dhineshaj.google.com.daggerexample.Contract;
import dhineshaj.google.com.daggerexample.model.User;

/**
 * Created by Dhinesh AJ on 05-12-2017.
 *
 * Presenter connects View and Model
 */

public class Presenter implements Contract.Presenter {

    private User user;
    private Contract.View view;

    @Inject
    public Presenter(User user, Contract.View view){

        this.user = user;
        this.view = view;
    }

    @Override
    public void loadMessage() {

        if(user.getFirstName()== null && user.getLastName()== null){

            view.showError("No User");
            return;
        }

        String messsage = "Hi "+user.getName()+" !";

        view.showMessage(messsage);
    }

    @Override
    public void saveName(String firstName, String lastName) {

        user.setFirstName(firstName);
        user.setLastName(lastName);

    }
}
