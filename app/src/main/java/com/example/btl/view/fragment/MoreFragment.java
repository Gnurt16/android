package com.example.btl.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.btl.R;

public class MoreFragment extends Fragment {

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        // Khởi tạo các view
        TextView textTaiKhoan = view.findViewById(R.id.text_tai_khoan);
        TextView textLienHe = view.findViewById(R.id.text_lien_he);
        Button buttonDangXuat = view.findViewById(R.id.button_dang_xuat);

        // Xử lý sự kiện nhấn nút Đăng xuất
        buttonDangXuat.setOnClickListener(v -> {
            FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new LoginFragment());
            transaction.addToBackStack(null);  // Để quay lại khi nhấn nút back
            transaction.commit();
        });

        return view;
    }
}
