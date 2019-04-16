package edr.bhanuinfosystems.com.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edr.bhanuinfosystems.com.Activities.Examination.Add_Examination;
import edr.bhanuinfosystems.com.History.History;
import edr.bhanuinfosystems.com.R;

public class Patient_History extends AppCompatActivity {

    EditText clinical_notes,examinations;
    String cn,ex;
    Button next;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient__history);
        clinical_notes = (EditText)findViewById(R.id.ph_Edvw);
        examinations = (EditText)findViewById(R.id.pt_ex_edtx);
        next = (Button)findViewById(R.id.next_btn_patexm);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(validate())
                {
                    SharedPreferences sharedPreferences = ctx.getSharedPreferences("mydata1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("CN",cn);
                    editor.putString("EXM",ex);
                    editor.commit();
                    Toast.makeText(Patient_History.this, "Saved Sucessfully", Toast.LENGTH_SHORT).show();
                    Intent i  = new Intent(Patient_History.this, History.class);
                    startActivity(i);

                }
            }
        });



    }

    private Boolean validate()
    {

        boolean result =false;
         cn= clinical_notes.getText().toString();
        ex = examinations.getText().toString();
        if(cn.isEmpty() && ex.isEmpty())
        {
            Toast.makeText(this, "Please enter all the details ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;

        }
        return result;
    }

}
