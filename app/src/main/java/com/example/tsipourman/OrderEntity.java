package com.example.tsipourman;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "orders", foreignKeys = {
@ForeignKey(
        entity = UserEntity.class,
        parentColumns = {"userId"},
        childColumns = {"userId"},
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
),
@ForeignKey(
        entity = LabelEntity.class,
        parentColumns = {"labelId"},
        childColumns = {"labelId"},
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
)})


public class OrderEntity {

    @PrimaryKey
    @ColumnInfo(name = "orderId")
    int orderId;

    @ColumnInfo(name = "userId")
    int userId;

    @ColumnInfo(name = "labelId")
    int labelId;
}
