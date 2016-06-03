package com.confident.theikchan.homerental.model;

/**
 * Created by Min Thant Zin Tun on 9/17/2015.
 */
public class Home {

    String mType;
    String mName;
    String mPrice;
    String mAddress;
    String mPhone;

    int mBed,mBath,mSquare;

    String mImage;
    String mDate,mParking,mPet;
    String mDescription;

    public Home(){

    }

    public Home(String mType, String mName, String mPrice, String mAddress, String mPhone, int mBed, int mBath, int mSquare, String mImage, String mDate, String mParking, String mPet, String mDescription) {
        this.mType = mType;
        this.mName = mName;
        this.mPrice = mPrice;
        this.mAddress = mAddress;
        this.mPhone = mPhone;
        this.mBed = mBed;
        this.mBath = mBath;
        this.mSquare = mSquare;
        this.mImage = mImage;
        this.mDate = mDate;
        this.mParking = mParking;
        this.mPet = mPet;
        this.mDescription = mDescription;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public int getmBed() {
        return mBed;
    }

    public void setmBed(int mBed) {
        this.mBed = mBed;
    }

    public int getmBath() {
        return mBath;
    }

    public void setmBath(int mBath) {
        this.mBath = mBath;
    }

    public int getmSquare() {
        return mSquare;
    }

    public void setmSquare(int mSquare) {
        this.mSquare = mSquare;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmParking() {
        return mParking;
    }

    public void setmParking(String mParking) {
        this.mParking = mParking;
    }

    public String getmPet() {
        return mPet;
    }

    public void setmPet(String mPet) {
        this.mPet = mPet;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
