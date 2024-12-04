package com.example.btl.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.btl.R;
import com.example.btl.model.CartItem;

public class ProductDetailFragment extends Fragment {

    private ImageView productImage;
    private TextView productName, productPrice, productSpecifications, productDescription;
    private Button btnAddToCart;

    public ProductDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.product_detail, container, false);

        // Nhận dữ liệu từ bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            int imageResId = bundle.getInt("productImage");
            String name = bundle.getString("productName");
            String price = bundle.getString("productPrice");
            String specifications = bundle.getString("productSpecifications");
            String description = bundle.getString("productDescription");

            // Gán dữ liệu vào các view
            productImage = view.findViewById(R.id.productImage);
            productName = view.findViewById(R.id.productName);
            productPrice = view.findViewById(R.id.productPrice);
            productSpecifications = view.findViewById(R.id.productSpecifications);
            productDescription = view.findViewById(R.id.productDescription);

            productImage.setImageResource(imageResId);
            productName.setText(name);
            productPrice.setText(price);
            productSpecifications.setText(specifications);
            productDescription.setText(description);

            // Sự kiện nhấn vào nút "Thêm vào giỏ hàng"
            btnAddToCart = view.findViewById(R.id.addToCartButton);
            btnAddToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Tạo CartItem từ thông tin sản phẩm
                    CartItem cartItem = new CartItem(name, imageResId, price);

                    // Thêm sản phẩm vào giỏ hàng
                    CartViewFragment.addToCart(cartItem);

                    // Chuyển đến CartViewFragment để xem giỏ hàng
                    CartViewFragment cartFragment = new CartViewFragment();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, cartFragment);
                    transaction.addToBackStack(null); // Thêm vào ngăn xếp để quay lại
                    transaction.commit();
                }
            });
        }

        return view;
    }
}
