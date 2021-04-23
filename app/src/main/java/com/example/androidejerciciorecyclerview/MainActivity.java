package com.example.androidejerciciorecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    RecyclerView rvLicor;
    List<Licor> licoresList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lee los licores desde el json
        cargaLicores();

        // Carga el RecyclerView
        rvLicor = (RecyclerView) findViewById(R.id.rvLicores);
        rvLicor.setLayoutManager(new LinearLayoutManager(this));
        rvLicor.setAdapter(new LicorAdapter(licoresList, this));
    }

    public void cargaLicores() {
        String jsonLicores = leeJSONLicores();

        if(jsonLicores.length() > 0) {
            JsonObject jobj = new Gson().fromJson(jsonLicores, JsonObject.class);
            String result = jobj.get("status").toString();
            String listaLicores = jobj.get("licores").toString();

/*            Log.i("LicoresStatus:", result);
            Log.i("LicoresJSON:", listaLicores);*/

            Gson gson = new Gson();
            Type listLicoresType = new TypeToken<List<Licor>>() { }.getType();
            licoresList = gson.fromJson(listaLicores, listLicoresType);
        }
    }

    public String leeJSONLicores() {
        String jsonString="";
        try {
            InputStream is = getApplicationContext().getAssets().open("licores.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonString = new String(buffer,"UTF-8");
            // Log.i("LicoresJSON:", jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

}