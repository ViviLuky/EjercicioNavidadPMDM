package com.vivianafemenia.ejercicionavidadpmdm.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.vivianafemenia.ejercicionavidadpmdm.R;
import com.vivianafemenia.ejercicionavidadpmdm.VerPersonajeActivity;
import com.vivianafemenia.ejercicionavidadpmdm.modelos.Personaje;

import java.util.List;

public class PersonajesAdapter extends RecyclerView.Adapter<PersonajesAdapter.PersonajeVH> {
    private List<Personaje> objects;
    private int resource;
    private Context context;

    public PersonajesAdapter(List<Personaje> objects, int resource, Context context) {
        this.objects = objects;
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public PersonajeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonajeVH(LayoutInflater.from(context).inflate(resource, null));
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeVH holder, int position) {
        Personaje personaje = objects.get(position);
        holder.lblNombre.setText(personaje.getName());
        Picasso.get().load(personaje.getImageUrl()).placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_background).into(holder.imgPersonajes);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                 bundle.putString("ID",String.valueOf(personaje.getId()));
                Intent intent= new Intent(context, VerPersonajeActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }
    public class PersonajeVH extends RecyclerView.ViewHolder{
        ImageView imgPersonajes;
        TextView lblNombre;

        public PersonajeVH(@NonNull View itemView){
            super(itemView);
            imgPersonajes=itemView.findViewById(R.id.imgPersonajeCard);
            lblNombre=itemView.findViewById(R.id.lblNombrePersonajeCard);
        }
    }
}
