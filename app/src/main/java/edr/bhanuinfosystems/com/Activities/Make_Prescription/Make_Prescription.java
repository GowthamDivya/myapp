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

    String height,weight,temp,bp,sugar,pid;
    String cnotes,cexm;
    String pat_id,pname,pgen,page,pmob,pemail,pcity,pdid;




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
                cnotesdata();
                pdata();
                senddata();
            }
        });
    }

    private void pdata() {

        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        //Physical Examinations
        pat_id = sharedPreferences.getString("id",DEFAULT);
        pname = sharedPreferences.getString("pname",DEFAULT);
        pgen = sharedPreferences.getString("pgen",DEFAULT);
        page = sharedPreferences.getString("page",DEFAULT);
        pmob = sharedPreferences.getString("pmob",DEFAULT);
        pemail = sharedPreferences.getString("pemail",DEFAULT);
        pcity = sharedPreferences.getString("pcity",DEFAULT);
        pdid = sharedPreferences.getString("pdid",DEFAULT);
        Toast.makeText(Make_Prescription.this, pat_id+pname+pgen+page+pmob+pemail+pcity+pdid , Toast.LENGTH_SHORT).show();




    }

    private void cnotesdata() {
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        //Physical Examinations
        cnotes = sharedPreferences.getString("cnotes",DEFAULT);
        cexm = sharedPreferences.getString("cexam",DEFAULT);

        Toast.makeText(Make_Prescription.this, cnotes+cexm, Toast.LENGTH_SHORT).show();



    }

    private void senddata()
    {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://192.168.43.39/php/pdf.php"  ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            //converting response to json object
                            JSONObject obj = new JSONObject(response);



                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                //creating a new user object
                                Doctor user = new Doctor();

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).docLogin(user);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), Doctor_Home.class));
                            } else {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("height", height);
                params.put("weight", weight);
                params.put("temp", temp);
                params.put("sugar", sugar);
                params.put("bp",bp);
                params.put("cnotes", cnotes);
                params.put("cexam",cexm);

                params.put("pid",pid);
                params.put("pname",pname);
                params.put("page",page);
                params.put("pgen",pgen);
                params.put("did",pdid);
                params.put("pmob",pmob);
                params.put("pcity",pcity);





                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

    private void data() {
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        //Physical Examinations
        height = sharedPreferences.getString("height",DEFAULT);
        weight = sharedPreferences.getString("weight",DEFAULT);
        temp = sharedPreferences.getString("temp",DEFAULT);
        bp = sharedPreferences.getString("bp",DEFAULT);
        sugar = sharedPreferences.getString("sugar",DEFAULT);
        pid = sharedPreferences.getString("pid",DEFAULT);
        Toast.makeText(Make_Prescription.this, height+weight+temp+bp+sugar+pid, Toast.LENGTH_SHORT).show();

    }
}
