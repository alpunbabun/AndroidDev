package com.example.androiddev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;


public class ProductAdapter extends FirestoreRecyclerAdapter<Product, ProductAdapter.ProductHolder> {


    public ProductAdapter(@NonNull FirestoreRecyclerOptions<Product> options) {
        super(options);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder productHolder, int position, @NonNull Product product) {
        productHolder.textViewProduct.setText(product.getProduct());
        productHolder.textViewSerialNumber.setText(product.getSerialNumber());
        productHolder.textViewBlock.setText(product.getBlock());
        productHolder.textViewFullname.setText(product.getFullname());
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,
                parent, false) ;
        return new ProductHolder(v);
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        TextView textViewProduct;
        TextView textViewSerialNumber;
        TextView textViewBlock;
        TextView textViewFullname;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            textViewProduct = itemView.findViewById(R.id.tv_product);
            textViewSerialNumber = itemView.findViewById(R.id.tv_serialNumber);
            textViewBlock = itemView.findViewById(R.id.tv_block);
            textViewFullname = itemView.findViewById(R.id.tv_fullName);
        }
    }

}
