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
 * ������������ز����ķ����࣬�ð󶨵�Service
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
	
	private MediaPlayer mp;// �������ĺ���

	private SongGet sg;
	private LrcGet lg;
	private List<Song> songList;// �����б�Ĵ洢�ṹ
	private List<Lrc> lrcList;//����б�Ĵ洢�ṹ

	private String filePath;// �����ж�����mpʹ�õ�����songList�е���һ�׸���

	private Handler handler = new Handler();

	private Builder builder = new NotificationCompat.Builder(this);// ����notification

	private ServiceReceiver serviceReceiver;
	private Intent mainIntent = new Intent(MainActivity.ACTION);

	@Override
	public void onCreate() {
		super.onCreate();
		sg = new SongGet(this);
		lg = new LrcGet();
		songList = sg.getSongList();
		lrcList = lg.getLrcList();
		
		//ע��㲥����
		serviceReceiver = new ServiceReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(MusicService.ACTION);
		registerReceiver(serviceReceiver, intentFilter);
	}

	@Override
	public void onDestroy() {
		stopMusic();
		handler.removeCallbacksAndMessages(null);// ��ֹhandler
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
		return -1;//��ʾû���ҵ����
	}
	
	// ////ѡ������ʵ�ֵķ���
	// ѡ��һ�׸���
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
			bitmap = Bitmap.createScaledBitmap(bitmap, 64, 64, true);// �ı�ͼƬ�Ĵ�С
			builder.setLargeIcon(bitmap);
		} else {
			Drawable d = getResources().getDrawable(
					R.drawable.main_iv_singer_def);
			Bitmap bitmap = ((BitmapDrawable) d).getBitmap();
			mainIntent.putExtra("ivSinger", bitmap);

			bitmap = Bitmap.createScaledBitmap(bitmap, 64, 64, true);// �ı�ͼƬ�Ĵ�С
			builder.setLargeIcon(bitmap);
		}

		notification = builder.build();
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		manager.notify(NOTIFICATION_ID, notification);

		sendBroadcast(mainIntent);
	}

	// ѡ������ʱ��ʱ����
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
					System.out.println("·������");
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
	// //���ŵĹ���
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
				playMusic();// �������ͣ��ʱ�򣬵��ø÷����Ϳ�ʼ����
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
	// ////�����и��ʵ�ַ���
	// ��һ�׸�
	private void nextMusic() {
		int next = nextMusicPosition();
		if (next != -1) {
			select(songList.get(next));
			playAndPause();
		}
	}

	// ��һ�׸�����λ��
	private int nextMusicPosition() {
		if (mp != null) {
			int i = getSongListPosition();
			if (i == songList.size() - 1) {// �����ڲ��ŵĸ��������һ��
				return 0;
			} else {
				return i + 1;
			}
		}
		return -1;
	}

	// ��һ�׸�
	private void previousMusic() {
		int previous = PreviousMusicPosition();
		if (previous != -1) {
			select(songList.get(previous));
			playAndPause();
		}
	}

	// ��һ�׸�����λ��
	private int PreviousMusicPosition() {
		if (mp != null) {
			int i = getSongListPosition();
			if (i == 0) {// �����ڲ��ŵĸ����ǵ�һ��
				return songList.size() - 1;
			} else {
				return i - 1;
			}
		}
		return -1;
	}

	// ��ȡ��ǰ�ĸ������ĸ�λ��
	private int getSongListPosition() {
		for (int i = 0; i < songList.size(); i++) {
			if (filePath.equals(songList.get(i).getFilePath())) {
				return i;
			}
		}
		return -1;// �������������ʱ�������д����ʱ��
	}

	// �ж��Ƿ񲥷���ɣ��Զ���һ�׸�
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

	// ��ø�����ʱ�䳤�ȣ�����int����
	private int getMaxSongTime() {
		if (mp != null) {
			return mp.getDuration();
		} else {
			return 0;
		}
	}

	// �������������������ĸ�λ��
	private void sbSetMusicTime(int progress) {
		if (mp != null) {
			mp.seekTo(progress);
		}
	}

	// ��õ�ǰ���������ĸ�λ��
	private long getCurrentTime() {
		if (mp != null) {
			return mp.getCurrentPosition();
		} else {
			return 0;
		}
	}

	// �ж��Ƿ��ڲ��ţ��Ա���Ʋ��Ű�ť
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
	 * ����ڲ����������������Ƿ��ڲ��ţ����м��mp��ֵ�Ƿ�Ϊ��
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
	// �㲥����
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
	// //ʱ��Ŀ���

	private String LongToTimeString(long time) {
		time = time / 1000;
		int min, sec;
		String str = "";
		min = (int) (time / 60);
		sec = (int) (time % 60);

		// �ַ�����ʽ��
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
