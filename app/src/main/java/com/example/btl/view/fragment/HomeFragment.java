package com.example.btl.view.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.btl.R;
import com.example.btl.view.adapter.ProductAdapter;
import com.example.btl.model.Product;
import com.example.btl.model.ProductData;
import com.example.btl.view.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private AutoCompleteTextView searchBar; // Sử dụng AutoCompleteTextView
    private ImageView cartIcon;
    private ProductAdapter adapter;
    private List<Product> productList; // Danh sách sản phẩm
    private List<String> productNames; // Danh sách tên sản phẩm

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        searchBar = view.findViewById(R.id.search_bar); // Nhận thanh tìm kiếm
        cartIcon = view.findViewById(R.id.cart); // Nhận biểu tượng giỏ hàng

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // 2 cột

        // Thêm dữ liệu sản phẩm mẫu
        productList = ProductData.getProductList();
        productNames = new ArrayList<>();

        // Lưu danh sách tên sản phẩm
        for (Product product : productList) {
            productNames.add(product.getName());
        }

        // Khởi tạo ProductAdapter và truyền context cùng danh sách sản phẩm
        adapter = new ProductAdapter(productList, getContext());
        recyclerView.setAdapter(adapter);

        // Cài đặt adapter cho AutoCompleteTextView
        ArrayAdapter<String> suggestionsAdapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_dropdown_item_1line,
                productNames
        );
        searchBar.setAdapter(suggestionsAdapter);

        // Xử lý sự kiện tìm kiếm
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filterProducts(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // Xử lý sự kiện nhấn vào giỏ hàng
        cartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCartViewFragment();
            }
        });

        return view;
    }

    private void filterProducts(String query) {
        // Lọc sản phẩm theo tên
        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(product);
            }
        }
        // Cập nhật adapter với danh sách đã lọc
        adapter.updateList(filteredList);
    }

    private void openCartViewFragment() {
        // Chuyển hướng đến CartViewFragment
        CartViewFragment cartFragment = new CartViewFragment();
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, cartFragment);
        transaction.addToBackStack(null); // Thêm vào back stack nếu cần
        transaction.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Hiện Bottom Navigation Bar khi quay lại HomeFragment
        ((MainActivity) getActivity()).showBottomNavigation();
    }
}
