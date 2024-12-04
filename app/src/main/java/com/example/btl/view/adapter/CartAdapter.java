package com.example.btl.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btl.R;
import com.example.btl.model.CartItem;

import java.util.List;

public class CartAdapter extends BaseAdapter {
    private Context context;
    private List<CartItem> cartItemList;
    private OnItemRemoveListener onItemRemoveListener; // Khai báo listener

    public CartAdapter(Context context, List<CartItem> cartItemList, OnItemRemoveListener onItemRemoveListener) {
        this.context = context;
        this.cartItemList = cartItemList;
        this.onItemRemoveListener = onItemRemoveListener; // Khởi tạo listener
    }

    @Override
    public int getCount() {
        return cartItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_cart_view, parent, false);
        }

        ImageView imageProduct = convertView.findViewById(R.id.image_product);
        TextView nameProduct = convertView.findViewById(R.id.name_product);
        TextView priceProduct = convertView.findViewById(R.id.price_product);
        Button btnRemove = convertView.findViewById(R.id.btn_remove); // Lấy nút xóa

        CartItem cartItem = cartItemList.get(position);
        imageProduct.setImageResource(cartItem.getImage());
        nameProduct.setText(cartItem.getName());
        priceProduct.setText(cartItem.getPrice());

        // Thiết lập sự kiện cho nút xóa
        btnRemove.setOnClickListener(v -> {
            removeItem(position);
            onItemRemoveListener.onItemRemoved(); // Gọi callback khi xóa
        });

        return convertView;
    }

    public void removeItem(int position) {
        cartItemList.remove(position);
        notifyDataSetChanged(); // Cập nhật giao diện
    }

    // Định nghĩa interface cho việc xóa sản phẩm
    public interface OnItemRemoveListener {
        void onItemRemoved();
    }
}
