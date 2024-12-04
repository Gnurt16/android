package com.example.btl.view.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.btl.R;
import com.example.btl.view.fragment.DanhMucFragment;
import com.example.btl.view.fragment.HomeFragment;
import com.example.btl.view.fragment.LoginFragment;
import com.example.btl.view.fragment.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nav = findViewById(R.id.nav_bar);

        // Thiết lập fragment ban đầu (ví dụ trang chủ)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
        }

        nav.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int itemId = item.getItemId();
            if (itemId == R.id.home) {
                selectedFragment = new HomeFragment();
            } else if (itemId == R.id.danh_muc) {
                selectedFragment = new DanhMucFragment();
            } else if (itemId == R.id.login) {
                selectedFragment = new LoginFragment();
            } else if (itemId == R.id.more) {
                selectedFragment = new MoreFragment();
            } else {
                Toast.makeText(MainActivity.this, "Item không hợp lệ!", Toast.LENGTH_SHORT).show();
                return false;
            }

            if (selectedFragment != null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, selectedFragment);
                transaction.addToBackStack(null); // Thêm vào BackStack để có thể quay lại
                transaction.commit();
            }
            return true;
        });
    }

    public void hideBottomNavigation() {
        nav.setVisibility(View.GONE);
    }

    public void showBottomNavigation() {
        nav.setVisibility(View.VISIBLE);
    }

    public void hideLoginOption() {
        // Giả sử bạn có một menu hoặc NavigationView
        Menu menu = nav.getMenu();
        MenuItem loginItem = menu.findItem(R.id.login); // Thay đổi ID cho đúng
        if (loginItem != null) {
            loginItem.setVisible(false); // Ẩn tùy chọn đăng nhập
        }
    }
}
