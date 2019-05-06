package edr.bhanuinfosystems.com.Activities.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;

public class Admin_Home extends AppCompatActivity {


    Button doclist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__home);
         doclist = (Button)findViewById(R.id.doc_lisy_btn);



        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Admin_Login.class));
        }
        findViewById(R.id.log_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                SharedPrefManager.getInstance(getApplicationContext()).logout();


            }
        });

        doclist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Admin_Home.this,Registered_doc_list.class);
                startActivity(i);
            }
        });



    }

    public void list(View view) {

        Intent j = new Intent(Admin_Home.this,Active_Doctor_list.class);
        startActivity(j);
    }
}
