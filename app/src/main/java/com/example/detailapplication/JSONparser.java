package com.example.detailapplication;

import android.app.Activity;
import android.util.Log;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

public class JSONparser {
    /*
    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }
*/
    public String jsonParse() {
        String json = null;
        try{
            Activity context;
            //InputStream inputStream = context().getAssets().open("imam.json");
        }
        catch (Exception e)
        {
            Log.d("MyAdapter", "jsonParse: ");
        }

        return json;
    }
}
