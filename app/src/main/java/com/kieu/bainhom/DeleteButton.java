package com.kieu.bainhom;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
public class DeleteButton {
    private Context context;
    private Button deleteButton;
    public DeleteButton(Context context, Button button) {
        this.context = context;
        this.deleteButton = button;
        setupDeleteButton();
    }
    private void setupDeleteButton() {
        // Thiết lập sự kiện nhấn nút
        deleteButton.setOnClickListener(v -> showConfirmationDialog());
    }
    private void showConfirmationDialog() {
        // Tạo dialog xác nhận
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Xác nhận xóa")
                .setMessage("Bạn có chắc chắn muốn xóa không?")
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Thực hiện hành động xóa ở đây
                        // Ví dụ: Xóa dữ liệu, thực hiện một hành động nào đó
                    }
                })
                .setNegativeButton("Không", null); // Đóng dialog nếu chọn Không

        AlertDialog dialog = builder.create();
        dialog.show(); // Hiển thị dialog
    }
}
