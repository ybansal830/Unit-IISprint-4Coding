package com.myfirst.unit_iisprint_4coding;

import android.content.Context;
import android.content.SharedPreferences;

public class savePreference {

    private static String PREFERENCE_KEY = "com.myfirst.unit4sprint2";

    public static SharedPreferences getSharedPreference(Context context){
        return context.getSharedPreferences(PREFERENCE_KEY, Context.MODE_PRIVATE);
    }

    public static void writeIntToPreference(Context context,String key,int value){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public static void writeStringToPreference(Context context,String key,String value){
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static int getIntFromPreference(Context context,String key){
        return getSharedPreference(context).getInt(key,0);
    }
    public static String getStringFromPreference(Context context,String key){
        return getSharedPreference(context).getString(key,null);
    }

}
