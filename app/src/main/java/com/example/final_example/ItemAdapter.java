package com.example.final_example;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> implements Filterable {
    private Context context;
    public List<Animal> listAnimal;
    private FilterAnimal filterAnimal;

    public ItemAdapter(Context context,List<Animal> listAnimal ){
        this.context = context;
        this.listAnimal = listAnimal;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final Animal animal = listAnimal.get(position);
        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,DetailAnimal.class);
                intent.putExtra("animal",animal);
                context.startActivity(intent);

            }
        });

        holder.img.setImageResource(animal.getBala());
        holder.textView2.setText(animal.getName());
        holder.textView3.setText(animal.getDes());
        holder.textView4.setText(animal.getPrices()+"");

    }

    @Override
    public int getItemCount() {
        return listAnimal.size();
    }

    @Override
    public Filter getFilter() {
        if (filterAnimal == null){
            filterAnimal = new FilterAnimal(listAnimal,this);
        }
        return filterAnimal;
    }

    public void setListAnimal(List<Animal> listAnimal) {
        this.listAnimal = listAnimal;
        this.notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder{
        private Button button2;
        private ImageView img;
        private TextView textView2, textView3, textView4;


        public ItemHolder(@NonNull View view) {
            super(view);
            button2 = view.findViewById(R.id.button2);
            img = view.findViewById(R.id.img);
            textView2 = view.findViewById(R.id.textView2);
            textView3 = view.findViewById(R.id.textView3);
            textView4 = view.findViewById(R.id.textView4);
        }
    }
}
