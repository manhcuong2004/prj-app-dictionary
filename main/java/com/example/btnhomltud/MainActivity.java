package com.example.btnhomltud;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText edtSearch;
    private ImageView iconHeart;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.parseColor("#0066FF")); // Đổi màu xanh
        }
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Lấy ID của layout chính
        View mainLayout = findViewById(R.id.main_layout); // Kiểm tra ID

        if (mainLayout != null) { // Tránh lỗi NullPointerException
            ViewCompat.setOnApplyWindowInsetsListener(mainLayout, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }
        // Ánh xạ các thành phần
        edtSearch = findViewById(R.id.edt_search);
        iconHeart = findViewById(R.id.icon_heart); // Dấu ❌
        listView = findViewById(R.id.listView);
        // Ẩn danh sách ban đầu
        listView.setVisibility(View.GONE);
        // Xóa nội dung khi nhấn ❌
        iconHeart.setOnClickListener(v -> {
            edtSearch.setText(""); // Xóa nội dung tìm kiếm
            edtSearch.clearFocus(); // Bỏ focus để ẩn bàn phím
            listView.setVisibility(View.GONE);
        });
        // Hiện danh sách khi nhập chữ
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    listView.setVisibility(View.VISIBLE); // Hiện danh sách
                } else {
                    listView.setVisibility(View.GONE); // Ẩn danh sách nếu không có chữ
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}