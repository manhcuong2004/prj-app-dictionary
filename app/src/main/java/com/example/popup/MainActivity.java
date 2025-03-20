package com.example.popup;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.example.popup.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gọi popup khi mở app
        showCancelDialog();
    }

    private void showCancelDialog() {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_cancel);
        dialog.setCancelable(false); // Không cho bấm ngoài để tắt

        dialog.show();
    }
}
