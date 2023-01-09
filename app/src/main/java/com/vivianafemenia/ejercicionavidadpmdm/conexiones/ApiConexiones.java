package com.vivianafemenia.ejercicionavidadpmdm.conexiones;

import com.vivianafemenia.ejercicionavidadpmdm.modelos.Personaje;
import com.vivianafemenia.ejercicionavidadpmdm.modelos.Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiConexiones {
    // Descarga de datos inicial

    @GET("/characters")
    Call<Respuesta>getPersonajes();

    // descarga paginba en concreto
    @GET("/characters?")
    Call<Respuesta>getPage(@Query("page") String page);


    // descarga de un personaje

    @GET("/characters/{idPersonaje}")
    Call<Personaje> getPersonaje(@Path("idPersonaje") String id);
}
