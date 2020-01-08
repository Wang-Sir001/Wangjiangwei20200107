package com.bawei.wangjiangwei.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.wangjiangwei.R;
import com.bawei.wangjiangwei.model.HomeEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {

    private Context context;
    private List<HomeEntity.Home> list;

    public HomeAdapter(Context context, List<HomeEntity.Home> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.home_item_layout, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nameD.setText(list.get(position).categoryName);

        holder.twoRv.setLayoutManager(new LinearLayoutManager(context));

        holder.twoRv.setLayoutManager(new LinearLayoutManager(context));

        ProductAdapter productAdapter = new ProductAdapter(context,list.get(position).shoppingCartList);
        holder.twoRv.setAdapter(productAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.d_name)
        TextView nameD;
        @BindView(R.id.rv_two)
        RecyclerView twoRv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
