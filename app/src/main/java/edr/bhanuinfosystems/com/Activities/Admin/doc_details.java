package edr.bhanuinfosystems.com.Activities.Admin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import edr.bhanuinfosystems.com.Activities.MainActivity;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.Singleton.VolleySingleton;
import edr.bhanuinfosystems.com.Storage.SharedPrefManager;
import edr.bhanuinfosystems.com.model.Admin;
import edr.bhanuinfosystems.com.urls.URLs;

public class doc_details extends AppCompatActivity {

    ToggleButton doc;
    int did;
    int status;
    public  static final String DEFAULT="N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_details);


        doc = findViewById(R.id.toggleid);

        // Recieve data

         did = getIntent().getExtras().getInt("id");
        String dname  = getIntent().getExtras().getString("dname");
        String dgen = getIntent().getExtras().getString("dgen");
        int dmob = getIntent().getExtras().getInt("dmob") ;
        String demail = getIntent().getExtras().getString("demail");
        String dcity = getIntent().getExtras().getString("dcity");
        String dspec = getIntent().getExtras().getString("dspec");
        int dexp = getIntent().getExtras().getInt("dexp");
        int dreg = getIntent().getExtras().getInt("dreg");
        status = getIntent().getExtras().getInt("status");







        TextView tdid = findViewById(R.id.doc_did);
        TextView tdname = findViewById(R.id.doc_dname);
        TextView tdgen = findViewById(R.id.doc_dgen) ;
        TextView tdmob = findViewById(R.id.doc_dmob);
        TextView tdemail  = findViewById(R.id.doc_demail) ;
        TextView tdspec  = findViewById(R.id.doc_spec) ;
        TextView tdcity  = findViewById(R.id.doc_city) ;
        TextView tdexp  = findViewById(R.id.doc_dexp) ;
        TextView tdreg  = findViewById(R.id.doc_dreg) ;

        tdname.setText(dname);
        tdgen.setText(dgen);
        tdemail.setText(demail);
        tdspec.setText(dspec);
        //tdcity.setText(status);

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(doc.isChecked())
                {
                    Toast.makeText(doc_details.this,"Activated ",Toast.LENGTH_SHORT).show();
                     sendpost();


                }
                else
                {
                    Toast.makeText(doc_details.this,"Deactivated ",Toast.LENGTH_SHORT).show();


                }

            }
        });


    }

    private void deactivate() {


        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://192.168.43.39/backend/deactivate.php",
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
                params.put("id", String.valueOf(did));
                params.put("status", String.valueOf(0));


                return params;
            }
        };
        //Adding the string request to the queue
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);





    }

    private void sendpost() {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://192.168.43.39/backend/activate.php",
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
                params.put("id", String.valueOf(did));
                params.put("status", String.valueOf(status));


                return params;
            }
        };
        //Adding the string request to the queue
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);




    }
}
