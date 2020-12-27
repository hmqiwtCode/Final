package com.example.final_example;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;

public class FilterAnimal extends Filter {
    private List<Animal> listAnimal;
    private ItemAdapter itemAdapter;

    public FilterAnimal(List<Animal> listAnimal,ItemAdapter itemAdapter){
        this.listAnimal = listAnimal;
        this.itemAdapter = itemAdapter;
    }
    @Override
    protected FilterResults performFiltering(CharSequence charSequence) {
        List<Animal> listTemp = listAnimal;
        if (charSequence.toString().equalsIgnoreCase(""))
            listTemp = listAnimal;
        else {
            listTemp = getListAnimalByName(charSequence.toString());
        }
        FilterResults results = new FilterResults();
        results.values  = listTemp;
        results.count = listTemp.size();
        return results;
    }

    @Override
    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        itemAdapter.listAnimal = (List<Animal>) filterResults.values;
        itemAdapter.notifyDataSetChanged();
    }


    public List<Animal> getListAnimalByName(String name){
        List<Animal> listAnimal = new ArrayList<>();
        for (Animal animal : this.listAnimal){
            if (animal.getName().equalsIgnoreCase(name))
                listAnimal.add(animal);
        }
        return listAnimal;
    }
}
