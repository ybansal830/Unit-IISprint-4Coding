package com.myfirst.unit_iisprint_4coding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CovidViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvDate,mTvPositive,mTvNegative,mTvHospitalized,mTvOnVentilator,mTvDeath,
            mTvDateChecked;
    private RelativeLayout mRlLayout;
    private OnClickListener onClickListener;

    public CovidViewHolder(@NonNull View itemView,OnClickListener onClickListener) {
        super(itemView);
        this.onClickListener = onClickListener;
        initViews();
    }

    private void initViews() {
        mTvDate = itemView.findViewById(R.id.tvDate);
        mTvPositive = itemView.findViewById(R.id.tvPositive);
        mTvNegative = itemView.findViewById(R.id.tvNegative);
        mTvHospitalized = itemView.findViewById(R.id.tvHospitalized);
        mTvOnVentilator = itemView.findViewById(R.id.tvVentilator);
        mTvDeath = itemView.findViewById(R.id.tvDeath);
        mTvDateChecked = itemView.findViewById(R.id.dateChecked);
        mRlLayout = itemView.findViewById(R.id.rlLayout);
        mRlLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onClickListener.onLongClick(getAdapterPosition());
                return true;
            }
        });
        mRlLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick();
            }
        });
    }
    public void setData(ResponseCovid responseCovid){
        String temp = responseCovid.getDate() + "";
        String orderDate = "";
        orderDate += temp.substring(0,4);
        orderDate += "-";
        orderDate += temp.substring(4,6);
        orderDate += "-";
        orderDate += temp.substring(6,8);
        mTvDate.setText(orderDate);
        mTvPositive.setText(responseCovid.getPositive() + "");
        mTvNegative.setText(responseCovid.getNegative() + "");
        mTvHospitalized.setText(responseCovid.getHospitalizedCurrently() + "");
        mTvOnVentilator.setText(responseCovid.getOnVentilatorCurrently() + "");
        mTvDeath.setText(responseCovid.getDeath() + "");
        String orderDateChecked = "";
        temp = responseCovid.getDateChecked();
        orderDateChecked += temp.substring(0,10);
        mTvDateChecked.setText(orderDateChecked);
    }
}
