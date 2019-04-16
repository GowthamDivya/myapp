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

public class Doctor_Register extends AppCompatActivity {



    private RadioGroup radioGroup;
    private RadioButton radioButton;
    //int doc_mob,doc_regno,doc_exp;
    String doc_name,doc_email,doc_city,doc_spec,doc_gen,doc_Pass,doc_mob,doc_regno,doc_exp;
    EditText ename,emob,email,ecity,espe,exp,eregno,epass;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__register);

        if (SharedPrefManager.getInstance(this).docisLoggedIn()) {
            finish();
            startActivity(new Intent(this,Doctor_Home.class));
            return;
        }
        setUpView();
Register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(validate())
        {
            reg();
        }


    }
});

    }

    private boolean validate() {
        boolean result =false;
        int radio =  radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radio);
        doc_gen  = radioButton.getText().toString();
        doc_name = ename.getText().toString();
        doc_mob = emob.getText().toString();
        doc_email=email.getText().toString();
        doc_city=ecity.getText().toString();
        doc_spec=espe.getText().toString();
        doc_regno=eregno.getText().toString();
        doc_exp=exp.getText().toString();
        doc_Pass=epass.getText().toString();

        if(doc_gen.isEmpty() && doc_name.isEmpty()  && doc_mob.isEmpty()  && doc_email.isEmpty()  && doc_city.isEmpty()   && doc_spec.isEmpty()&& doc_regno.isEmpty()&& doc_exp.isEmpty()&& doc_Pass.isEmpty())
        {
            Toast.makeText(this, "Please enter all the details ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;

        }
        return result;

    }

    private void reg() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_DOC_REG,
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
                params.put("dname", doc_name);
                params.put("dgen", doc_gen);
                params.put("dmob", doc_mob);
                params.put("demail", doc_email);
                params.put("password",doc_Pass);
                params.put("dcity",doc_city);
                params.put("dspec",doc_spec);
                params.put("dexp",doc_exp);
                params.put("dreg",doc_regno);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

    private void setUpView() {

        ename = (EditText)findViewById(R.id.dname);
        epass = (EditText)findViewById(R.id.dpass);
        emob = (EditText)findViewById(R.id.dmob);
        email = (EditText)findViewById(R.id.demail);
        ecity = (EditText)findViewById(R.id.dcity);
        espe = (EditText)findViewById(R.id.dspec);
        exp = (EditText)findViewById(R.id.dexp);
        eregno = (EditText)findViewById(R.id.dregno);
        radioGroup = (RadioGroup)findViewById(R.id.dgen);
        Register = (Button)findViewById(R.id.doc_reg);
    }


}
