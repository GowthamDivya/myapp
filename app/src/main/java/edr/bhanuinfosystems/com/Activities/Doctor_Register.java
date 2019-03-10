package edr.bhanuinfosystems.com.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import edr.bhanuinfosystems.com.Api.RetrofitClient;
import edr.bhanuinfosystems.com.R;
import edr.bhanuinfosystems.com.model.DefaultResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Doctor_Register extends AppCompatActivity {



    private RadioGroup radioGroup;
    private RadioButton radioButton;
    String doc_name,doc_mob,doc_email,doc_city,doc_spec,doc_exp,doc_regno,doc_gen;
    EditText ename,emob,email,ecity,espe,exp,eregno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor__register);
        ename = (EditText)findViewById(R.id.dname);
        emob = (EditText)findViewById(R.id.dmob);
        email = (EditText)findViewById(R.id.demail);
        ecity = (EditText)findViewById(R.id.dcity);
        espe = (EditText)findViewById(R.id.dspec);
        exp = (EditText)findViewById(R.id.dexp);
        eregno = (EditText)findViewById(R.id.dregno);
        radioGroup = (RadioGroup)findViewById(R.id.dgen);
    }
    public void register(View view) {
        int radio =  radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radio);
        doc_gen  = radioButton.getText().toString();
        doc_name = ename.getText().toString();
        doc_mob=emob.getText().toString();
        doc_email=email.getText().toString();
        doc_city=ecity.getText().toString();
        doc_spec=espe.getText().toString();
        doc_regno=eregno.getText().toString();
        doc_exp=exp.getText().toString();

        Call<DefaultResponse> call = (Call<DefaultResponse>) RetrofitClient
                .getInstance()
                .getApi()
                .createDoc(doc_name,doc_gen,doc_mob, doc_email,doc_city,doc_spec,doc_regno,doc_exp);

        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {

                if (response.code() == 201) {

                    DefaultResponse dr = response.body();
                    Toast.makeText(Doctor_Register.this, dr.getMsg(), Toast.LENGTH_LONG).show();
                }
                else if (response.code() == 422) {
                    Toast.makeText(Doctor_Register.this, "User already exist", Toast.LENGTH_LONG).show();
                }



            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

                Toast.makeText(Doctor_Register.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });





    }

}
