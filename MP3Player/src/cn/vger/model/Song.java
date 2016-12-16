package cn.vger.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable{
	
	private Bitmap btSinger;
	private String songName;
	private String singer;
	private String filePath;
	
	public Song(String filePath, String songName, String singer, Bitmap btSinger) {
		this.filePath = filePath;
		this.songName = songName;
		this.singer = singer;
		this.btSinger = btSinger;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Bitmap getBtSinger() {
		return btSinger;
	}

	public void setBtSinger(Bitmap btSinger) {
		this.btSinger = btSinger;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(filePath);
		dest.writeString(songName);
		dest.writeString(singer);
		dest.writeValue(btSinger);
	}
	
	 public static final Parcelable.Creator<Song> CREATOR = new Parcelable.Creator<Song>() {

		@Override
		public Song createFromParcel(Parcel source) {
			return new Song(source.readString(), source.readString(), source.readString(), (Bitmap)source.readValue(Bitmap.class.getClassLoader()));
		}

		@Override
		public Song[] newArray(int size) {
			return null;
		}
		 
	 };
}
