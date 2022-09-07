package com.example.tsipourman;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "labels")
public class LabelEntity {
        @PrimaryKey(autoGenerate = true)
        Integer id;

        @ColumnInfo(name = "name")
        String name;

        @ColumnInfo(name = "description")
        String description;

        @ColumnInfo(name = "suggestion")
        String suggestion;

        @ColumnInfo(name = "volume")
        String volume;

        @ColumnInfo(name = "price")
          String price;

        @ColumnInfo(name ="logo", typeAffinity = ColumnInfo.BLOB)
        Byte[] logo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Byte[] getLogo() {
        return logo;
    }

    public void setLogo(Byte[] logo) {
        this.logo = logo;
    }
}
