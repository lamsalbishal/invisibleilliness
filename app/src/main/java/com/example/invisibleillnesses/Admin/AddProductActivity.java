package com.example.invisibleillnesses.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.invisibleillnesses.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddProductActivity extends AppCompatActivity {

    Button button;
    EditText productName, productPrice, productDesigner, productSize, productRefundable, productWeekend, productShortDes, productDescription;

    private AwesomeValidation awesomeValidation;
    FirebaseFirestore fStore;
    ProgressDialog progressDialog;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        toolbar.setTitle("Add Product");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        button = findViewById(R.id.product_create);
        productName = findViewById(R.id.product_name);
        productPrice = findViewById(R.id.product_price);
        productDesigner = findViewById(R.id.product_designer);
        productSize = findViewById(R.id.product_size);
        productRefundable = findViewById(R.id.product_refundable_deposit);
        productWeekend = findViewById(R.id.product_weekend_hire);
        productShortDes = findViewById(R.id.product_short_description);
        productDescription = findViewById(R.id.product_description);

        fStore = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.product_name, RegexTemplate.NOT_EMPTY, R.string.valid_product_name);
        awesomeValidation.addValidation(this, R.id.product_price, RegexTemplate.NOT_EMPTY, R.string.valid_product_price);
        awesomeValidation.addValidation(this, R.id.product_designer, RegexTemplate.NOT_EMPTY, R.string.valid_product_price);
        awesomeValidation.addValidation(this, R.id.product_size, RegexTemplate.NOT_EMPTY, R.string.valid_product_price);
        awesomeValidation.addValidation(this, R.id.product_refundable_deposit, RegexTemplate.NOT_EMPTY, R.string.valid_product_price);
        awesomeValidation.addValidation(this, R.id.product_weekend_hire, RegexTemplate.NOT_EMPTY, R.string.valid_product_price);
        awesomeValidation.addValidation(this, R.id.product_short_description, RegexTemplate.NOT_EMPTY, R.string.valid_product_price);
        awesomeValidation.addValidation(this, R.id.product_description, RegexTemplate.NOT_EMPTY, R.string.valid_product_price);

        fStore = FirebaseFirestore.getInstance();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (awesomeValidation.validate()) {

                        progressDialog.show();

                        String name = productName.getText().toString();
                        String price = productPrice.getText().toString();
                        String designer = productDesigner.getText().toString();
                        String size = productSize.getText().toString();
                        String refundable = productRefundable.getText().toString();
                        String weekend = productWeekend.getText().toString();
                        String shortDescription = productShortDes.getText().toString();
                        String description = productDescription.getText().toString();
                        String id = UUID.randomUUID().toString();

                        Map<String, Object> productInfo = new HashMap<>();
                        productInfo.put("id", id);
                        productInfo.put("name", name);
                        productInfo.put("price", price);
                        productInfo.put("designer", designer);
                        productInfo.put("size", size);
                        productInfo.put("refundable", refundable);
                        productInfo.put("weekend_hire", weekend);
                        productInfo.put("short_description", shortDescription);
                        productInfo.put("description", description);

                        fStore.collection("product").document(id)
                                .set(productInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(AddProductActivity.this, "Success", Toast.LENGTH_SHORT).show();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(AddProductActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                } catch (Exception e) {

                }
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}