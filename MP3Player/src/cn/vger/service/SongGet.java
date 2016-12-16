package cn.vger.service;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import cn.vger.model.Song;

/**
 * 从系统的数据库中获得歌曲的类
 * @author Vger
 *
 */
public class SongGet {
	
	private ContentResolver cr;
	private Context context;
	
	private List<Song> songList;
	
	public SongGet(Context context) {
		this.context = context;
		cr = context.getContentResolver();
		songList = new ArrayList<Song>();
		init();
	}
	
	public List<Song> getSongList() {
		return songList;
	}
	
	private void init() {
		Song song;
		Cursor cursor =cr.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
		while(cursor.moveToNext()) {
			song = new Song(cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)),
					cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)), 
					cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST)),
					getBtSinger(cursor)
					);
			if(song.getFilePath().endsWith(".mp3")) {
				songList.add(song);
			}
		}
	}
	
	//获得专辑的bitmap
	private Bitmap getBtSinger(Cursor currentCursor) {
		Bitmap bt = null;
		int albumID = currentCursor.getInt(currentCursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
		String albumArt = getArtString(albumID);
		if(albumArt == null) {
			bt = null;
		} else {
			bt = BitmapFactory.decodeFile(albumArt);
		}
		return bt;
	}
	
	//获得歌曲专辑bitmap的路径
	private String getArtString(int albumID) {
		String albumArt = null;
		String uriStr = "content://media/external/audio/albums";
		String[] projection = new String[]{"album_art"};
		Uri uri = Uri.parse(uriStr + "/" + albumID);
		Cursor albumCursor = context.getContentResolver().query(uri, projection, null, null, null);
		if(albumCursor.getCount() > 0 && albumCursor.getColumnCount() > 0) {
			albumCursor.moveToNext();
			albumArt = albumCursor.getString(0);
		}
		albumCursor.close();
		albumCursor = null;
		return albumArt;
	}
}
