package cn.vger.mp3player;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Launch extends Activity {
	
	public static int LAUNCH_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        
        new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				Intent intentMain = new Intent(Launch.this, MainActivity.class);
				Launch.this.startActivity(intentMain);
				Launch.this.finish();
			}
		}, LAUNCH_TIME);   
    }
}
