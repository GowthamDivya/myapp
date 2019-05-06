package edr.bhanuinfosystems.com.Activities.Symptoms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edr.bhanuinfosystems.com.R;

public class Add_Symptoms extends AppCompatActivity {

        TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__symptoms);
        t1 = (TextView)findViewById(R.id.complaint);

        Bundle b1 = getIntent().getExtras();
        String s1 = b1.getString("complaint");
        t1.setText(s1);
    }
}
