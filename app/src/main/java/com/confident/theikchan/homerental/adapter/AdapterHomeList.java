package com.confident.theikchan.homerental.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.confident.theikchan.homerental.ActivityHomeDetail;
import com.confident.theikchan.homerental.ActivityHomeList;
import com.confident.theikchan.homerental.R;
import com.confident.theikchan.homerental.fragments.FragmentAll;
import com.confident.theikchan.homerental.model.Home;

import java.util.ArrayList;


public class AdapterHomeList extends RecyclerView.Adapter<AdapterHomeList.ViewHolder> {
    private Context mContext;
    private ArrayList<Home> mHotelArrayList;
    private int mPosition;
    public onHotelItemClickListener mOnHotelItemClickListener;


    public void setOnHotelItemClickListener(onHotelItemClickListener mOnHotelItemClickListener) {
        this.mOnHotelItemClickListener = mOnHotelItemClickListener;
    }


    public AdapterHomeList(Context mContext, ArrayList<Home> mHotelArrayList) {
        this.mContext = mContext;
        this.mHotelArrayList = mHotelArrayList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_home_item, parent, false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                int newposition = FragmentAll.mRecyclerView.getChildAdapterPosition(v);

                Toast.makeText(mContext,"Position: "+newposition,Toast.LENGTH_SHORT).show();

               mContext.startActivity(new Intent(mContext, ActivityHomeDetail.class));
            }
        });

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //holder.txtName.setTypeface(FontHelper.get(mContext, "zawgyi"));
        holder.txtName.setText(mHotelArrayList.get(position).getmName());
        holder.txtPrice.setText(mHotelArrayList.get(position).getmPrice());
        holder.txtAddress.setText(mHotelArrayList.get(position).getmAddress());
        holder.txtType.setPrimaryText(mHotelArrayList.get(position).getmType());
        holder.txtBed.setText(String.valueOf(mHotelArrayList.get(position).getmBed()));
        holder.txtBath.setText(String.valueOf(mHotelArrayList.get(position).getmBath()));
        holder.txtSquare.setText(String.valueOf(mHotelArrayList.get(position).getmSquare()));

        holder.imgPic.setImageResource(R.drawable.img_villa);
        mPosition = position;
        AddListenerToHolderItem(holder, position);
    }

    private void AddListenerToHolderItem(ViewHolder holder, final int position) {
        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnHotelItemClickListener.onItemClick(v, position, v.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mHotelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public TextView txtPrice;
        public jp.shts.android.library.TriangleLabelView txtType;
        public TextView txtAddress;
        public TextView txtBed;
        public TextView txtBath;
        public TextView txtSquare;
        public ImageView imgPic;


        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.lay_home_item_txt_title);
            txtPrice = (TextView) itemView.findViewById(R.id.lay_home_item_txt_price);
            txtType = (jp.shts.android.library.TriangleLabelView) itemView.findViewById(R.id.lay_home_item_txt_type);
            txtAddress = (TextView) itemView.findViewById(R.id.lay_home_item_txt_address);
            txtBed = (TextView) itemView.findViewById(R.id.lay_home_item_txt_bed);
            txtBath = (TextView) itemView.findViewById(R.id.lay_home_item_txt_bath);
            txtSquare = (TextView) itemView.findViewById(R.id.lay_home_item_txt_square);

            imgPic = (ImageView) itemView.findViewById(R.id.lay_home_item_img);

        }
    }

    public interface onHotelItemClickListener {
        void onItemClick(View v, int p, int id);
    }

}
