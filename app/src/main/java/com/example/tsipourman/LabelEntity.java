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


        @ColumnInfo(name = "price")
          String price;

        @ColumnInfo(name ="logo")
        String logo;

    public LabelEntity(Integer id, String name, String description, String suggestion, String price, String logo) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.suggestion = suggestion;
        this.price = price;
        this.logo = logo;
    }


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


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
