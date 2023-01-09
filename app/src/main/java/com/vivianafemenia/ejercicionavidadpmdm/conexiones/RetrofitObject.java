package com.vivianafemenia.ejercicionavidadpmdm.conexiones;

import com.vivianafemenia.ejercicionavidadpmdm.configuraciones.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {

    public static Retrofit getConnetion(){
        return new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
