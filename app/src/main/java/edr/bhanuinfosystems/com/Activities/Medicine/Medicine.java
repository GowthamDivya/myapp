package edr.bhanuinfosystems.com.Activities.Medicine;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

import edr.bhanuinfosystems.com.Activities.Examination.Add_Examination;
import edr.bhanuinfosystems.com.History.History;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Singleton.VolleySingleton;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;
import edr.bhanuinfosystems.com.urls.URLs;

public class Medicine extends AppCompatActivity {

    String mn,f,d,q,ab,i;
    EditText medn,medf,medd,medq,medab,medi;
    Button next;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);
        setupview();


        next = (Button)findViewById(R.id.med_btn_nxt);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    senddata();

                }

            }
        });

    }

    private void senddata() {

        SharedPreferences sharedPreferences = ctx.getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name",mn);
        editor.putString("frequency",f);
        editor.putString("days",d);
        editor.putString("qty",q);
        editor.putString("afbf",ab);
        editor.putString("instruction",i);
        editor.commit();
        Toast.makeText(Medicine.this, "Saved Sucessfully", Toast.LENGTH_SHORT).show();
        Intent i  = new Intent(Medicine.this, History.class);
        startActivity(i);



    }

    private boolean validate()
    {
    boolean result = false;

        mn = medn.getText().toString();
        f = medf.getText().toString();
        d = medd.getText().toString();
        q= medq.getText().toString();
        ab = medab.getText().toString();
        i = medi.getText().toString();
        if(mn.isEmpty() && f.isEmpty()&& d.isEmpty()&& q.isEmpty()&& ab.isEmpty()&& i.isEmpty())
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
        medn = (EditText)findViewById(R.id.mn);
        medf = (EditText)findViewById(R.id.mf);
        medd = (EditText)findViewById(R.id.md);
        medq = (EditText)findViewById(R.id.mq);
        medab = (EditText)findViewById(R.id.mab);
        medi = (EditText)findViewById(R.id.mi);



    }
}
