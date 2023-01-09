package com.vivianafemenia.ejercicionavidadpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vivianafemenia.ejercicionavidadpmdm.conexiones.ApiConexiones;
import com.vivianafemenia.ejercicionavidadpmdm.conexiones.RetrofitObject;
import com.vivianafemenia.ejercicionavidadpmdm.modelos.Personaje;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerPersonajeActivity extends AppCompatActivity {
    private ImageView imgPersonaje;
    private TextView lblNombre;
    private TextView lblfilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_personaje);
        imgPersonaje=findViewById(R.id.imgPersonajeVer);
        lblNombre=findViewById(R.id.lblNombreVer);
        lblfilms=findViewById(R.id.lblFilmsVer);

        if(getIntent().getExtras() != null && getIntent().getExtras().getString("ID")!= null) {
            ApiConexiones api = RetrofitObject.getConnetion().create(ApiConexiones.class);
            Call<Personaje> personajeCall = api.getPersonaje(getIntent().getExtras().getString("ID"));

            personajeCall.enqueue(new Callback<Personaje>() {
                @Override
                public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                    if(response.code() == HttpURLConnection.HTTP_OK){
                        Personaje p = response.body();
                        lblNombre.setText(p.getName());
                        lblfilms.setText("");
                        for(String film : p.getFilms()){
                            lblfilms.setText(lblfilms.getText()+"\n"+film);
                        }
                        Picasso.get().load(p.getImageUrl()).into(imgPersonaje);
                    }
                }

                @Override
                public void onFailure(Call<Personaje> call, Throwable t) {

                }
            });
        }
    }
}