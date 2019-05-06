package edr.bhanuinfosystems.com.Activities.Admin;

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

import edr.bhanuinfosystems.com.Adapters.reg_doc_list_adapter;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.Doctor;

public class Active_Doctor_list extends AppCompatActivity {

    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Doctor> list ;
    private RecyclerView recyclerView ;
    public static final String URL_doclist = "http://192.168.43.39/backend/activated_list.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active__doctor_list);


        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView1);

        //initializing the productlist
        list = new ArrayList<>();

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
                        Doctor anime = new Doctor() ;
                        anime.setId(jsonObject.getInt("id"));
                        anime.setDname(jsonObject.getString("dname"));
                        anime.setDgen(jsonObject.getString("dgen"));
                        anime.setDmob(jsonObject.getInt("dmob"));
                        anime.setDemail(jsonObject.getString("demail"));
                        anime.setDcity(jsonObject.getString("dcity"));
                        anime.setDspec(jsonObject.getString("dspec"));
                        anime.setDexp(jsonObject.getInt("dexp"));
                        anime.setDreg(jsonObject.getInt("dreg"));
                        anime.setStatus(jsonObject.getInt("status"));
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


        requestQueue = Volley.newRequestQueue(Active_Doctor_list.this);
        requestQueue.add(request) ;


    }

    private void setuprecyclerview(List<Doctor> list) {

        reg_doc_list_adapter myadapter = new reg_doc_list_adapter(this,list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);

    }
}
