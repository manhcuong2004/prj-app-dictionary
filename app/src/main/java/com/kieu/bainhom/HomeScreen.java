package com.kieu.bainhom;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.cardview.widget.CardView;

public class HomeScreen {

    private Context context;

    // Constructor nhận context từ Activity
    public HomeScreen(Context context) {
        this.context = context;
    }

    public void setupCardViewFavorite() {
        // Tìm CardView trong Activity
        CardView cardViewFavorite = ((MainActivity) context).findViewById(R.id.cardView_Favourite);

        // Thiết lập sự kiện click cho CardView
        cardViewFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang Activity Favorite khi nhấn
                Intent intent = new Intent(context, Favorite.class);
                context.startActivity(intent);
            }
        });
    }
}
