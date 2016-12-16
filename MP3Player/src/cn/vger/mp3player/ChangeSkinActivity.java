package cn.vger.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ChangeSkinActivity extends Activity implements OnItemClickListener {

	public static final String ACTION = "cn.vger.mp3player.intent.action.ChangeSkin";
	private GridView gvSkin;

	private int[] imageId = new int[] { R.drawable.console_bg_1,
			R.drawable.console_bg_2, R.drawable.console_bg_3,
			R.drawable.console_bg_4 };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_changskin);
		
		BaseAdapter adapter = new BaseAdapter() {
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageView;
				if (convertView == null) {
					imageView = new ImageView(ChangeSkinActivity.this);

					imageView.setAdjustViewBounds(true);
					imageView.setMaxWidth(158);
					imageView.setMaxHeight(150);

					imageView.setPadding(5, 5, 5, 5);
				} else {
					imageView = (ImageView) convertView;
				}
				imageView.setImageResource(imageId[position]);
				return imageView;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public Object getItem(int position) {
				return position;
			}

			@Override
			public int getCount() {
				return imageId.length;
			}
		};

		gvSkin = (GridView) findViewById(R.id.gvSkin);
		gvSkin.setAdapter(adapter);
		gvSkin.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent i = new Intent(ChangeSkinActivity.ACTION);
		i.putExtra("changerSkin", imageId[position]);
		sendBroadcast(i);
		finish();
	}
}
