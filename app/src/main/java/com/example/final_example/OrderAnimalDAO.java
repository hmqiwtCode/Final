package com.example.final_example;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface OrderAnimalDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addOrderAnimal(OrderAnimal animal);

    @Delete
    public void delOrderAnimal(OrderAnimal animal);

    @Query("select * from orders")
    public List<OrderAnimal> getOrders();

    @Query("DELETE FROM orders")
    public void deleteAll();
}
