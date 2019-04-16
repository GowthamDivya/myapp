package edr.bhanuinfosystems.com.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edr.bhanuinfosystems.com.Activities.Admin.Admin_Login;
import edr.bhanuinfosystems.com.Activities.Doctor.Doctor_Register;
import edr.bhanuinfosystems.com.Activities.Doctor.Doctor_SignIn;
import edr.bhanuinfosystems.com.Activities.Examination.Add_Examination;
import edr.bhanuinfosystems.com.Activities.complaint.c_list;
import edr.bhanuinfosystems.com.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doclogin(View view) {
        Intent i = new Intent(this,Doctor_SignIn.class);
        startActivity(i);
    }

    public void patlogin(View view) {

    }

    public void admin_login(View view) {

        Intent i = new Intent(this, Admin_Login.class);
           startActivity(i);


    }
}
