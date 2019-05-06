package edr.bhanuinfosystems.com.Storage;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import edr.bhanuinfosystems.com.Activities.Admin.Admin_Login;
import edr.bhanuinfosystems.com.Activities.Doctor.Doctor_SignIn;
import edr.bhanuinfosystems.com.model.Admin;
import edr.bhanuinfosystems.com.model.Doctor;
import edr.bhanuinfosystems.com.model.physcial_examination;

/**
 * Created by Belal on 9/5/2017.
 */

//here for this class we are using a singleton pattern

public class SharedPrefManager {

    //the constants
    private static final String SHARED_PREF_NAME = "gowtham";
    private static final String MYDATA = "mydata";
    private static final String KEY_USERNAME = "keyusername";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_GENDER = "keygender";
    private static final String KEY_ID = "keyid";



    //doctor
    private static final String DID = "did";
    private static final String DNAME = "dname";
    private static final String DGEN = "keyid";
    private static final String DMOB = "keyid";
    private static final String DEMIAL = "keyid";
    private static final String DCITY = "keyid";
    private static final String DSPEC = "keyid";
    private static final String DEXP = "keyid";
    private static final String DREG = "keyid";
    private static final String STATUS = "keyid";

    //Patient
    private static final String PID = "pid";
    private static final String PNAME = "pname";
    private static final String PAGE = "page";
    private static final String PGEN = "pgen";
    private static final String PMOB = "pmob";
    private static final String PEMAIL = "pemail";
    private static final String PADD = "padd";
    private static final String PDOC = "pdid";

//Physical Examinations
    private static final String HEIGHT = "height";
    private static final String WEIGHT = "weight";
    private static final String TEMP = "temp";
    private static final String BP = "bp";
    private static final String SUGAR = "sugar";


//patient History
    private static final String CLINICAL_NOTES = "CN";
    private static final String EXAMINATIONS = "EXA";

//DIAGNOSIS
    private static final String Diagnosis = "diagnosis";

    //Medications
    private static final String MEDICATION_NAME = "medname";
    private static final String FREQUENCY = "freq";
    private static final String DAYS = "days";
    private static final String QTY = "qty";
    private static final String AF_BF = "afbf";
    private static final String INSTRUCTION = "instruction";





    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private SharedPrefManager(Context context) {
        mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    //method to let the user login
    //this method will store the user data in shared preferences

    public void docLogin(Doctor doctor) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(DID, doctor.getId());
        editor.putString(DNAME, doctor.getDname());
        editor.putString(DGEN, doctor.getDgen());
        editor.putInt(DMOB, doctor.getDmob());
        editor.putString(DEMIAL, doctor.getDemail());
        editor.putString(DCITY, doctor.getDcity());
        editor.putString(DSPEC, doctor.getDspec());
        editor.putString(DCITY, doctor.getDcity());
        editor.putInt(DEXP, doctor.getDexp());
        editor.putInt(DREG, doctor.getDreg());
        editor.putInt(STATUS, doctor.getStatus());
        editor.apply();
    }



    public boolean docisLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(DNAME, null) != null;
    }


    //method to let the user login
    //this method will store the user data in shared preferences
    public void userLogin(Admin user) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_ID, user.getId());
        editor.putString(KEY_USERNAME, user.getUsername());
        editor.putString(KEY_EMAIL, user.getEmail());
        editor.putString(KEY_GENDER, user.getGender());
        editor.apply();
    }

    //this method will checker whether user is already logged in or not
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USERNAME, null) != null;
    }

    //this method will give the logged in user
    public Admin getUser() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Admin(
                sharedPreferences.getInt(KEY_ID, -1),
                sharedPreferences.getString(KEY_USERNAME, null),
                sharedPreferences.getString(KEY_EMAIL, null),
                sharedPreferences.getString(KEY_GENDER, null)
        );
    }

    //this method will logout the user
    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, Admin_Login.class));
    }


    public void doclogout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, Doctor_SignIn.class));
    }

public void pe(physcial_examination pe)
{
    SharedPreferences sharedPreferences = mCtx.getSharedPreferences(MYDATA, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putString(HEIGHT,pe.getHeight());
    editor.putString(WEIGHT, pe.getWeight());
    editor.putString(TEMP, pe.getTemp());
    editor.putString(BP, pe.getBp());
    editor.putString(SUGAR, pe.getSugar());
    editor.apply();

}

}