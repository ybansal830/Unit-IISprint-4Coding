package com.myfirst.unit_iisprint_4coding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreen extends AppCompatActivity implements OnClickListener{

    private RecyclerView mRecyclerView;
    private CovidAdapter covidAdapter;
    private List<ResponseCovid> responseCovid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initViews();
        callApi();
    }

    private void callApi() {
        ApiServices apiServices = Network.getInstance().create(ApiServices.class);
        apiServices.getPosts().enqueue(new Callback<List<ResponseCovid>>() {
            @Override
            public void onResponse(Call<List<ResponseCovid>> call, Response<List<ResponseCovid>> response) {
                responseCovid = response.body();
                setAdapter();
            }

            @Override
            public void onFailure(Call<List<ResponseCovid>> call, Throwable t) {

            }
        });
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.recyclerView);
    }
    public void setAdapter(){
        covidAdapter = new CovidAdapter(responseCovid,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setAdapter(covidAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onLongClick(int position) {
        responseCovid.remove(position);
        covidAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra("url","https://www.masaischool.com/");
        startActivity(intent);
    }
}