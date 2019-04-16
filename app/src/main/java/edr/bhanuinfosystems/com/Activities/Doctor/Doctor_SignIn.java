package edr.bhanuinfosystems.com.Activities.Doctor;

import android.content.Intent;
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

import java.util.HashMap;
import java.util.Map;

import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Singleton.VolleySingleton;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;
import edr.bhanuinfosystems.com.model.Doctor;
import edr.bhanuinfosystems.com.urls.URLs;

public class Doctor_SignIn extends AppCompatActivity {


    EditText id,pwd;
    Button doc_login;
    String demail,dpass;
    private boolean loggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__sign_in);

        if (SharedPrefManager.getInstance(this).docisLoggedIn()) {
            finish();
            startActivity(new Intent(this,Doctor_Home.class));
        }

        setUpView();

        doc_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validate())
                {
                    login();
                }


            }
        });


    }

    private void login() {


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_DOC_LOGIN,
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
                                Doctor user = new Doctor(

                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).docLogin(user);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(),Doctor_Home.class));
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
                params.put("demail", demail);
                params.put("dpass", dpass);
                return params;
            }
        };
        //Adding the string request to the queue
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);

    }

    private boolean validate() {
        boolean result =false;
        demail = id.getText().toString();
        dpass = pwd.getText().toString();
        if(demail.isEmpty() && dpass.isEmpty())
        {
            Toast.makeText(this, "Please enter all the details ", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result = true;

        }
        return result;

    }

    private void setUpView() {
        id = (EditText)findViewById(R.id.doc_demail_doclog);
        pwd = (EditText)findViewById(R.id.doc_pass);
        doc_login = (Button)findViewById(R.id.doc_login_btn);


    }

    public void gotodocreg(View view) {

        Intent i  = new Intent(this,Doctor_Register.class);
        startActivity(i);

    }
}
