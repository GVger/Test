package cn.vger.schedule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.vger.schedule.util.DBUtil;

public class LoginCheck {
	private List<cn.vger.schedule.model.UserInfo> userInfo = new ArrayList<cn.vger.schedule.model.UserInfo>();
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public LoginCheck(){
		init();
	}
	
	private void init() {
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from user_info");
			rs = ps.executeQuery();
			while(rs.next()) {
				cn.vger.schedule.model.UserInfo temp = new cn.vger.schedule.model.UserInfo();
				temp.setUser(rs.getString("user_name"));
				temp.setPsw(rs.getString("psw"));
				userInfo.add(temp);
			}
			DBUtil.release(rs, ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<cn.vger.schedule.model.UserInfo> getUserInfo() {
		return userInfo;
	}
}
