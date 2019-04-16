package edr.bhanuinfosystems.com.Activities.Make_Prescription;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import edr.bhanuinfosystems.com.Activities.Doctor.Doctor_Home;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Singleton.VolleySingleton;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;
import edr.bhanuinfosystems.com.model.Doctor;
import edr.bhanuinfosystems.com.urls.URLs;

public class Make_Prescription extends AppCompatActivity {

    String height,weight,temp,bp,sugar;

    Button save;
    Context ctx;
public  static final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make__prescription);
        save = (Button)findViewById(R.id.btn_makeprep);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                data();

                senddata();


                SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                //Physical Examinations
         height = sharedPreferences.getString("height",DEFAULT);
         weight = sharedPreferences.getString("weight",DEFAULT);
         temp = sharedPreferences.getString("temp",DEFAULT);
         bp = sharedPreferences.getString("bp",DEFAULT);
         sugar = sharedPreferences.getString("sugar",DEFAULT);
        Toast.makeText(Make_Prescription.this, height+weight+temp+bp+sugar, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void senddata() {


    }

    private void data() {


        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        //Physical Examinations
        String height = sharedPreferences.getString("height",DEFAULT);
        String weight = sharedPreferences.getString("weight",DEFAULT);
        String temp = sharedPreferences.getString("temp",DEFAULT);
        String bp = sharedPreferences.getString("bp",DEFAULT);
        String sugar = sharedPreferences.getString("sugar",DEFAULT);
        Toast.makeText(Make_Prescription.this, height+weight+temp+bp+sugar, Toast.LENGTH_SHORT).show();
    }
}
