package com.example.btl.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.btl.R;
import com.example.btl.model.DatabaseHelper;
import com.example.btl.view.activity.MainActivity;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Ẩn Bottom Navigation Bar
        ((MainActivity) getActivity()).hideBottomNavigation();

        // Khởi tạo các view
        EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextPassword);
        Button buttonLogin = view.findViewById(R.id.buttonLogin);
        Button buttonRegisterRedirect = view.findViewById(R.id.buttonRegisterRedirect);

        // Khởi tạo DatabaseHelper
        DatabaseHelper db = new DatabaseHelper(getContext());

        // Xử lý sự kiện đăng nhập
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Kiểm tra nếu tên người dùng và mật khẩu không rỗng
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getContext(), "Hãy nhập tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Kiểm tra thông tin đăng nhập
                if (db.checkUser(username, password)) {
                    Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    // Ẩn tùy chọn đăng nhập trong thanh điều hướng
                    ((MainActivity) getActivity()).hideLoginOption();
                    // Chuyển hướng đến màn hình chính (HomeFragment)
                    FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragment_container, new HomeFragment());
                    transaction.addToBackStack(null);  // Để quay lại khi nhấn nút back
                    transaction.commit();
                    // Hiện lại Bottom Navigation Bar khi chuyển sang HomeFragment
                    ((MainActivity) getActivity()).showBottomNavigation();
                } else {
                    Toast.makeText(getContext(), "Tài khoản hoặc mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Xử lý sự kiện chuyển hướng đến màn hình đăng ký
        buttonRegisterRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new RegisterFragment());
                transaction.addToBackStack(null);  // Để quay lại khi nhấn nút back
                transaction.commit();
            }
        });

        return view;
    }
}
