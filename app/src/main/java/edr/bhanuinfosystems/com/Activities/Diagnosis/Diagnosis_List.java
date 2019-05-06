package edr.bhanuinfosystems.com.Activities.Diagnosis;

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

public class Diagnosis_List extends AppCompatActivity {

    String diagnosis;
    EditText Diagnosis;
    Button next;
    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis__list);
    Diagnosis = (EditText)findViewById(R.id.diag_edi);
    next = (Button)findViewById(R.id.diag_next_btn);
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(validate())
            {
                SharedPreferences sharedPreferences = ctx.getSharedPreferences("mydata", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Diagnosis",diagnosis);
                editor.commit();
                Toast.makeText(Diagnosis_List.this, "Saved Sucessfully", Toast.LENGTH_SHORT).show();
                Intent i  = new Intent(Diagnosis_List.this, History.class);
                startActivity(i);


            }
        }
    });

    }

    private boolean validate() {

        boolean result =false;
        diagnosis=Diagnosis.getText().toString();

        if(diagnosis.isEmpty())
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
