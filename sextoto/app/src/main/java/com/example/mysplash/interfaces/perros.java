package com.example.mysplash.interfaces;

import com.example.mysplash.models.perrosC;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface perros {
    @GET("{perro}/images/random")
    public Call<perrosC> find(@Path("perro") String perro);

}
