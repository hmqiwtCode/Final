package com.example.final_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderProduct extends AppCompatActivity implements IProduct{

    private TextView lblTotalProduct, lblTotalMoney;
    private Button button3;
    private RecyclerView rview;
    private AdapterItemPayment adapterItemPayment;
    private List<OrderAnimal> listOrderAnimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_product);
        lblTotalProduct = findViewById(R.id.textView11);
        lblTotalMoney = findViewById(R.id.textView13);
        button3 = findViewById(R.id.button3);
        rview = findViewById(R.id.rview);
        listOrderAnimal = new ArrayList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    listOrderAnimal = AnimalDatabase.getInstanceAnimal(OrderProduct.this).getDAOAnimal().getOrders();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            calQuantityAndMoney(listOrderAnimal);
                            rview.setLayoutManager(new LinearLayoutManager(OrderProduct.this));
                            adapterItemPayment = new AdapterItemPayment(OrderProduct.this,listOrderAnimal,OrderProduct.this);
                            rview.setAdapter(adapterItemPayment);
                        }
                    });
                }catch (Exception e){

                }
            }
        }).start();



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            AnimalDatabase.getInstanceAnimal(OrderProduct.this).getDAOAnimal().deleteAll();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(OrderProduct.this,MainActivity.class);
                                    startActivity(intent);
                                }
                            });
                        }catch (Exception e){

                        }
                    }
                }).start();

            }
        });

    }



    @Override
    public void deleteListener(OrderAnimal order) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    AnimalDatabase.getInstanceAnimal(OrderProduct.this).getDAOAnimal().delOrderAnimal(order);
                    listOrderAnimal.remove(order);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            calQuantityAndMoney(listOrderAnimal);
                            adapterItemPayment.setListOrderAnimal(listOrderAnimal);
                            Toast.makeText(OrderProduct.this, "Cap nhat thanh cong", Toast.LENGTH_SHORT).show();
                        }
                    });
                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        }).start();
    }


    void calQuantityAndMoney(List<OrderAnimal> list){
        double totalMoney = listOrderAnimal.stream().mapToDouble(OrderAnimal::getPrices).sum();
        int totalQuantity = listOrderAnimal.stream().mapToInt(OrderAnimal::getSl).sum();
        lblTotalProduct.setText(totalQuantity+"");
        lblTotalMoney.setText(totalMoney+"");
    }
}