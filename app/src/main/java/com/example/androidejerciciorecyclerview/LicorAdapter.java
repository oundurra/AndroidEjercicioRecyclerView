package com.example.androidejerciciorecyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LicorAdapter extends RecyclerView.Adapter<LicorAdapter.ViewHolder> {
    List<Licor> licoresList;
    Context context;

    public LicorAdapter(List<Licor> licoresList, Context context) {
        this.licoresList = licoresList;
        this.context = context;
    }

    @Override
    public LicorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_licor, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LicorAdapter.ViewHolder holder, int position) {
        final Licor licor = licoresList.get(position);
        try {
            InputStream is = context.getAssets().open("images/bulleit.png");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            //Log.i("LicoresJSON:", context.getString(R.string.images_folder)+licoresList.get(position).getFoto());

            Picasso.get().load( context.getString(R.string.images_folder)+licoresList.get(position).getFoto()).into(holder.ivFoto);
            holder.tvNombre.setText(licoresList.get(position).getNombre());
            holder.tvTipo.setText(licoresList.get(position).getTipo());
            holder.tvPrecio.setText(Integer.toString(licoresList.get(position).getPrecio()));

        } catch(IOException e) {
            e.printStackTrace();
        }



        /*holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"click on item: "+myListData.getDescription(),Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return licoresList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivFoto;
        public TextView tvNombre;
        public TextView tvTipo;
        public TextView tvPrecio;

        public ViewHolder(View itemView) {
            super(itemView);
            this.ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            this.tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            this.tvTipo = (TextView) itemView.findViewById(R.id.tvTipo);
            this.tvPrecio = (TextView) itemView.findViewById(R.id.tvPrecio);
        }
    }
}
