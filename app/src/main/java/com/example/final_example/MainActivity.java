package com.example.final_example;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView lvdata;
    private ItemAdapter itemAdapter;
    private List<Animal> listAnimal;
    private EditText txtSearch;
    private FloatingActionButton floatingActionButton;
    private List<String> dataSpinner = new ArrayList<>();
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAnimal = new ArrayList<>();
        txtSearch = findViewById(R.id.editTextTextPersonName);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        dataSpinner.add("Kaka");
        dataSpinner.add("Hihi");
        dataSpinner.add("Chatchat");
        dataSpinner.add("chanchan");


        listAnimal.add(new Animal(1,"Lion","Kaka",R.drawable.animal5,50000));
        listAnimal.add(new Animal(2,"Cat","Kaka",R.drawable.animal5,60000));
        listAnimal.add(new Animal(3,"Dog","Kaka",R.drawable.animal5,70000));
        listAnimal.add(new Animal(4,"Big","Kaka",R.drawable.animal5,80000));
        listAnimal.add(new Animal(5,"Chicken","Kaka",R.drawable.animal5,90000));
        listAnimal.add(new Animal(6,"Horse","Kaka",R.drawable.animal5,67000));

        lvdata = findViewById(R.id.lvdata);
        lvdata.setLayoutManager(new LinearLayoutManager(this));
        itemAdapter = new ItemAdapter(this,listAnimal);
        lvdata.setAdapter(itemAdapter);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View viewLayout = LayoutInflater.from(MainActivity.this).inflate(R.layout.add_animal_layout,null);
                spinner = viewLayout.findViewById(R.id.spinner);
                TextView editTextTextPersonName2,editTextTextPersonName3;
                Button btn4;

                editTextTextPersonName2 = viewLayout.findViewById(R.id.editTextTextPersonName2);
                editTextTextPersonName3 = viewLayout.findViewById(R.id.editTextTextPersonName3);
                btn4 = viewLayout.findViewById(R.id.button4);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,dataSpinner);
                spinner.setAdapter(adapter);


                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Add");
                dialog.setView(viewLayout);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, dataSpinner.get(i), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });


                AlertDialog formDis = dialog.create();
                formDis.show();

                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Animal animal = new Animal(editTextTextPersonName2.getText().toString(),spinner.getSelectedItem().toString(),R.drawable.animal5,Double.parseDouble(editTextTextPersonName3.getText().toString()));
                        listAnimal.add(animal);
                        itemAdapter.setListAnimal(listAnimal);
                        Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                        formDis.dismiss();

                    }
                });



            }
        });





        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                itemAdapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}