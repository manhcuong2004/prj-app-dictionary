package com.kieu.bainhom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

public class HomeButton extends CardView{
    private ImageView ivHome;

    public HomeButton(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init(context);
    }
    private void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.custom_home_button, this, true);
        ivHome = findViewById(R.id.ivHome);
    }

    public void setOnClickListener(View.OnClickListener listener){
        ivHome.setOnClickListener(listener);
    }


}
