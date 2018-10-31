package id.ac.polinema.sharedpreferenceandsqlite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManagement {
    //Share preference
    private SharedPreferences mSharedPreference;
    //Editor for Shared preference
    private SharedPreferences.Editor mEditor;
    //context
    private Context mContext;
    //Shared pref mode
    int PRIVATE_MODE;
    //Shared pref name
    private static final String PREF_NAME = "SharedPref";
    //Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    public SessionManagement(Context mContext) {
        this.mContext = mContext;
        mSharedPreference = this.mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }

    //untuk menyimpan shared preferences dengan nama createLoginSession.
    public void createLoginSession(String username, String password){
        // Storing login value as TRUE
        mEditor.putBoolean(IS_LOGIN, true);
        // Storing email
        mEditor.putString(KEY_USERNAME, password);
        // Storing password
        mEditor.putString(KEY_PASSWORD, username);
        mEditor.commit();
    }

    //untuk mendapatakan informasi user
    public HashMap<String, String> getUserInformation(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user email
        user.put(KEY_USERNAME, mSharedPreference.getString(KEY_USERNAME, null));
        // user password
        user.put(KEY_PASSWORD, mSharedPreference.getString(KEY_PASSWORD, null));
        // return user
        return user;
    }

    //untuk mengecek apakah user sudah login atau belum dengan menambahkan method checkIsLogin
    public boolean isLoggedIn(){
        return mSharedPreference.getBoolean(IS_LOGIN, false);
    }

    public void checkIsLogin() {
        // Check login status
        if (!isLoggedIn()) {
            // user is not logged in redirect to MainActivity
            Intent i = new Intent(mContext, MainActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mContext.startActivity(i);
        }
    }

    //untuk menghapus Shared Preference yang telah disimpan
    public void logoutUser(){
        //Clearing all data from Shared Preferences
        mEditor.clear();
        mEditor.commit();

        //After logout redirect user to Login Activity
        Intent i = new Intent(mContext, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }
}
