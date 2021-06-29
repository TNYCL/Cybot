package cybot.shortlink.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cybot.Main;
import cybot.Options;
import cybot.utils.Util;

public class MySQL {
	
	private Connection connect;
	private Statement statement;

	public MySQL() {
		try {
			this.connect = DriverManager.getConnection("jdbc:mysql://" + Options.sqlIP + ":" + Options.sqlPort + "/" + Options.sqlDatabase + 
			          "?autoReconnect=true", Options.sqlUser, Options.sqlPassword);
			this.statement = connect.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.connect;
	}
	
	public Statement getStatement() {
		return this.statement;
	}
	
	public static void setShortLink(String key, String value) {
		try {
			String sql = "INSERT INTO short_link (short_key, link) VALUES ('"+key+"','"+value+"')";
			Main.getSQL().getStatement().executeUpdate(sql);
		} catch(SQLException e) {
			Util.error(e.getMessage());
		}
	}
	
	public static String getShortLink(String key) {
		String data = null;
		try {
			String sql = "SELECT * FROM short_link WHERE short_key='"+key+"'";
			ResultSet rs = Main.getSQL().getStatement().executeQuery(sql);
			while(rs.next()) data = rs.getString("link");
		} catch(SQLException e) {
			Util.error(e.getMessage());
		}
		return data;
	}
	
	public static boolean hasShortLink(String key) {
		String link = getShortLink(key);
		if(link == null) return false;
		return true;
	}

}
