package dhineshaj.google.com.daggerexample;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import javax.inject.Inject;

import dhineshaj.google.com.daggerexample.model.User;
import dhineshaj.google.com.daggerexample.presenter.Presenter;

/**
 * Created by Dhinesh AJ on 05-12-2017.
 *
 * MainActivity is the View
 */

public class MainActivity extends AppCompatActivity implements Contract.View, View.OnClickListener {

    @Inject
    Presenter presenter;


    private EditText firstNameView;
    private EditText lastNameView;
    private LinearLayout linearLayout;
    private String fname, lname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        // Creates presenter
        DaggerComponents.builder()
                .presenterModule(new PresenterModule(this, new User()))
                .build()
                .inject(this);


    }

    private void initViews() {

        // EditText box
        firstNameView = (EditText) findViewById(R.id.firstname);
        lastNameView = (EditText) findViewById(R.id.lastname);

        // Buttons
        findViewById(R.id.savebtn).setOnClickListener(this);
        findViewById(R.id.userbtn).setOnClickListener(this);

        //Layout
        linearLayout = (LinearLayout)findViewById(R.id.linearlayout);


    }

    @Override
    public void showMessage(String message) {

        Snackbar snackbar = Snackbar
                .make(linearLayout, message, Snackbar.LENGTH_LONG)
                .setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });

        snackbar.show();
    }

    @Override
    public void showError(String error) {

        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();

    }

    // Button action
    public void onClick(View view){

        switch (view.getId()) {
            //Save Button
            case R.id.savebtn:
                fname = firstNameView.getText().toString();
                lname = lastNameView.getText().toString();

                // EditText box not empty check condition
                if(!fname.matches("") && !lname.matches("")){

                    presenter.saveName(fname,lname );
                    Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();

                }
                else {

                    showError("Fields cannot be Empty");
                }
                break;

                // User Button
            case R.id.userbtn:
                presenter.loadMessage();
                break;
        }
    }
}
