package cn.vger.mp3player;

import java.util.ArrayList;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.vger.model.Song;
import cn.vger.service.LrcGet;
import cn.vger.service.MusicService;
import cn.vger.service.SongGet;
import cn.vger.service.SongListAdapter;

public class MainActivity extends Activity implements OnClickListener,
		OnItemClickListener {

	public static final String ACTION = "cn.vger.mp3player.intent.action.UIChange";

	private Button btnPlayAndPause, btnNext, btnPrevious;// �������Ŀ��ư�ť
	private SeekBar sbProgress;// �����Ľ�����
	private TextView tvTime, tvAllTime;// ��ʾʱ���TextView
	private TextView tvSongName, tvSinger;// ���½ǵ�textview
	private ImageView ivSinger;// ���½ǵ�imageview������ʾר����ͼƬ
	private ListView lvSongList;// listview������ʾ�����б�
	private LinearLayout consoleLayout;// �ı�Ƥ���Ŀؼ�

	private int resource = R.drawable.console;

	private Intent musicIntent = new Intent(MusicService.ACTION);
	private MainReceiver mainReceiver, skinReceiver;

	private SongGet sg;// ��ȡ�����б�洢�ṹ��

	private SongListAdapter adapter;// listview��������

	private DrawerLayout mainLayout;
	private ListView navigationListView;
	private ArrayList<String> menuList;
	private ArrayAdapter<String> menuAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// �໬�˵��ĳ�ʼ��
		mainLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
		navigationListView = (ListView) findViewById(R.id.navigation_layout);
		menuList = new ArrayList<String>();
		menuList.add("����û�й���");
		menuAdapter = new ArrayAdapter<String>(MainActivity.this,
				android.R.layout.simple_list_item_1, menuList);
		navigationListView.setAdapter(menuAdapter);
		navigationListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String str = menuAdapter.getItem(position);
				Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
			}
		});

		// ��������
		startService(musicIntent);

		// ��ʼ��lvsonglist������
		sg = new SongGet(MainActivity.this);
		adapter = new SongListAdapter(MainActivity.this, sg);
		lvSongList = (ListView) findViewById(R.id.lvSongList);
		lvSongList.setAdapter(adapter);
		lvSongList.setOnItemClickListener(this);

		consoleLayout = (LinearLayout) findViewById(R.id.skin_object);
		sbProgress = (SeekBar) findViewById(R.id.sbProgress);
		tvTime = (TextView) findViewById(R.id.tvTime);
		tvAllTime = (TextView) findViewById(R.id.tvAllTime);

		tvSongName = (TextView) findViewById(R.id.tvSongName);
		tvSinger = (TextView) findViewById(R.id.tvSinger);
		ivSinger = (ImageView) findViewById(R.id.ivSinger);

		btnPrevious = (Button) findViewById(R.id.btnPrevious);
		btnPlayAndPause = (Button) findViewById(R.id.btnPlayAndPause);
		btnNext = (Button) findViewById(R.id.btnNext);

		ivSinger.setOnClickListener(this);

		btnPrevious.setOnClickListener(this);
		btnPlayAndPause.setOnClickListener(this);
		btnNext.setOnClickListener(this);

		sbProgress
				.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
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
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
					}
				});

		// ע��㲥������
		mainReceiver = new MainReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(MainActivity.ACTION);
		registerReceiver(mainReceiver, intentFilter);

		skinReceiver = new MainReceiver();
		IntentFilter skinIntentFilter = new IntentFilter();
		skinIntentFilter.addAction(ChangeSkinActivity.ACTION);
		registerReceiver(skinReceiver, skinIntentFilter);
	}

	// �����ǰ�ť�Ĵ���
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnNext:
			musicIntent.putExtra("function", MusicService.NEXTMUSIC);
			sendBroadcast(musicIntent);
			break;
		case R.id.btnPlayAndPause:
			musicIntent.putExtra("function", MusicService.PLAYANDPAUSE);
			sendBroadcast(musicIntent);
			break;
		case R.id.btnPrevious:
			musicIntent.putExtra("function", MusicService.PREVIOUSMUSIC);
			sendBroadcast(musicIntent);
			break;
		case R.id.ivSinger:
			Intent i = new Intent(MainActivity.this, LrcShowActivity.class);
			i.putExtra("activitySkin", resource);
			MainActivity.this.startActivity(i);
			break;
		}
	}

	@Override
	protected void onDestroy() {
		// ֹͣ����
		// ��Ҫ�жϷ����Ƿ��Ѿ�����
		if (musicIntent != null) {
			stopService(musicIntent);
		}
		// ע���㲥������
		unregisterReceiver(mainReceiver);
		unregisterReceiver(skinReceiver);
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main_activity, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_bar_exit:
			MainActivity.this.finish();
			break;
		case R.id.action_bar_changeskin:
			Intent i = new Intent(MainActivity.this, ChangeSkinActivity.class);
			MainActivity.this.startActivity(i);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	// songList�Ŀ����¼�
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Song song = adapter.getItem(position);
		musicIntent.putExtra("function", MusicService.SELECTMUSIC);
		musicIntent.putExtra("song", song);
		sendBroadcast(musicIntent);
	}

	private long lastClickTime = 0;

	@Override
	public void onBackPressed() {
		if (lastClickTime <= 0) {
			Toast.makeText(MainActivity.this, "�ٰ�һ�λص�����", Toast.LENGTH_SHORT)
					.show();
			lastClickTime = System.currentTimeMillis();
		} else {
			long currentClickTime = System.currentTimeMillis();
			if (currentClickTime - lastClickTime < 1500) {
				moveTaskToBack(true);// ��̨����
			} else {
				Toast.makeText(MainActivity.this, "�ٰ�һ�λص�����",
						Toast.LENGTH_SHORT).show();
				lastClickTime = currentClickTime;
			}
		}
	}

	public class MainReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals(MainActivity.ACTION)) {
				int progressMax = intent.getIntExtra("songMaxTime", 0);
				sbProgress.setMax(progressMax);
				long progress = intent.getLongExtra("sbProgress", 0);
				sbProgress.setProgress((int) progress);

				String currentTime = intent.getStringExtra("tvTime");
				tvTime.setText(currentTime);
				String allTime = intent.getStringExtra("tvAllTime");
				tvAllTime.setText(allTime);

				Bitmap btSinger = intent.getParcelableExtra("ivSinger");
				ivSinger.setImageBitmap(btSinger);

				String songName = intent.getStringExtra("tvSongName");
				tvSongName.setText(songName);

				String singer = intent.getStringExtra("tvSinger");
				tvSinger.setText(singer);

				boolean isPlaying = intent.getBooleanExtra("isPlaying", false);
				if (isPlaying) {
					btnPlayAndPause
							.setBackgroundResource(R.drawable.btn_pause_skin);
				} else if (!isPlaying) {
					btnPlayAndPause
							.setBackgroundResource(R.drawable.btn_play_skin);
				}
			}

			if (intent.getAction().equals(ChangeSkinActivity.ACTION)) {
				resource = intent
						.getIntExtra("changerSkin", R.drawable.console);
				consoleLayout.setBackgroundResource(resource);
			}
		}

	}
}
