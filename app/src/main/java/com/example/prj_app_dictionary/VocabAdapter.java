package com.example.prj_app_dictionary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VocabAdapter extends RecyclerView.Adapter<VocabHisHolder> {

    Context context;
    List<VocabHisModal> items;

    public VocabAdapter(Context context, List<VocabHisModal> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public VocabHisHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VocabHisHolder(LayoutInflater.from(context).inflate(R.layout.item_word, parent, false) );
    }

    @Override
    public void onBindViewHolder(@NonNull VocabHisHolder holder, int position) {
        VocabHisModal item = items.get(position);

        holder.word.setText(items.get(position).getWord());
        holder.pronounce.setText(items.get(position).getPronounce());
        holder.pos.setText(items.get(position).getPos());
        holder.meaning.setText(items.get(position).getMeaning());

        if (position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.parseColor("#E3F2FD")); // Màu xanh nhạt
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF")); // Màu trắng
        }
        holder.itemView.setOnClickListener(v -> {
            Context context = v.getContext();

            if (context instanceof Activity) {
                Intent intent = new Intent(context, ResultActivity.class);
                intent.putExtra("word", item.getWord());
                intent.putExtra("pronounce", item.getPronounce());
                intent.putExtra("pos", item.getPos());
                intent.putExtra("meaning", item.getMeaning());
                context.startActivity(intent);
            } else {
                Intent intent = new Intent(context, ResultActivity.class);
                intent.putExtra("word", item.getWord());
                intent.putExtra("pronounce", item.getPronounce());
                intent.putExtra("pos", item.getPos());
                intent.putExtra("meaning", item.getMeaning());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
