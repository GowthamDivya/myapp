package edr.bhanuinfosystems.com.Activities.Doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edr.bhanuinfosystems.com.Activities.Admin.Admin_Home;
import edr.bhanuinfosystems.com.Activities.Admin.Admin_Login;
import edr.bhanuinfosystems.com.Activities.Admin.Registered_doc_list;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;

public class Doctor_Home extends AppCompatActivity {
    Button logout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__home);
        logout= (Button)findViewById(R.id.doct_btn_logout);

        if (!SharedPrefManager.getInstance(this).docisLoggedIn()) {
            finish();
            startActivity(new Intent(this,Doctor_SignIn.class));
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).doclogout();



            }
        });


    }

    public void Add_reg(View view) {
        startActivity(new Intent(this,Add_Patient.class));

    }

    public void viewpat(View view) {


        Intent i = new Intent(Doctor_Home.this, pat_list.class);
        startActivity(i);

    }
}
