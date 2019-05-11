package edr.bhanuinfosystems.com.Activities.physical_history;

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
import edr.bhanuinfosystems.com.R;

public class physical_history extends AppCompatActivity {

    String cnotes,cexam;
    EditText cnotes_ed,cexam_ed;
    Button next;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_history);
        setupview();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate())
                {

                    SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("cnotes",cnotes);
                    editor.putString("cexam",cexam);
                    editor.commit();

                    Toast.makeText(physical_history.this, "Saved Sucessfully", Toast.LENGTH_SHORT).show();
                    Intent i  = new Intent(physical_history.this, Make_Prescription.class);
                    startActivity(i);



                }

            }
        });





    }

    private boolean validate() {
        boolean result=false;


        cnotes = cnotes_ed.getText().toString().trim();
        cexam = cexam_ed.getText().toString().trim();


        if(cnotes.isEmpty() && cexam.isEmpty())
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

        cnotes_ed = (EditText)findViewById(R.id.cnotes);
        cexam_ed= (EditText)findViewById(R.id.cexam);
        next= (Button)findViewById(R.id.c_next_btn);

    }
}
