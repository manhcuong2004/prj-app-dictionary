package com.kieu.bainhom;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Favorite extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);

        CustomHeader customHeader = findViewById(R.id.customHeader);
        if (customHeader != null) {
            customHeader.setTitle("Từ yêu thích");
        }
    }
}
