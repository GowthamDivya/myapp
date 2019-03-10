package edr.bhanuinfosystems.com.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edr.bhanuinfosystems.com.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doclogin(View view) {
        Intent i = new Intent(this,Doctor_login.class);
        startActivity(i);
    }

    public void patlogin(View view) {
    }
}
