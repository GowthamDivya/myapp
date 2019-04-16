package edr.bhanuinfosystems.com.Activities.Complaints;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;

import edr.bhanuinfosystems.com.Activities.Symptoms.Add_Symptoms;
import edr.bhanuinfosystems.com.R;

public class Complaint_List extends AppCompatActivity {
    ArrayList<String> list;
    CheckBox c1, c2, c3, c4, c5, c6, c7, c8, c9;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint__list);
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        list = new ArrayList<String>();
        next = (Button)findViewById(R.id.c_nxt_btn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();


                switch(view.getId()) {
                    case R.id.c1:
                        list.add(c1.getTag().toString());

                        break;
                    case R.id.c2:
                        list.add(c2.getTag().toString());


                        break;
                    case R.id.c3:
                        list.add(c3.getTag().toString());
                        break;
                    case R.id.c4:
                        list.add(c4.getTag().toString());
                        break;
                    case R.id.c5:
                        list.add(c5.getTag().toString());

                        break;
                    case R.id.c6:
                        list.add(c6.getTag().toString());

                        break;
                    case R.id.c7:
                        list.add(c7.getTag().toString());


                }



            }
        });















}
}