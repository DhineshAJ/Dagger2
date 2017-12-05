package dhineshaj.google.com.daggerexample;

/**
 * Created by Dhinesh AJ on 05-12-2017.
 *
 * Component connects dependency provider activity and dependency request activity (inject),
 */

import dagger.Component;

@Component(modules = PresenterModule.class)
public interface Components {


    void inject(MainActivity mainActivity);

}
