package ru.embersoft.darktheme;

import android.content.Context;
import android.content.SharedPreferences;

class SharedPref {
    private SharedPreferences mySharedPref;

    SharedPref(Context context) {
        mySharedPref = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    void setDarkModeState(Boolean state) {
        SharedPreferences.Editor editor = mySharedPref.edit();
        editor.putBoolean("darkTheme", state);
        editor.apply();
    }

    Boolean loadDarkModeState(){
        return mySharedPref.getBoolean("darkTheme", false);
    }
}
