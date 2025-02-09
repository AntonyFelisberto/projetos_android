package com.example.frasedodia;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private OkHttpClient okHttpClient;
    private Request request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        request = new Request.Builder()
                .url("https://api.api-ninjas.com/v1/quotes")
                .header("X-Api-Key","")
                .build();

    }

    public void generateNewPhrase(View v){
        okHttpClient = new OkHttpClient();

        String[] phrases = {
                "May you find your worth in the waking world.",
                "Yharnam is the home of blood administration. You need only unravel its mystery.",
                "But, where's an outsider like yourself to begin? Easy, with a bit of Yharnam blood of your own...",
                "All signed and sealed. Now, let's begin the transfusion."
        };

        TextView text = findViewById(R.id.textResult);

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e){
                Log.println(Log.ASSERT,"log",e.getMessage());
                setDefaultText(text,phrases);
            }
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if(response.body() != null && response.code() < 400){
                    String responseBody = response.body().string();
                    Gson gson = new Gson();
                    JsonArray jsonArray = gson.fromJson(responseBody, JsonArray.class);
                    JsonObject jsonObject = jsonArray.get(0).getAsJsonObject();
                    String quote = jsonObject.get("quote").getAsString();
                    Log.println(Log.ASSERT, "quote", quote);

                    runOnUiThread(() -> text.setText(quote));
                }else {
                    setDefaultText(text,phrases);
                }
            }
        });
    }

    private void setDefaultText(TextView text,String[] phrases) {
        runOnUiThread(() -> text.setText(phrases[new Random().nextInt(4)]));
    }

}