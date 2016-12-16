package cn.vger.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LrcPlay {
	
	
	private Map<String, String> lrcMap;
	private String filePath;
	private ArrayList<String> timeIndex;
	
	public LrcPlay(String filePath) {
		this.filePath = filePath;
		timeIndex = new ArrayList<String>();
		lrcMap = new LinkedHashMap<String, String>();
		
		init();
		getTimeIndex();
	}
	
	private void init() {
		File file = new File(filePath);
		try {
			String temp = "";
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis, "GB2312");
			BufferedReader br = new BufferedReader(isr);
			while((temp = br.readLine()) != null) {
				decode(temp);
			}
			
			if(br != null) {
				br.close();
				if(isr != null) {
					isr.close();
					if(fis != null) {
						fis.close();
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//解析歌词
	private void decode(String lrcLine) {
		//解析歌词的名字
		if(lrcLine.startsWith("[ti:")) {
			lrcMap.put("ti", lrcLine.substring(4, lrcLine.lastIndexOf("]")));
		} 
		
		//解析歌词的歌手
		else if(lrcLine.startsWith("[ar:")) {
			lrcMap.put("ar", lrcLine.substring(4, lrcLine.lastIndexOf("]")));
		}
		
		//解析歌词的专辑
		else if(lrcLine.startsWith("[al:")) {
			lrcMap.put("al", lrcLine.substring(4, lrcLine.lastIndexOf("]")));
		}
		
		//解析歌词的制作人
		else if(lrcLine.startsWith("[by:")) {
			lrcMap.put("by", lrcLine.substring(4, lrcLine.lastIndexOf("]")));
		}

		//解析歌词的语言
		else if(lrcLine.startsWith("[la:")) {
			lrcMap.put("la", lrcLine.substring(4, lrcLine.lastIndexOf("]")));
		}
		
		//解析歌词正文部分
		else {
			int startIndex = -1;
			
			while((startIndex = lrcLine.indexOf("[", startIndex+1)) != -1) {
				int timeEndIndex = lrcLine.indexOf("]", startIndex+1);
				lrcMap.put(dcTime(lrcLine.substring(startIndex+1, timeEndIndex)), 
									lrcLine.substring(timeEndIndex+1, lrcLine.length()));
				
			}
			
		}
		
	}
	
	
	//解析歌词中的时间
	private String dcTime(String str) {
		int minute = Integer.parseInt(str.substring(0, str.indexOf(":")));
		int s = 0;
		int ms = 0;
		
		//判断歌词是不是有毫秒
		if(str.indexOf(".") != -1) {
			s = Integer.parseInt(str.substring(str.indexOf(":")+1, str.indexOf(".")));
			ms = Integer.parseInt(str.substring(str.indexOf(".")+1, str.length()));
			
		} else {
			s = Integer.parseInt(str.substring(str.indexOf(":")+1, str.length()));
		}
		
		return String.valueOf((minute*60+s)*1000+ms*10);
	}

	//获得一个时间的ArrayList
	private void getTimeIndex() {
		Set<String> keySet = lrcMap.keySet();
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String key = (String) it.next();
			
			if((key.equals("ti")) || (key.equals("ar")) 
					|| (key.equals("al")) || (key.equals("by")) 
					|| (key.equals("la"))) {
				continue;
			}
			timeIndex.add(key);
		}
		
	}
	
	public int getIndexMax() {
		return timeIndex.size();
	}
	
	public String getLrcFromIndex(int index) {
		return lrcMap.get(timeIndex.get(index));
	}
	
	public String getLrc(long currentTime) {
		int need = 0;
		need = getLrcIndex(currentTime);
		return lrcMap.get(timeIndex.get(need));
	}
	
	public int getLrcIndex(long currentTime) {
		int index = 0;
		if(currentTime < Integer.parseInt(timeIndex.get(0))) {
			return 0;
		}
		while(index < timeIndex.size()-1) {
			if(Integer.parseInt(timeIndex.get(index)) < currentTime) {
				if(Integer.parseInt(timeIndex.get(index+1)) > currentTime) {
					return index;
				}
			}
			index++;
		}
		return timeIndex.size()-1;
	}
}
