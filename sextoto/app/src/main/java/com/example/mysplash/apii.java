package com.example.mysplash;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.mysplash.interfaces.perros;
import com.example.mysplash.models.perrosC;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apii extends AppCompatActivity {
    Button perro1,perro2,perro3,mix;
    String url;
    ImageView imgperro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apiperro);
        perro1=findViewById(R.id.button);
        perro2=findViewById(R.id.button6);
        perro3=findViewById(R.id.button7);
        mix=findViewById(R.id.button2);
        imgperro=findViewById(R.id.imgProducto);

        perro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find("akita");
            }
        });
        perro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find("komondor");
            }
        });
        perro3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find("mexicanhairless");
            }
        });
        mix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find("mix");
            }
        });
    }
    private void find(String codigo){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dog.ceo/api/breed/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        perros perros1 = retrofit.create(perros.class);
        Call<perrosC> call=perros1.find(codigo);
        call.enqueue(new Callback<perrosC>() {
            @Override
            public void onResponse(Call<perrosC> call, Response<perrosC> response) {
                try {
                    if (response.isSuccessful()){
                        perrosC p = response.body();
                        url=p.getMessage();
                        Glide.with(getApplication()).load(url).into(imgperro);
                    }

                }catch (Exception ex){
                    Toast.makeText(apii.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<perrosC> call, Throwable t) {
                Toast.makeText(apii.this, "Error de conexion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
