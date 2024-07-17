package com.example.prm392_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.prm392_project.dal.StorageDAO;
import com.example.prm392_project.model.Storage;

import java.util.ArrayList;
import java.util.List;

public class InforCard extends AppCompatActivity {

    TextView cardNumber, serialNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_card);
        cardNumber = findViewById(R.id.txtCard);
        serialNumber = findViewById(R.id.txtSerial);
        StorageDAO storageDAO = new StorageDAO();
        // List<Storage> stringList = new ArrayList<Storage>();
        // stringList = storageDAO.MuaNgay(2, 3);
//        for (String item :stringList
//             ) {
//
//        };
        //    Intent intent = getIntent();
        //   int IdProduct = intent.getIntExtra("IdProduct",-1);
        //  int sl = 1;
        //   int productId = 1;
        Intent intent = getIntent();
        //  = intent.getIntExtra("IdProduct",-1);
        int sl = intent.getIntExtra("sl", -1);
        int productId = intent.getIntExtra("productId", -1);
        List<Storage> storageList = storageDAO.MuaNgay(sl, productId); // Lấy danh sách các đối tượng Storage

//        for (int i = 0; i < storageList.size(); i++) {
////            Storage storage = storageList.get(i);
////            String serialNumber1 = storage.getSerialNumber();
////            String cardNumber1 = storage.getCardNumber();
////
////            serialNumber.setText(serialNumber1);
////            cardNumber.setText(cardNumber1);
//
//        }

        List<String> serialList = new ArrayList<>();
        List<String> cardList = new ArrayList<>();
        for (Storage storage : storageList) {
            String serialNumber1 = storage.getSerialNumber();
            String cardNumber1 = storage.getCardNumber();
            serialList.add(serialNumber1);
            cardList.add(cardNumber1);

            serialNumber.setText(serialList.toString());
            cardNumber.setText(cardList.toString());
        }

    }
}