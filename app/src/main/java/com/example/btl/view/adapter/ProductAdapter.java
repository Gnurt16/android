package com.example.btl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btl.R;
import com.example.btl.view.activity.MainActivity;
import com.example.btl.view.fragment.ProductDetailFragment;
import com.example.btl.model.Product;
import java.util.List;
import android.os.Bundle;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.productPrice.setText(product.getPrice());
        holder.productImage.setImageResource(product.getImageResId());

        // Xử lý sự kiện nhấp vào sản phẩm
        holder.itemView.setOnClickListener(v -> {
            // Chuyển đến ProductDetailFragment
            ProductDetailFragment productDetailFragment = new ProductDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("productImage", product.getImageResId());
            bundle.putString("productName", product.getName());
            bundle.putString("productPrice", product.getPrice());
            bundle.putString("productSpecifications", product.getSpecifications());
            bundle.putString("productDescription", product.getDescription());
            productDetailFragment.setArguments(bundle);

            // Thay thế fragment
            ((MainActivity) context).getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, productDetailFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void updateList(List<Product> filteredList) {
        productList = filteredList; // Cập nhật danh sách sản phẩm
        notifyDataSetChanged(); // Thông báo RecyclerView cập nhật lại dữ liệu
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView productImage;
        TextView productName;
        TextView productPrice;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
        }
    }
}
