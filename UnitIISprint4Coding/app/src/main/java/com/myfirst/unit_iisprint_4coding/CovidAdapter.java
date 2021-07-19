package com.myfirst.unit_iisprint_4coding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CovidAdapter extends RecyclerView.Adapter<CovidViewHolder> {

    private List<ResponseCovid> responseCovid;
    private OnClickListener onClickListener;

    public CovidAdapter(List<ResponseCovid> responseCovid,OnClickListener onClickListener) {
        this.responseCovid = responseCovid;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public CovidViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_covid,
                parent,false);
        return new CovidViewHolder(view,onClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CovidViewHolder holder, int position) {
        holder.setData(responseCovid.get(position));
    }

    @Override
    public int getItemCount() {
        return responseCovid.size();
    }
}
