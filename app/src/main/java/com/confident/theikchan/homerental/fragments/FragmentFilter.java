package com.confident.theikchan.homerental.fragments;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.confident.theikchan.homerental.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentFilter extends android.support.v4.app.DialogFragment implements View.OnClickListener {


    ImageButton imgBtnBedDec,imgBtnBedInc,imgBtnBathDec,imgBtnBathInc;

    //// max bed and bath no is 5 ///////////////

    int curBedNo=0,curBathNo=0;

    TextView txtNoBed,txtNoBath;

    CheckBox chkParking,chkPet;

    /////////////////////////////// spinner data //////////////////////////////////

    List<String> mTownship = new ArrayList<>();
    List<String> mMinPrice = new ArrayList<>();
    List<String> mMaxPrice = new ArrayList<>();
    List<String> mMinSquare = new ArrayList<>();
    List<String> mMaxSquare = new ArrayList<>();

    //////////////////////////////// adapter ////////////////////////////////////
    ArrayAdapter<String> adSpinner;

    // Spinner element
    Spinner spTownship = null, spMinPrice = null,spMaxPrice=null,spMinSquare=null,spMaxSquare;

    public FragmentFilter newInstance() {
        FragmentFilter dFragment = new FragmentFilter();
        //dFragment.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        return dFragment;
    }

	/*@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
		Dialog dialog = super.onCreateDialog(savedInstanceState);
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return dialog;
	}

	@Override
	public void onStart() {
		super.onStart();
		Dialog dialog = getDialog();
		if (dialog != null) {

			int width = (int)(getResources().getDisplayMetrics().widthPixels*0.80);
			int height = (int)(getResources().getDisplayMetrics().heightPixels*0.80);

			dialog.getWindow().setLayout(width, height);

			//dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		}
	}*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lay_filter, container);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //getDialog().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Rect displayRectangle = new Rect();
        Window window = getDialog().getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(displayRectangle);

        view.setMinimumWidth((int) (displayRectangle.width() * 0.8f));
        view.setMinimumHeight(WindowManager.LayoutParams.WRAP_CONTENT/*(int) (displayRectangle.height() * 0.5f*/);

        onLoadView(view);

        return view;
    }

    private void onLoadView(View v) {

        spTownship=(Spinner)v.findViewById(R.id.lay_filter_sp_township);
        spMinPrice=(Spinner)v.findViewById(R.id.lay_filter_sp_min_price);
        spMaxPrice=(Spinner)v.findViewById(R.id.lay_filter_sp_max_price);
        spMinSquare=(Spinner)v.findViewById(R.id.lay_filter_sp_min_square);
        spMaxSquare=(Spinner)v.findViewById(R.id.lay_filter_sp_max_square);

        imgBtnBedDec=(ImageButton)v.findViewById(R.id.lay_filter_btn_dec_bed);
        imgBtnBedInc=(ImageButton)v.findViewById(R.id.lay_filter_btn_inc_bed);
        imgBtnBathDec=(ImageButton)v.findViewById(R.id.lay_filter_btn_dec_bath);
        imgBtnBathInc=(ImageButton)v.findViewById(R.id.lay_filter_btn_inc_bath);

        imgBtnBedDec.setOnClickListener(this);
        imgBtnBedInc.setOnClickListener(this);
        imgBtnBathDec.setOnClickListener(this);
        imgBtnBathInc.setOnClickListener(this);

        txtNoBed=(TextView)v.findViewById(R.id.lay_filter_lbl_bed_no);

        txtNoBath=(TextView)v.findViewById(R.id.lay_filter_lbl_bath_no);

        bindAdapter();
    }

    private void bindAdapter(){

        ////////// for township /////////////////////////////////////////

        adSpinner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mTownship);
        adSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spTownship.setAdapter(adSpinner);

        ///////////// for min price ///////////////////////////////////
        adSpinner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mMinPrice);
        adSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMinPrice.setAdapter(adSpinner);


        //////////////// for max price /////////////////////////////
        adSpinner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mMaxPrice);
        adSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMaxPrice.setAdapter(adSpinner);


        /////////////// for min square /////////////////////////////
        adSpinner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mMinSquare);
        adSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMinSquare.setAdapter(adSpinner);


        /////////////////// for max square //////////////////////
        adSpinner = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, mMaxSquare);
        adSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spMaxSquare.setAdapter(adSpinner);



    }

    @Override
    public void onClick(View view) {
        // TODO Auto-generated method stub
        switch (view.getId()) {
            //getActivity().recreate();
            //this.dismiss(); //to close dialog

			/*// reload this screen again
			Intent intent = getActivity().getIntent();
			this.dismiss();
			startActivity(intent);*/

            case R.id.lay_filter_btn_dec_bed:
                /*if(curBedNo!=0 && curBedNo!=5){
                    imgBtnBedDec.setEnabled(true);
                    imgBtnBedInc.setEnabled(true);
                }*/

                if(curBedNo>0 ){
                    curBedNo--;

                }/*else if(curBedNo==0){
                    imgBtnBedDec.setEnabled(false);
                }*/

                txtNoBed.setText(String.valueOf(curBedNo));
                Log.e("CLICK","DEC BED");

                break;

            case R.id.lay_filter_btn_inc_bed:
                /*if(curBedNo!=0 && curBedNo!=5){
                    imgBtnBedDec.setEnabled(true);
                    imgBtnBedInc.setEnabled(true);
                }*/
                if( curBedNo<5){
                    curBedNo++;
                }/*else if(curBedNo==5){
                    imgBtnBedInc.setEnabled(false);
                }*/
                txtNoBed.setText(String.valueOf(curBedNo));
                Log.e("CLICK","INC BED");
                break;

            case R.id.lay_filter_btn_dec_bath:
                /*if(curBathNo!=0 && curBathNo!=5){
                    imgBtnBathDec.setEnabled(true);
                    imgBtnBathInc.setEnabled(true);
                }*/

                if(curBathNo>0 ){
                    curBathNo--;

                }/*else if(curBathNo==0){
                    imgBtnBathDec.setEnabled(false);
                }*/
                txtNoBath.setText(String.valueOf(curBathNo));
                Log.e("CLICK","DEC BATH");
                break;

            case R.id.lay_filter_btn_inc_bath:
                /*if(curBathNo!=0 && curBathNo!=5){
                    imgBtnBathDec.setEnabled(true);
                    imgBtnBathInc.setEnabled(true);
                }*/
                if( curBathNo<5){
                    curBathNo++;
                }/*else if(curBathNo==5){
                    imgBtnBathInc.setEnabled(false);
                }*/
                txtNoBath.setText(String.valueOf(curBathNo));
                Log.e("CLICK","INC BATH");
                break;

        }
    }

    /////////  get spinner data ///////////////////////

    private void getData(){

        ////////////////// for township ////////////////
        mTownship.add("Hlaing");
        mTownship.add("Sanchaung");
        mTownship.add("Kamayut");
        mTownship.add("Mayan Gone");
        mTownship.add("Hlaing Tar Yar");
        mTownship.add("Shwe Pyi Tar");

        ////////////////// for min price ////////////////
        mMinPrice.add("1");
        mMinPrice.add("2");
        mMinPrice.add("3");
        mMinPrice.add("4");
        mMinPrice.add("5");
        mMinPrice.add("6");
        mMinPrice.add("7");
        mMinPrice.add("8");
        mMinPrice.add("9");
        mMinPrice.add("10");


        ////////////////// for max price ////////////////
        mMaxPrice.add("2");
        mMaxPrice.add("3");
        mMaxPrice.add("4");
        mMaxPrice.add("5");
        mMaxPrice.add("6");
        mMaxPrice.add("7");
        mMaxPrice.add("8");
        mMaxPrice.add("9");
        mMaxPrice.add("10");

        ////////////////// for min square ////////////////
        mMinSquare.add("1200");
        mMinSquare.add("1400");
        mMinSquare.add("1500");
        mMinSquare.add("1600");
        mMinSquare.add("1700");
        mMinSquare.add("1800");
        mMinSquare.add("1900");
        mMinSquare.add("2000");
        mMinSquare.add("2200");

        ////////////////// for max square ////////////////
        mMaxSquare.add("1400");
        mMaxSquare.add("1500");
        mMaxSquare.add("1600");
        mMaxSquare.add("1700");
        mMaxSquare.add("1800");
        mMaxSquare.add("1900");
        mMaxSquare.add("2000");
        mMaxSquare.add("2200");

    }

}
