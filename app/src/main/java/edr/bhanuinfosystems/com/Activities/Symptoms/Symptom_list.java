package edr.bhanuinfosystems.com.Activities.Symptoms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import edr.bhanuinfosystems.com.Activities.complaint.Complaint_list;
import edr.bhanuinfosystems.com.Adapters.complaint_list_Adapter;
import edr.bhanuinfosystems.com.Adapters.symptoms_adapters;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Complaint;
import edr.bhanuinfosystems.com.model.Symptom;

import static edr.bhanuinfosystems.com.urls.URLs.URL_complaints_list;
import static edr.bhanuinfosystems.com.urls.URLs.URL_symptoms_list;

public class Symptom_list extends AppCompatActivity {

    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Symptom> list ;
    private RecyclerView recyclerView ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom_list);


        recyclerView = findViewById(R.id.recylcerView5);

        //initializing the productlist
        list = new ArrayList<Symptom>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();

    }

    private void loadProducts() {



        request = new JsonArrayRequest(URL_symptoms_list, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Symptom anime = new Symptom() ;
                        anime.setSname(jsonObject.getString("sname"));
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

        requestQueue = Volley.newRequestQueue(Symptom_list.this);
        requestQueue.add(request) ;





    }

    private void setuprecyclerview(List<Symptom> list) {

        symptoms_adapters myadapter = new symptoms_adapters(this,list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);



    }
}
