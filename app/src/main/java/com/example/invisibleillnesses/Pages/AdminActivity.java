package com.example.invisibleillnesses.Pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.invisibleillnesses.Admin.AddProductActivity;
import com.example.invisibleillnesses.Admin.AdminProductActivity;
import com.example.invisibleillnesses.Dialog.LogoutDialog;
import com.example.invisibleillnesses.R;

public class AdminActivity extends AppCompatActivity {

    CardView productCardView,eventCardView;
    Button logOutBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin2);
        productCardView = findViewById(R.id.product_view_box);
        logOutBox = findViewById(R.id.logout_button);
        productCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdminActivity.this, AdminProductActivity.class);
                startActivity(i);
            }
        });

        logOutBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogoutDialog logoutDialog = new LogoutDialog();
                logoutDialog.show(getSupportFragmentManager(), "Logout Dialog Box");
            }
        });
    }
}