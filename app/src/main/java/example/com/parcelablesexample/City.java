package example.com.parcelablesexample;

import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Constructor;

/**
 * Created by Carlos Mendes on 05-08-2015.
 */
public class City implements Parcelable {

    String name;
    String country;
    String image;

    //Standard constructor for non-parcel
    public City(String name, String country, String image){
        this.name = name;
        this.country = country;
        this.image = image;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    //Constructor to use when re constructing objects from a parcel
    //@param in a parcel from which to read this object
    private City(Parcel in){
        name = in.readString();
        country = in.readString();
        image = in.readString();
    }

    //Describe the kinds of special objects contained in this Parcelable's representation.
    //@return a bitmask indicating the set of special object types by the Parcelable.
    @Override
    public int describeContents() {
        return 0;
    }

    /*
    This field is needed for Android to be able to create new objects, individually or as arrays.
    @param dest  The Parcel in which the object should be written.
    @param flags Additional flags about how the object should be written.
    May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
    */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(country);
        dest.writeString(image);
    }

    public final static Parcelable.Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}
