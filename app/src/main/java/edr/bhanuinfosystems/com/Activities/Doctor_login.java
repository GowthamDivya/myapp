package edr.bhanuinfosystems.com.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edr.bhanuinfosystems.com.R;

public class Doctor_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);
    }

    public void dochome(View view) {

        Intent i = new Intent(this,Doctor_Home.class);
        startActivity(i);
    }

    public void docreg(View view) {
        Intent j = new Intent(this,Doctor_Register.class);
        startActivity(j);
    }
}
