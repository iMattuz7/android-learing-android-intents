package com.tutorial.matiasalmiron.ma_androidtutorial;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by matiasalmiron on 7/22/16.
 */

public class Person implements Parcelable {

    public Person(){
        this.name = null;
        this.address = null;
    }

    public Person(Parcel in) {
        this.name = in.readString();
        this.address= in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;





    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getName());
        dest.writeString(getAddress());
    }

    public static final Parcelable.Creator<Person> CREATOR =
            new Parcelable.Creator<Person>() {
                public Person createFromParcel(Parcel in) {
                    return new Person(in);
                }
                public Person[] newArray(int size) {
                    return new Person[size];
                } };

}
