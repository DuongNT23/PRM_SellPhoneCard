package com.example.prm392_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        LocalDateTime now = LocalDateTime.now();

// Định dạng định dạng mong muốn (dd/MM/yyyy HH:mm:ss)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

// Chuyển đổi thành chuỗi theo định dạng
        String formattedDateTime = now.format(formatter);

// Chuyển đổi thành Timestamp
        Timestamp currentTimestamp = Timestamp.valueOf(formattedDateTime);
    }
}