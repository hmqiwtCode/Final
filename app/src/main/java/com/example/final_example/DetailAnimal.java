package com.example.final_example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DetailAnimal extends AppCompatActivity {

    private TextView textView5,textView6,lblSoLuong;
    private Button btnAdd, btnRemove,button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_animal);
        final Animal animal = (Animal) getIntent().getSerializableExtra("animal");
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);

        lblSoLuong = findViewById(R.id.textView8);
        btnAdd = findViewById(R.id.textView7);
        btnRemove = findViewById(R.id.textView9);
        button = findViewById(R.id.button);

        setInfo(animal);




        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuong = Integer.valueOf(lblSoLuong.getText().toString());
                soLuong++;
                lblSoLuong.setText(soLuong+"");
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int soLuong = Integer.valueOf(lblSoLuong.getText().toString());
                if (soLuong < 1 || soLuong == 1)
                    soLuong = 1;
                else {
                    soLuong--;
                }
                lblSoLuong.setText(soLuong+"");
            }
        });

        // add bag
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    @Override
                    public void run() {
                       try {
                           OrderAnimal orderAnimal = new OrderAnimal(animal.getId(),animal.getName(),animal.getDes(),animal.getBala(),Integer.valueOf(lblSoLuong.getText().toString()),animal.getPrices() *Integer.valueOf(lblSoLuong.getText().toString()));
                           AnimalDatabase.getInstanceAnimal(DetailAnimal.this).getDAOAnimal().addOrderAnimal(orderAnimal);
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Toast.makeText(DetailAnimal.this, "Thanh cong", Toast.LENGTH_SHORT).show();
                                   Intent intent = new Intent(DetailAnimal.this,OrderProduct.class);
                                   startActivity(intent);
                               }
                           });
                       }catch (Exception e){

                       }

                    }
                }.start();
            }
        });
    }

    void setInfo(Animal animal){
        textView5.setText(animal.getName());
        textView6.setText(animal.getDes());
    }
}