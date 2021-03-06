package com.confident.theikchan.homerental.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.confident.theikchan.homerental.R;
import com.confident.theikchan.homerental.adapter.AdapterHomeList;
import com.confident.theikchan.homerental.model.Home;

import java.util.ArrayList;


public class FragmentAll extends Fragment implements AdapterHomeList.onHotelItemClickListener {

    public static RecyclerView mRecyclerView;
    ArrayList<Home> mHotelArrayList;

    public AdapterHomeList adapterHotelList;

    public FragmentAll() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onGetData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.lay_rec_list, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.lay_rec_view);
        mRecyclerView.setHasFixedSize(true);


        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) v.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.pink, R.color.indigo, R.color.lime);

        swipeRefreshLayout.setOnRefreshListener(new     SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //refreshData();

                //swipeRefreshLayout.setRefreshing(false);//to close
            }
        });


        adapterHotelList = new AdapterHomeList(getActivity(), mHotelArrayList);
        mRecyclerView.setAdapter(adapterHotelList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /*mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
*/
        adapterHotelList.setOnHotelItemClickListener(this);

        return v;

    }

    @Override
    public void onItemClick(View v, int position, int id) {

        Toast.makeText(getActivity().getApplicationContext(), "U Click Position :" + position, Toast.LENGTH_SHORT).show();
        /*switch (id){
            case Adapter_DrinkList.KEY_BUY_FOOD:
                buyFood(v,p);
                Log.d("test", "onItemClick  buy Food  at position " + String.valueOf(p));
                adapter_drinkList.notifyDataSetChanged();
                break;
            case Adapter_DrinkList.KEY_ADD_FOOD:

                int count=mFoodArrayList.get(p).getCount();
                Log.d("countt", "delete food count "+String.valueOf(count));
                mFoodArrayList.get(p).setCount(count++);
                adapter_drinkList.notifyDataSetChanged();
                OnAddOrder(p);
                Log.d("test", "onItemClick add food at position"+String.valueOf(p));
                break;
            case Adapter_DrinkList.KEY_DELETE_FOOD:
                OnDeleteOrder(p);
                Log.d("text", "onItemClick at position" + String .valueOf(p));
                adapter_drinkList.notifyDataSetChanged();
                break;
        }*/


    }


    public void onGetData() {

        mHotelArrayList = new ArrayList<>();

        Home mHotel = new Home();
        mHotel.setmType("RENT");
        mHotel.setmName("Hlaing Mying Moe Villa");
        mHotel.setmPhone("09-974239130");
        mHotel.setmPrice("70");
        mHotel.setmAddress("Hlaing ,Yangon");
        mHotel.setmDescription("Hlaing Mying Moe Villa is one of the most international hotel in yangon");
        mHotel.setmBed(3);
        mHotel.setmBath(2);
        mHotel.setmSquare(2000);
        mHotel.setmParking("yes");
        mHotel.setmPet("no");
        mHotel.setmDate("December");
        mHotel.setmImage("R.drawable.img_villa");

        mHotelArrayList.add(mHotel);

        mHotel = new Home();
        mHotel.setmType("SALE");
        mHotel.setmName("Parami Condo");
        mHotel.setmPhone("09-974239130");
        mHotel.setmPrice("70");
        mHotel.setmAddress("Hlaing ,Yangon");
        mHotel.setmDescription("Parami Condo is one of the most international hotel in yangon");
        mHotel.setmBed(3);
        mHotel.setmBath(2);
        mHotel.setmSquare(2000);
        mHotel.setmParking("yes");
        mHotel.setmPet("no");
        mHotel.setmDate("December");
        mHotel.setmImage("R.drawable.img_villa");

        mHotelArrayList.add(mHotel);

    }


}
