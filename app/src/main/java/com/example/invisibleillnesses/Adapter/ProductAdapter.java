package com.example.invisibleillnesses.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.invisibleillnesses.Model.ProductModel;
import com.example.invisibleillnesses.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    Context  context;
    private List<ProductModel> plist;
    public ProductAdapter(Context ct,List<ProductModel> list ){
        context = ct;
        plist = list;

    }
    @NonNull
    @Override
    public ProductAdapter.ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.adapter_product, parent, false);
        return new ProductHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductHolder holder, int position) {
       ProductModel productModel = plist.get(position);
       holder.pName.setText(productModel.getName());
       holder.pPrice.setText(String.valueOf(productModel.getPrice()));
    }

    @Override
    public int getItemCount() {
        return plist.size();
    }

    public class ProductHolder extends RecyclerView.ViewHolder {
        TextView pPrice,pName;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            pPrice = itemView.findViewById(R.id.product_view_price);
            pName = itemView.findViewById(R.id.product_view_name);
        }
    }
}
