package com.barmej.notesapp.classes;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class PhotoNote extends Note implements Parcelable {
    private Uri image;


    public PhotoNote(int noteColor, String note, Uri image) {
        super(noteColor, note);
        this.image = image;
    }


    protected PhotoNote(Parcel in) {
        note = in.readString();
        color = in.readInt();
        image = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<PhotoNote> CREATOR = new Creator<PhotoNote>() {
        @Override
        public PhotoNote createFromParcel(Parcel in) {
            return new PhotoNote(in);
        }

        @Override
        public PhotoNote[] newArray(int size) {
            return new PhotoNote[size];
        }
    };

    public Uri getImage() {
        return image;
    }

    public void setImage(Uri image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(note);
        parcel.writeInt(color);
        parcel.writeParcelable(image, i);
    }

}
