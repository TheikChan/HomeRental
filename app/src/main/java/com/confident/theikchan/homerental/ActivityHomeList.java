package com.confident.theikchan.homerental;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.confident.theikchan.homerental.adapter.AdapterHomeList;
import com.confident.theikchan.homerental.model.Home;

import java.util.ArrayList;

public class ActivityHomeList extends AppCompatActivity implements AdapterHomeList.onHotelItemClickListener {

    public static RecyclerView mRecyclerView;
    ArrayList<Home> mHotelArrayList;

    public AdapterHomeList adapterHotelList;

    ///////////////////  for slide show ///////////////////////////////

    /*public ViewPager mPager;
    public int currentPage = 0;
    public  int NUM_PAGES = 0;
    public final Integer[] IMAGES = {R.drawable.breeze_rest_house,  R.drawable.nawarat,R.drawable.pyone_pan_wail,
    R.drawable.sun_shine,R.drawable.shwe_myint_mo_htun,R.drawable.strand_hotel,R.drawable.sandalwood};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lay_rec_list);

        //init();
        onGetData();
        onLoadView();
    }

    private void onLoadView() {
        mRecyclerView = (RecyclerView) this.findViewById(R.id.lay_rec_view);
        mRecyclerView.setHasFixedSize(true);


        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setColorSchemeResources(
                R.color.pink, R.color.indigo, R.color.lime);

        swipeRefreshLayout.setOnRefreshListener(new     SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //refreshData();

                //swipeRefreshLayout.setRefreshing(false);//to close
            }
        });


        adapterHotelList = new AdapterHomeList(this, mHotelArrayList);
        mRecyclerView.setAdapter(adapterHotelList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
    }

    @Override
    public void onItemClick(View v, int position, int id) {

        Toast.makeText(getApplicationContext(), "U Click Position :" + position, Toast.LENGTH_SHORT).show();
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


    /////////////////////////////////////// for slide show ///////////////////////////////////////

    /*private void init() {

        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        mPager.setAdapter(new SlidingImage_Adapter(ActivityHotel.this, ImagesArray));
        indicator.setViewPager(mPager);
        mPager.setPageTransformer(true, new DepthPageTransformer());//for transaction animation

        final float density = getResources().getDisplayMetrics().density;

        indicator.setRadius(5 * density);

        NUM_PAGES = IMAGES.length;


        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 1500, 1500);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }*/


}
