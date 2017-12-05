package dhineshaj.google.com.daggerexample;

import dagger.Module;
import dagger.Provides;
import dhineshaj.google.com.daggerexample.model.User;

/**
 * Created by Dhinesh AJ on 05-12-2017.
 *
 * Provides dependencies
 */

@Module
public class PresenterModule {

    private final Contract.View view;

    private final User user;

    public PresenterModule(Contract.View view, User user) {
        this.view = view;
        this.user = user;
    }

    @Provides
    Contract.View provideContractView() {
        return view;
    }

    @Provides
    User provideUser() {
        return user;
    }
}
