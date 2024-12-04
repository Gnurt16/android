package com.example.btl.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button; // Thêm import cho Button
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction; // Thêm import cho FragmentTransaction
import com.example.btl.R;
import com.example.btl.view.adapter.CartAdapter;
import com.example.btl.model.CartItem;

import java.util.ArrayList;

public class CartViewFragment extends Fragment implements CartAdapter.OnItemRemoveListener {

    private static ArrayList<CartItem> cartItems = new ArrayList<>();
    private static CartAdapter adapter;
    private static TextView tvTotalAmount;
    private Button btnPay; // Thêm biến cho nút thanh toán

    public CartViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.cart_view, container, false);

        ListView listView = view.findViewById(R.id.cart_items_list);
        tvTotalAmount = view.findViewById(R.id.tv_total_amount);
        btnPay = view.findViewById(R.id.btn_buy_now); // Khởi tạo nút thanh toán

        // Đảm bảo getActivity() không null
        if (getActivity() != null) {
            adapter = new CartAdapter(getActivity(), cartItems, this); // Truyền this làm listener
            listView.setAdapter(adapter);
        }

        updateTotalAmount(); // Tính tổng tiền ngay sau khi khởi tạo view

        // Thiết lập sự kiện cho nút thanh toán
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Kiểm tra xem có ít nhất một sản phẩm trong giỏ hàng
                if (cartItems.isEmpty()) {
                    // Hiển thị thông báo nếu giỏ hàng trống
                    // Bạn có thể sử dụng Toast hoặc Dialog
                    Toast.makeText(getActivity(), "Giỏ hàng trống!", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Tạo một instance của PaymentFragment
                PaymentFragment paymentFragment = new PaymentFragment();

                // Thực hiện chuyển đổi fragment
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, paymentFragment); // Thay thế với ID container của bạn
                transaction.addToBackStack(null); // Thêm vào back stack để người dùng có thể quay lại
                transaction.commit();
            }
        });

        return view;
    }

    public static void addToCart(CartItem item) {
        cartItems.add(item);
        if (adapter != null) {
            adapter.notifyDataSetChanged();
            updateTotalAmount(); // Cập nhật tổng tiền
        }
    }

    private static void updateTotalAmount() {
        int totalAmount = 0;

        for (CartItem item : cartItems) {
            String priceString = item.getPrice().replace(" VNĐ", "").replace(".", "").replace(",", "");

            try {
                int price = Integer.parseInt(priceString);
                totalAmount += price;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        if (tvTotalAmount != null) {
            tvTotalAmount.setText(String.format("%,d VNĐ", totalAmount));
        }
    }

    @Override
    public void onItemRemoved() {
        updateTotalAmount(); // Cập nhật tổng tiền khi sản phẩm bị xóa
    }
}
