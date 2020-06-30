package com.developersbreach.concatadapterexample;


import android.os.Parcel;
import android.os.Parcelable;


public class Planets implements Parcelable {

    private final int mPlanetId;
    private final String mPlanetName;

    Planets(int planetId, String planetName) {
        this.mPlanetId = planetId;
        this.mPlanetName = planetName;
    }

    private Planets(Parcel in) {
        mPlanetId = in.readInt();
        mPlanetName = in.readString();
    }

    int getPlanetId() {
        return mPlanetId;
    }

    String getPlanetName() {
        return mPlanetName;
    }

    public static final Creator<Planets> CREATOR = new Creator<Planets>() {
        @Override
        public Planets createFromParcel(Parcel in) {
            return new Planets(in);
        }

        @Override
        public Planets[] newArray(int size) {
            return new Planets[size];
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
        dest.writeInt(mPlanetId);
        dest.writeString(mPlanetName);
    }
}
