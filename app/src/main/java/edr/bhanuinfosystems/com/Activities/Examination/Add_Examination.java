package edr.bhanuinfosystems.com.Activities.Examination;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edr.bhanuinfosystems.com.Activities.Make_Prescription.Make_Prescription;
import edr.bhanuinfosystems.com.Activities.Medicine.Medicine;
import edr.bhanuinfosystems.com.History.History;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;
import edr.bhanuinfosystems.com.model.physcial_examination;

public class Add_Examination extends AppCompatActivity {
    String h,w,t,b,s;
    EditText height,weight,temp,bp,sugar;
    Button next;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__examination);

        setupview();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {

                    SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("height",h);
                    editor.putString("weight",w);
                    editor.putString("temp",t);
                    editor.putString("bp",b);
                    editor.putString("sugar",s);
                    editor.commit();

                    Toast.makeText(Add_Examination.this, "Saved Sucessfully", Toast.LENGTH_SHORT).show();
                    Intent i  = new Intent(Add_Examination.this, Make_Prescription.class);
                    startActivity(i);


                }

            }
        });
    }

    private boolean validate() {
        boolean result=false;
         h = height.getText().toString().trim();
         w = weight.getText().toString().trim();
         t =temp.getText().toString().trim();
         b= bp.getText().toString().trim();
         s= sugar.getText().toString().trim();
        if(h.isEmpty() && w.isEmpty()&& t.isEmpty()&& b.isEmpty()&& s.isEmpty())
        {

            Toast.makeText(this, "Please enter all the details ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;

        }
        return result;

    }


    private void setupview() {
        height = (EditText)findViewById(R.id.hid);
        weight = (EditText)findViewById(R.id.wtid);
        temp = (EditText)findViewById(R.id.tempid);
        bp = (EditText)findViewById(R.id.idbp);
        sugar = (EditText)findViewById(R.id.idsu);
        next= (Button)findViewById(R.id.ph_next_btn);



    }
}
