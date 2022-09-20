package com.example.tsipourman;

import static java.security.AccessController.getContext;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LabelsAdapter extends RecyclerView.Adapter<LabelsAdapter.LabelsHolder> {
    private List<LabelEntity> labels = new ArrayList<>();


    @NonNull
    @Override
    public LabelsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);

        return new LabelsHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LabelsHolder labelsHolder, int position) {

        LabelEntity curLabel = labels.get(position);
        labelsHolder.name.setText(curLabel.getName());
        labelsHolder.desc.setText(curLabel.getDescription());
        Picasso.get().load("https://imageproxy.wolt.com/menu/menu-images/615329284e88f5797fb4167c/7056382c-20fd-11ec-9f07-8e926c1a41c3_product__56_.jpeg").into(labelsHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }

    public void setLabels(List<LabelEntity> labels){
        this.labels=labels;
        notifyDataSetChanged();

    }

    class LabelsHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private TextView desc;
        private ImageView imageView;

        public LabelsHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.label_name);
            desc=itemView.findViewById(R.id.label_desc);
            imageView=itemView.findViewById(R.id.img_view);
        }
    }
}
