package com.example.tsipourman;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        public LabelsHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.label_name);
            desc=itemView.findViewById(R.id.label_desc);

        }
    }
}
