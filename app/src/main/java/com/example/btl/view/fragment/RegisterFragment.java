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

public class RegisterFragment extends Fragment {

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.dang_ky, container, false);

        // Khởi tạo các view
        EditText editTextUsername = view.findViewById(R.id.editTextRegisterUsername);
        EditText editTextPassword = view.findViewById(R.id.editTextRegisterPassword);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        // Khởi tạo DatabaseHelper
        DatabaseHelper db = new DatabaseHelper(getContext());

        // Xử lý sự kiện đăng ký
        buttonRegister.setOnClickListener(v -> {
            String username = editTextUsername.getText().toString();
            String password = editTextPassword.getText().toString();

            // Kiểm tra nếu tên người dùng và mật khẩu không rỗng
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng nhập tên tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
                return;
            }

            // Thêm logic để kiểm tra và lưu tài khoản vào cơ sở dữ liệu
            // Giả sử bạn đã có hàm db.addUser(username, password);

            // Thêm người dùng vào cơ sở dữ liệu
            if (db.addUser(username, password)) {
                Toast.makeText(getContext(), "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

                // Chuyển hướng đến màn hình chính
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new HomeFragment());
                transaction.addToBackStack(null);  // Để quay lại khi nhấn nút back
                transaction.commit();
            } else {
                Toast.makeText(getContext(), "Đăng ký không thành công, tên tài khoản có thể đã tồn tại", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
