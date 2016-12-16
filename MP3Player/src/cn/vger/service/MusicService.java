package cn.vger.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import cn.vger.model.Lrc;
import cn.vger.model.Song;
import cn.vger.mp3player.MainActivity;
import cn.vger.mp3player.R;

/**
 * 该类是音乐相关操作的服务类，用绑定的Service
 * 
 * @author Vger
 * 
 */
public class MusicService extends Service implements OnCompletionListener,
		Runnable {

	public static final String ACTION = "cn.vger.mp3player.intent.action.MusicService";

	public static final int NOTIFICATION_ID = 8080;
	public static final int SELECTMUSIC = 1024;
	public static final int PLAYANDPAUSE = 1025;
	public static final int NEXTMUSIC = 1026;
	public static final int PREVIOUSMUSIC = 1027;
	public static final int STOPMUSIC = 1028;
	public static final int SETMUSICTIME = 1029;

	Notification notification;
	NotificationManager manager;
	
	private MediaPlayer mp;// 播放器的核心

	private SongGet sg;
	private LrcGet lg;
	private List<Song> songList;// 歌曲列表的存储结构
	private List<Lrc> lrcList;//歌词列表的存储结构

	private String filePath;// 用来判断现在mp使用的是在songList中的哪一首歌曲

	private Handler handler = new Handler();

	private Builder builder = new NotificationCompat.Builder(this);// 创建notification

	private ServiceReceiver serviceReceiver;
	private Intent mainIntent = new Intent(MainActivity.ACTION);

	@Override
	public void onCreate() {
		super.onCreate();
		sg = new SongGet(this);
		lg = new LrcGet();
		songList = sg.getSongList();
		lrcList = lg.getLrcList();
		
		//注册广播接受
		serviceReceiver = new ServiceReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(MusicService.ACTION);
		registerReceiver(serviceReceiver, intentFilter);
	}

	@Override
	public void onDestroy() {
		stopMusic();
		handler.removeCallbacksAndMessages(null);// 终止handler
		manager.cancel(NOTIFICATION_ID);
		unregisterReceiver(serviceReceiver);
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	private int matchLrcIndex(String songName) {
		for(int i = 0; i < lrcList.size(); i++) {
			if(songName.equals(lrcList.get(i).getLrcName())) {
				return i;
			}
		}
		return -1;//表示没有找到歌词
	}
	
	// ////选个功能实现的方法
	// 选中一首歌曲
	private void select(Song song) {
		selectMusic(song.getFilePath());

		mainIntent.putExtra("songMaxTime", getMaxSongTime());
		mainIntent.putExtra("tvAllTime", LongToTimeString(getMaxSongTime()));
		mainIntent.putExtra("tvSongName", song.getSongName());
		mainIntent.putExtra("tvSinger", song.getSinger());
		int index = matchLrcIndex(song.getSongName());
		
		if(index != -1) {
			mainIntent.putExtra("lrcPath", lrcList.get(index).getLrcPath());
		} else {
			mainIntent.putExtra("lrcPath", "null");
		}
		
		// notification
		builder.setTicker(song.getSongName() + "		" + song.getSinger());
		builder.setSmallIcon(R.drawable.ic_launcher);
		builder.setContentTitle(song.getSongName());
		builder.setContentText(song.getSinger());

		if (song.getBtSinger() != null) {
			mainIntent.putExtra("ivSinger", song.getBtSinger());
			Bitmap bitmap = song.getBtSinger();
			bitmap = Bitmap.createScaledBitmap(bitmap, 64, 64, true);// 改变图片的大小
			builder.setLargeIcon(bitmap);
		} else {
			Drawable d = getResources().getDrawable(
					R.drawable.main_iv_singer_def);
			Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
			mainIntent.putExtra("ivSinger", bitmap);

			bitmap = Bitmap.createScaledBitmap(bitmap, 64, 64, true);// 改变图片的大小
			builder.setLargeIcon(bitmap);
		}

		notification = builder.build();
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		manager.notify(NOTIFICATION_ID, notification);

		sendBroadcast(mainIntent);
	}

	// 选择音乐时候时调用
	private void selectMusic(String filePath) {
		this.filePath = filePath;
		File file = new File(filePath);
		Uri uri = Uri.fromFile(file);

		if (mp == null) {
			mp = MediaPlayer.create(MusicService.this, uri);
			mp.setOnCompletionListener(this);
			try {
				if (mp != null) {
					mp.prepare();
				} else {
					System.out.println("路径错误");
				}
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			mp.reset();
			try {
				mp.setDataSource(filePath);
				mp.prepare();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////////////
	// //播放的功能
	private void playAndPause() {
		if (PlayingOrNot().isException()) {
			mainIntent.putExtra("tvTime", "00:00");
			mainIntent.putExtra("tvAllTime", "00:00");
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.main_iv_singer_def);
			mainIntent.putExtra("ivSinger", bitmap);
			mainIntent.putExtra("tvSongName", "Song Name");
			mainIntent.putExtra("tvSinger", "Singer");
		} else {
			handler.post(this);
			if (PlayingOrNot().isPause()) {
				playMusic();// 如果在暂停的时候，调用该方法就开始播放
				mainIntent.putExtra("isPlaying", true);
			} else {
				pauseMusic();
				mainIntent.putExtra("isPlaying", false);
			}
		}
		sendBroadcast(mainIntent);
	}

	private void playMusic() {
		if (mp != null) {
			mp.start();
		}
	}

	private void pauseMusic() {
		if (mp != null) {
			if (mp.isPlaying()) {
				mp.pause();
			}
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////////////
	// ////上下切歌的实现方法
	// 下一首歌
	private void nextMusic() {
		int next = nextMusicPosition();
		if (next != -1) {
			select(songList.get(next));
			playAndPause();
		}
	}

	// 下一首歌曲的位置
	private int nextMusicPosition() {
		if (mp != null) {
			int i = getSongListPosition();
			if (i == songList.size() - 1) {// 若现在播放的歌曲是最后一首
				return 0;
			} else {
				return i + 1;
			}
		}
		return -1;
	}

	// 上一首歌
	private void previousMusic() {
		int previous = PreviousMusicPosition();
		if (previous != -1) {
			select(songList.get(previous));
			playAndPause();
		}
	}

	// 上一首歌曲的位置
	private int PreviousMusicPosition() {
		if (mp != null) {
			int i = getSongListPosition();
			if (i == 0) {// 若现在播放的歌曲是第一首
				return songList.size() - 1;
			} else {
				return i - 1;
			}
		}
		return -1;
	}

	// 获取当前的歌曲在哪个位置
	private int getSongListPosition() {
		for (int i = 0; i < songList.size(); i++) {
			if (filePath.equals(songList.get(i).getFilePath())) {
				return i;
			}
		}
		return -1;// 出现这种情况的时候是运行错误的时候
	}

	// 判断是否播放完成，自动下一首歌
	@Override
	public void onCompletion(MediaPlayer mp) {
		nextMusic();
	}

	// /////////////////////////////////////////////////////////////////////////////////

	// /////////////////////////////////////////////////////////////////////////////////
	private void stopMusic() {
		if (mp != null) {
			mp.stop();
			mp.release();
			mp = null;
		}
	}

	// /////////////////////////////////////////////////////////////////////////////////

	// 获得歌曲的时间长度，返回int类型
	private int getMaxSongTime() {
		if (mp != null) {
			return mp.getDuration();
		} else {
			return 0;
		}
	}

	// 控制条控制音乐跳到哪个位置
	private void sbSetMusicTime(int progress) {
		if (mp != null) {
			mp.seekTo(progress);
		}
	}

	// 获得当前歌曲唱到哪个位置
	private long getCurrentTime() {
		if (mp != null) {
			return mp.getCurrentPosition();
		} else {
			return 0;
		}
	}

	// 判断是否在播放，以便控制播放按钮
	private Judge PlayingOrNot() {
		Judge jd;
		if (mp != null) {
			if (mp.isPlaying()) {
				jd = new Judge(true, false);
			} else {
				jd = new Judge(false, false);
			}
		} else {
			jd = new Judge(false, true);
		}
		return jd;
	}

	/**
	 * 这个内部类是用来检测歌曲是否在播放，还有检测mp的值是否为空
	 * 
	 * @author Vger
	 * 
	 */
	private class Judge {
		private boolean isPlaying;
		private boolean isPause;
		private boolean isException;

		public Judge(boolean isPlaying, boolean isException) {
			this.isException = isException;
			if (isException) {
			} else {
				this.isPlaying = isPlaying;
				this.isPause = !isPlaying;
			}
		}

		public boolean isPlaying() {
			return isPlaying;
		}

		public boolean isPause() {
			return isPause;
		}

		public boolean isException() {
			return isException;
		}
	}

	// ////////////////////////////////////////////////////////////////////////////
	// 广播接收
	private class ServiceReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			int function = intent.getIntExtra("function", -1);
			Song song = intent.getParcelableExtra("song");
			int progress = intent.getIntExtra("setTime", 0);

			switch (function) {
			case MusicService.SELECTMUSIC:
				select(song);
				playAndPause();
				break;
			case MusicService.PLAYANDPAUSE:
				playAndPause();
				break;
			case MusicService.NEXTMUSIC:
				nextMusic();
				break;
			case MusicService.PREVIOUSMUSIC:
				previousMusic();
				break;
			case MusicService.STOPMUSIC:
				stopMusic();
				break;
			case MusicService.SETMUSICTIME:
				sbSetMusicTime(progress);
				break;
			case -1:
				break;
			}
		}

	}

	// ////////////////////////////////////////////////////////////////////////////

	// ////////////////////////////////////////////////////////////////////////////
	// //时间的控制

	private String LongToTimeString(long time) {
		time = time / 1000;
		int min, sec;
		String str = "";
		min = (int) (time / 60);
		sec = (int) (time % 60);

		// 字符串格式化
		if (min < 10) {
			str = str + "0" + min + ":";
		} else {
			str = str + min + ":";
		}
		if (sec < 10) {
			str = str + "0" + sec;
		} else {
			str = str + sec;
		}

		return str;
	}

	@Override
	public void run() {
		handler.postDelayed(this, 1000);
		long currentTime = getCurrentTime();
		mainIntent.putExtra("sbProgress", currentTime);
		
		String str = LongToTimeString(currentTime);
		mainIntent.putExtra("tvTime", str);
		sendBroadcast(mainIntent);
	}
}
