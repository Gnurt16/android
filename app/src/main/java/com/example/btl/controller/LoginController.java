// LoginActivity.java
package com.example.btl.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl.R;
import com.example.btl.view.activity.MainActivity;
import com.example.btl.model.DatabaseHelper;

public class LoginController extends AppCompatActivity {

    private EditText editTextUsername, editTextPassword;
    private Button buttonLogin;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_login);

        // Ánh xạ view
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        // Khởi tạo DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Xử lý sự kiện nút Login
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

                // Kiểm tra người dùng tồn tại
                if (dbHelper.checkUser(username, password)) {
                    Toast.makeText(LoginController.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    // Điều hướng sang màn hình chính hoặc một activity khác
                    startActivity(new Intent(LoginController.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginController.this, "Sai thông tin đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
