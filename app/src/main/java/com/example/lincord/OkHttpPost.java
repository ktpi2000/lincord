package com.example.lincord;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpPost extends AsyncTask<String, String, String> {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");


    @Override
    protected String doInBackground(String... data) {
        Log.d("data", data[0]);
        String json = data[0];
        OkHttpClient client = new OkHttpClient();
        String url = "${DISCORD_WEHOOK_URL}";
        RequestBody body = RequestBody.create(JSON, data[0]);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String str) {
        Log.d("debug", str);
    }

}
