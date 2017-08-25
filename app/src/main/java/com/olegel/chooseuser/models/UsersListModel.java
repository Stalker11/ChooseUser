package com.olegel.chooseuser.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Oleg on 25.08.2017.
 */

public class UsersListModel implements Parcelable {
    @Expose
    @SerializedName("page")
    private int page;
    @Expose
    @SerializedName("per_page")
    private int perPage;
    @Expose
    @SerializedName("total")
    private int total;
    @Expose
    @SerializedName("total_pages")
    private int totalPages;
    @Expose
    @SerializedName("data")
    private List<UserModel> users;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(page);
        dest.writeInt(perPage);
        dest.writeInt(total);
        dest.writeInt(totalPages);
        dest.writeList(users);
    }

    public static final Parcelable.Creator<UsersListModel> CREATOR =
            new Parcelable.Creator<UsersListModel>() {

                public UsersListModel createFromParcel(Parcel in) {
                    return new UsersListModel(in);
                }

                public UsersListModel[] newArray(int size) {
                    return new UsersListModel[size];
                }
            };

    private UsersListModel(Parcel parcel) {
        page = parcel.readInt();
        perPage = parcel.readInt();
        total = parcel.readInt();
        totalPages = parcel.readInt();
        users = parcel.readArrayList(UserModel.class.getClassLoader());
    }

    public UsersListModel() {
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTotal() {
        return total;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public List<UserModel> getUsers() {
        return users;
    }


}
