package com.example.tsipourman;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface OrderDao {

    @Insert
    void insert(OrderEntity orders);

    @Delete
    void delete(OrderEntity orders);

    @Query("SELECT a.*,b.*,c.* FROM orders a,users b, labels c where a.userId=b.userId and c.labelId= a.labelId order by a.orderId")
    LiveData<List<OrderEntity>> getAllOrders();


}
