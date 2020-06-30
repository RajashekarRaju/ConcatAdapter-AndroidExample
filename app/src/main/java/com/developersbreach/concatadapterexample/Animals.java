package com.developersbreach.concatadapterexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Animals implements Parcelable {

    private final int mAnimalId;
    private final String mAnimalName;

    Animals(int animalId, String animalName) {
        this.mAnimalId = animalId;
        this.mAnimalName = animalName;
    }

    private Animals(Parcel in) {
        mAnimalId = in.readInt();
        mAnimalName = in.readString();
    }

    int getAnimalId() {
        return mAnimalId;
    }

    String getAnimalName() {
        return mAnimalName;
    }

    public static final Creator<Animals> CREATOR = new Creator<Animals>() {
        @Override
        public Animals createFromParcel(Parcel in) {
            return new Animals(in);
        }

        @Override
        public Animals[] newArray(int size) {
            return new Animals[size];
        }
    };

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAnimalId);
        dest.writeString(mAnimalName);
    }
}
