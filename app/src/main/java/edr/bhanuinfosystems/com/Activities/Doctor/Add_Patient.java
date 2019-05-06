package edr.bhanuinfosystems.com.Activities.Doctor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Singleton.VolleySingleton;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;
import edr.bhanuinfosystems.com.model.Admin;
import edr.bhanuinfosystems.com.model.Doctor;
import edr.bhanuinfosystems.com.model.Patient;
import edr.bhanuinfosystems.com.urls.URLs;

public class Add_Patient extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;


    String spname,spgen,spage,spmob,spemail,spcity,spdid;
    EditText pname,pmob,pemail,page,pcity,pdid;
    Button save;
    String p_gen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__patient);
        SharedPreferences sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);

        setupview();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    addPatient();


                }


            }
        });
    }

    private void addPatient() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_ADD_PAT,
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




                                finish();



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
                params.put("pname", spname);
                params.put("pgen", spgen);
                params.put("page",spage);
                params.put("pmob", spmob);
                params.put("pemail",spemail);
                params.put("pcity",spcity);
                params.put("did", spdid);

                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);



    }

    private boolean validate() {
        boolean result =false;

        int radio =  radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radio);
        spname = pname.getText().toString();
        spgen = radioButton.getText().toString();
        spage = page.getText().toString();
        spmob = pmob.getText().toString();
        spemail = pemail.getText().toString();
        spcity = pcity.getText().toString();
        spdid = pdid.getText().toString();

        if(spname.isEmpty() && spage.isEmpty()  && spgen.isEmpty()  && spmob.isEmpty()  && spemail.isEmpty()  && spcity.isEmpty()  && spdid.isEmpty() )
        {
            Toast.makeText(Add_Patient.this, "Please enter all the details ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;

        }
        return result;


    }

    private void setupview() {

        radioGroup = (RadioGroup)findViewById(R.id.pgen);
        pname = (EditText)findViewById(R.id.pname);
        radioGroup = (RadioGroup)findViewById(R.id.pgen);
        page = (EditText)findViewById(R.id.page);
        pmob = (EditText)findViewById(R.id.pmob);
        pemail = (EditText)findViewById(R.id.pname);
        pcity = (EditText)findViewById(R.id.pcity);
        pdid = (EditText)findViewById(R.id.pdid);

        save = (Button)findViewById(R.id.add_pat_btn);


    }
}
