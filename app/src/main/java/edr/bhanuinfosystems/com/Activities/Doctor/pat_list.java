package edr.bhanuinfosystems.com.Activities.Doctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edr.bhanuinfosystems.com.Activities.Admin.Registered_doc_list;
import edr.bhanuinfosystems.com.Adapters.Pat_list_Adapter;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Doctor;
import edr.bhanuinfosystems.com.model.Patient;

public class pat_list extends AppCompatActivity {

    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Patient> list ;
    private RecyclerView recyclerView ;
    public static final String URL_DOC_patlist="http://192.168.43.39/backend/test2.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_list);


        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView3);

        //initializing the productlist
        list = new ArrayList<>();



        loadProducts();

    }

    private void loadProducts() {


        request = new JsonArrayRequest(URL_DOC_patlist, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Patient anime = new Patient() ;
                        anime.setId(jsonObject.getInt("id"));
                        anime.setPname(jsonObject.getString("pname"));
                        anime.setPgen(jsonObject.getString("pgen"));
                        anime.setPage(jsonObject.getInt("page"));
                        anime.setPmob(jsonObject.getInt("pmob"));
                        anime.setPemail(jsonObject.getString("pemail"));
                        anime.setPcity(jsonObject.getString("pcity"));
                        anime.setDid(jsonObject.getInt("did"));
                           list.add(anime);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                setuprecyclerview(list);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        requestQueue = Volley.newRequestQueue(pat_list.this);
        requestQueue.add(request) ;

    }

    private void setuprecyclerview(List<Patient> list) {


        Pat_list_Adapter myadapter = new Pat_list_Adapter(this,list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);


    }
}
