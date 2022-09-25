package com.example.tsipourman;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class UserEntity {

        @PrimaryKey(autoGenerate = true)
        Integer userId;

        @ColumnInfo(name = "username")
        String username;

        @ColumnInfo(name = "password")
        String password;

        @ColumnInfo(name = "email")
        String email;

        @ColumnInfo(name = "fname")
        String fname;

        @ColumnInfo(name = "lname")
        String lname;

        @ColumnInfo(name = "phone")
        String phone;

        public UserEntity() {

        }

        public Integer getUserId() {
                return userId;
        }

        public void setUserId(Integer userId) {
                this.userId = userId;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getFname() {
                return fname;
        }

        public void setFname(String fname) {
                this.fname = fname;
        }

        public String getLname() {
                return lname;
        }

        public void setLname(String lname) {
                this.lname = lname;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }
}
