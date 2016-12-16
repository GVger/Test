package cn.vger.service;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.vger.model.Song;
import cn.vger.mp3player.R;

/**
 * 用来显示歌曲列表实现的适配器的类
 * @author Vger
 *
 */
public class SongListAdapter extends BaseAdapter {

	private Context context;
	
	private List<Song> songList;
	private SongGet sg;
	
	public SongListAdapter(Context context,SongGet sg) {
		this.context = context;
		this.sg = sg;
		songList = this.sg.getSongList();
	}
	
	//增加数据
	public void add(Song item) {
		songList.add(item);
		notifyDataSetChanged();
	}
	
	//移除数据
	public void remove(int position) {
		songList.remove(position);
		notifyDataSetChanged();
	}
	
	public void removeLast() {
		songList.remove(getCount() - 1);
	}
	
	@Override
	public int getCount() {
		return songList.size();
	}

	@Override
	public Song getItem(int position) {
		return songList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//初始化view，回收的convertView
		LinearLayout ll = null;
		if(convertView == null) {
			ll = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.song_list_cell, null);
		} else {
			ll = (LinearLayout) convertView;
		}

		Song song = getItem(position);
		
		//为每个控件赋值
		ImageView song_cell_ivSingerPic = (ImageView) ll.findViewById(R.id.song_cell_ivSingerPic);
		TextView song_cell_tvSong = (TextView) ll.findViewById(R.id.song_cell_tvSong);
		TextView song_cell_tvSinger = (TextView) ll.findViewById(R.id.song_cell_tvSinger);
		
		if(song.getBtSinger() == null) {
			song_cell_ivSingerPic.setImageResource(R.drawable.main_iv_singer_def);
		} else {
			song_cell_ivSingerPic.setImageBitmap(song.getBtSinger());
		}
		song_cell_tvSong.setText(song.getSongName());
		song_cell_tvSinger.setText(song.getSinger());
		
		return ll;
	}

}
