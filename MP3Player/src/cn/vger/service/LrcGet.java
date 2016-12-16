package cn.vger.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.os.Environment;
import cn.vger.model.Lrc;

public class LrcGet {
	
	private List<Lrc> lrcList;
	
	public LrcGet() {
		lrcList = new ArrayList<Lrc>();
		init();
	}

	private void init() {
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			File sdDir = Environment.getExternalStorageDirectory();
			fileDir(sdDir);
		}
	}
	
	public List<Lrc> getLrcList() {
		return lrcList;
	}
	
	private void fileDir(File dir) {
		File[] files = dir.listFiles();
		for(File file : files) {
			if(file.isDirectory()) {
				fileDir(file);
			} else {
				if(file.getAbsolutePath().endsWith(".lrc")) {
					String path = file.getAbsolutePath();
					String name = path.substring(path.lastIndexOf("/")+1, path.indexOf(".lrc"));
					lrcList.add(new Lrc(name, path));
				}
			}
		}
	}
}
