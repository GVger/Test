package cn.vger.mp3player;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import cn.vger.service.LrcView;
import cn.vger.service.MusicService;

public class LrcShowActivity extends Activity implements OnClickListener {

	private TextView lrcTvTime, lrcTvAllTime;
	private SeekBar lrcSbProgress;
	private ImageView lrcIvSinger;
	private TextView lrcTvSongName, lrcTvSinger;
	private Button lrcBtnPlayAndPause, lrcBtnPrevious, lrcBtnNext;
	private LinearLayout consoleLayout;
	
	private LrcView lrcView;

	private LrcReceiver lrcReceiver;
	private Intent musicIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_lrcshow);

		musicIntent = new Intent(MusicService.ACTION);
		
		consoleLayout = (LinearLayout) findViewById(R.id.lrc_skin_object);
		lrcTvTime = (TextView) findViewById(R.id.lrc_tvTime);
		lrcSbProgress = (SeekBar) findViewById(R.id.lrc_sbProgress);
		lrcTvAllTime = (TextView) findViewById(R.id.lrc_tvAllTime);

		lrcIvSinger = (ImageView) findViewById(R.id.lrc_ivSinger);
		lrcTvSongName = (TextView) findViewById(R.id.lrc_tvSongName);
		lrcTvSinger = (TextView) findViewById(R.id.lrc_tvSinger);

		lrcBtnPlayAndPause = (Button) findViewById(R.id.lrc_btnPlayAndPause);
		lrcBtnPrevious = (Button) findViewById(R.id.lrc_btnPrevious);
		lrcBtnNext = (Button) findViewById(R.id.lrc_btnNext);
		lrcView = (LrcView)findViewById(R.id.lrc_view);

		lrcBtnPlayAndPause.setOnClickListener(this);
		lrcBtnPrevious.setOnClickListener(this);
		lrcBtnNext.setOnClickListener(this);
		
		lrcSbProgress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				musicIntent.putExtra("function",
						MusicService.SETMUSICTIME);
				int progress = seekBar.getProgress();
				musicIntent.putExtra("setTime", progress);
				sendBroadcast(musicIntent);
			}
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
			}
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
			}
		});
		
		consoleLayout.setBackgroundResource(getIntent().getIntExtra("activitySkin", R.drawable.console));
		
		// ×¢²á¹ã²¥½ÓÊÕÆ÷
		lrcReceiver = new LrcReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(MainActivity.ACTION);
		registerReceiver(lrcReceiver, intentFilter);
	}
	
	@Override
	protected void onDestroy() {
		unregisterReceiver(lrcReceiver);
		super.onDestroy();
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.lrc_btnNext:
			musicIntent.putExtra("function", MusicService.NEXTMUSIC);
			sendBroadcast(musicIntent);
			break;
		case R.id.lrc_btnPlayAndPause:
			musicIntent.putExtra("function", MusicService.PLAYANDPAUSE);
			sendBroadcast(musicIntent);
			break;
		case R.id.lrc_btnPrevious:
			musicIntent.putExtra("function", MusicService.PREVIOUSMUSIC);
			sendBroadcast(musicIntent);
			break;
		}
	}

	private class LrcReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(MainActivity.ACTION)) {
				int progressMax = intent.getIntExtra("songMaxTime", 0);
				lrcSbProgress.setMax(progressMax);
				long progress = intent.getLongExtra("sbProgress", 0);
				lrcSbProgress.setProgress((int) progress);

				String currentTime = intent.getStringExtra("tvTime");
				lrcTvTime.setText(currentTime);
				String allTime = intent.getStringExtra("tvAllTime");
				lrcTvAllTime.setText(allTime);

				Bitmap btSinger = intent.getParcelableExtra("ivSinger");
				lrcIvSinger.setImageBitmap(btSinger);

				String songName = intent.getStringExtra("tvSongName");
				lrcTvSongName.setText(songName);

				String singer = intent.getStringExtra("tvSinger");
				lrcTvSinger.setText(singer);

				boolean isPlaying = intent.getBooleanExtra("isPlaying", false);
				if (isPlaying) {
					lrcBtnPlayAndPause
							.setBackgroundResource(R.drawable.btn_pause_skin);
				} else if (!isPlaying) {
					lrcBtnPlayAndPause
							.setBackgroundResource(R.drawable.btn_play_skin);
				}
				String lrcPath = intent.getStringExtra("lrcPath");
				lrcView.setLrc(lrcPath);
				lrcView.setCurrentTime(progress);
			}
		}
	}
}
