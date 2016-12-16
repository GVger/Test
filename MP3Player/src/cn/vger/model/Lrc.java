package cn.vger.model;

public class Lrc {
	private String lrcName;
	private String lrcPath;
	
	public Lrc(String lrcName, String lrcPath) {
		this.lrcName = lrcName;
		this.lrcPath = lrcPath;
	}

	public String getLrcName() {
		return lrcName;
	}

	public void setLrcName(String lrcName) {
		this.lrcName = lrcName;
	}

	public String getLrcPath() {
		return lrcPath;
	}

	public void setLrcPath(String lrcPath) {
		this.lrcPath = lrcPath;
	}

	
}
