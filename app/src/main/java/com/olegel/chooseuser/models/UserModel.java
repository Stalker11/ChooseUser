package com.olegel.chooseuser.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 25.08.2017.
 */

public class UserModel implements Parcelable {
    @Expose
    @SerializedName("first_name")
    private String name;
    @Expose
    @SerializedName("last_name")
    private String lastName;
    @Expose
    @SerializedName("avatar")
    private String imageLink;
    @Expose
    @SerializedName("id")
    private int id;

    public String getName() {
        return name;
    }

    public static final Creator<UserModel> CREATOR =
            new Creator<UserModel>() {

                public UserModel createFromParcel(Parcel in) {
                    return new UserModel(in);
                }

                public UserModel[] newArray(int size) {
                    return new UserModel[size];
                }
            };

    private UserModel(Parcel parcel) {
        id = parcel.readInt();
        name = parcel.readString();
        lastName = parcel.readString();
        imageLink = parcel.readString();
    }

    public UserModel() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastName);
        dest.writeString(imageLink);
        dest.writeInt(id);
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageLink() {
        return imageLink;
    }

    public int getId() {
        return id;
    }
}
