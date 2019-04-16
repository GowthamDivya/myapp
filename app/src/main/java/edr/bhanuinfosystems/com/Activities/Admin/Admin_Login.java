package edr.bhanuinfosystems.com.Activities.Admin;

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
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


import edr.bhanuinfosystems.com.Configfiles.Config;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Singleton.VolleySingleton;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;
import edr.bhanuinfosystems.com.model.Admin;
import edr.bhanuinfosystems.com.urls.URLs;

public class Admin_Login extends AppCompatActivity {

    EditText id,pwd;
    Button admin_login;
    String Admin_id,Admin_pwd;
    private boolean loggedIn = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);

        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            finish();
            startActivity(new Intent(this, Admin_Home.class));
        }
        setUpView();

        admin_login.setOnClickListener(new View.OnClickListener() {
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

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLs.URL_admin_login,
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
                                Admin user = new Admin(
                                        userJson.getInt("id"),
                                        userJson.getString("username"),
                                        userJson.getString("email"),
                                        userJson.getString("gender")
                                );

                                //storing the user in shared preferences
                                SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);

                                //starting the profile activity
                                finish();
                                startActivity(new Intent(getApplicationContext(), Admin_Home.class));
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
                params.put("username", Admin_id);
                params.put("password", Admin_pwd);
                return params;
            }
        };
        //Adding the string request to the queue
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //In onresume fetching value from sharedpreference
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);

        //Fetching the boolean value form sharedpreferences
        loggedIn = sharedPreferences.getBoolean(Config.LOGGEDIN_SHARED_PREF, false);

        //If we will get true
        //if(loggedIn){
            //We will start the Profile Activity
        //    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
         //   startActivity(intent);

    }

    private void setUpView()
    {
        id = (EditText)findViewById(R.id.Aname);
        pwd = (EditText)findViewById(R.id.apwd);
        admin_login = (Button)findViewById(R.id.A_Login_btn);
    }
        private Boolean validate()
        {

            boolean result =false;
            Admin_id = id.getText().toString();
            Admin_pwd = pwd.getText().toString();
            if(Admin_id.isEmpty() && Admin_pwd.isEmpty())
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
