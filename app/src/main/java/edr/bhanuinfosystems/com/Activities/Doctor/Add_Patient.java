package edr.bhanuinfosystems.com.Activities.Doctor;

import android.content.Intent;
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
import edr.bhanuinfosystems.com.model.Doctor;
import edr.bhanuinfosystems.com.urls.URLs;

public class Add_Patient extends AppCompatActivity {
String PN,PG,PA,PM,PE,PAA;
EditText pname,pmob,pemail,padd,page;
Button save;
String p_gen;
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__patient);
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

                            Log.d("RESPONSE",obj.toString());

                            //if no error in response
                            if (!obj.getBoolean("error")) {
                                Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                                //getting the user from the response
                                JSONObject userJson = obj.getJSONObject("user");

                                //creating a new user object
                                Doctor user = new Doctor(
                                );

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
                params.put("pname", PN);
                params.put("pgen", PG);
                params.put("page", PA);
                params.put("dmob", PM);
                params.put("pemail",PE);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);



    }

    private boolean validate() {
        boolean result =false;

        PN = pname.getText().toString();
        PG = pname.getText().toString();
        PA = pname.getText().toString();
        PM = pname.getText().toString();
        PE = pname.getText().toString();
        PAA = pname.getText().toString();


        if(PN.isEmpty() && PG.isEmpty()  && PA.isEmpty()  && PM.isEmpty()  && PE.isEmpty()   && PAA.isEmpty())
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
        int radio =  radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radio);
        p_gen  = radioButton.getText().toString();
        pname = (EditText)findViewById(R.id.pname);
        page = (EditText)findViewById(R.id.page);
        pmob = (EditText)findViewById(R.id.pname);
        pemail = (EditText)findViewById(R.id.pname);
        padd = (EditText)findViewById(R.id.pname);
        save = (Button)findViewById(R.id.add_pat_btn);


    }
}
