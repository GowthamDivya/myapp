package edr.bhanuinfosystems.com.Activities.complaint;

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

import edr.bhanuinfosystems.com.Adapters.complaint_list_Adapter;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Complaint;

public class Complaint_list extends AppCompatActivity {

    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Complaint> list ;
    private RecyclerView recyclerView ;
    public static final String URL_doclist = "http://192.168.43.39/backend/complaint_list.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint_list);


        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView4);

        //initializing the productlist
        list = new ArrayList<Complaint>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadProducts();


    }

    private void loadProducts() {


        request = new JsonArrayRequest(URL_doclist, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject  = null ;

                for (int i = 0 ; i < response.length(); i++ ) {


                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Complaint anime = new Complaint() ;
                        anime.setCname(jsonObject.getString("cname"));
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


        requestQueue = Volley.newRequestQueue(Complaint_list.this);
        requestQueue.add(request) ;



    }

    private void setuprecyclerview(List<Complaint> list) {

        complaint_list_Adapter myadapter = new complaint_list_Adapter(this,list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);


    }
}
