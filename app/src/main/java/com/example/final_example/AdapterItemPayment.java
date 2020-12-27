package com.example.final_example;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.DialogCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterItemPayment extends RecyclerView.Adapter<AdapterItemPayment.ItemPayment> {
    private Context context;
    private List<OrderAnimal> listOrderAnimal;
    private IProduct iProduct;

    public  AdapterItemPayment(Context context,List<OrderAnimal> listOrderAnimal,IProduct iProduct){
        this.context = context;
        this.listOrderAnimal = listOrderAnimal;
        this.iProduct = iProduct;
    }


    @NonNull
    @Override
    public ItemPayment onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemPayment(LayoutInflater.from(context).inflate(R.layout.item_payment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPayment holder, int position) {
        OrderAnimal order = listOrderAnimal.get(position);

        holder.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Do you want to delete?");
                dialog.setMessage("You need to check before do this");
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        iProduct.deleteListener(order);
                    }
                });

                dialog.create().show();

            }
        });

        holder.img.setImageResource(order.getDala());
        holder.textView2.setText(order.getName());
        holder.textView3.setText(order.getDes());
        holder.textView4.setText(order.getPrices()+"");

    }

    @Override
    public int getItemCount() {
        return listOrderAnimal.size();
    }

    public void setListOrderAnimal(List<OrderAnimal> listOrderAnimal) {
        this.listOrderAnimal = listOrderAnimal;
        this.notifyDataSetChanged();
    }

    class ItemPayment extends RecyclerView.ViewHolder{

        private Button button2;
        private ImageView img;
        private TextView textView2, textView3, textView4;

        public ItemPayment(@NonNull View view) {
            super(view);

            button2 = view.findViewById(R.id.button2);
            img = view.findViewById(R.id.img);
            textView2 = view.findViewById(R.id.textView2);
            textView3 = view.findViewById(R.id.textView3);
            textView4 = view.findViewById(R.id.textView4);
        }
    }
}

interface IProduct{
    void deleteListener(OrderAnimal order);
}
