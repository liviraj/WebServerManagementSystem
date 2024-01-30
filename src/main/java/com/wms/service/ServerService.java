package com.wms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wms.dbconnection.DbConnection;
import com.wms.model.ServerBeen;

public class ServerService {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ArrayList<ServerBeen> getServer() throws ClassNotFoundException {
		ArrayList<ServerBeen> serverList = new ArrayList<ServerBeen>();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			String query = "select * from server";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ServerBeen serverBeen = new ServerBeen();
				serverBeen.setServerId(rs.getInt("serverId"));
				serverBeen.setServerName(rs.getString("serverName"));
				serverBeen.setOperatingSystem(rs.getString("operatingSystem"));
				serverBeen.setRam(rs.getString("ram"));
				serverBeen.setHardDiskSize(rs.getString("hardDiskSize"));
				serverBeen.setAvailability(rs.getString("availability"));
				serverBeen.setExpiryDate(rs.getDate("expiryDate"));
				
				serverList.add(serverBeen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serverList;
	}

	public ServerBeen getServerById(int id) throws ClassNotFoundException {
		ServerBeen bean = new ServerBeen();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from server where id='" + id + "'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean.setServerId(rs.getInt(1));
				bean.setServerName(rs.getString(2));
				bean.setOperatingSystem(rs.getString(3));
				bean.setRam(rs.getString(4));
				bean.setHardDiskSize(rs.getString(5));
				bean.setAvailability(rs.getString(6));
				bean.setExpiryDate(rs.getDate(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public int deleteServer(int id) throws ClassNotFoundException, SQLException {
		int status = 0;
		String query = "delete from server where id=" + id + "";
		con = DbConnection.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		status = ps.executeUpdate();
		return status;
	}

	public ArrayList<ServerBeen> getServer2() throws ClassNotFoundException {
		ArrayList<ServerBeen> serverList = new ArrayList<ServerBeen>();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			String query = "select * from server";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ServerBeen server = new ServerBeen();
				server.setServerId(rs.getInt("serverId"));
				server.setServerName(rs.getString("serverName"));
				server.setOperatingSystem(rs.getString("operatingSystem"));
				server.setRam(rs.getString("ram"));
				server.setHardDiskSize(rs.getString("hardDiskSize"));
				server.setAvailability(rs.getString("availability"));
				server.setExpiryDate(rs.getDate("expiryDate"));
				
				serverList.add(server);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return serverList;
	}

	public int insertServer(ServerBeen serverBeen) {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into server(serverName,operatingSystem,ram,hardDiskSize,availability,expiryDate) values(?,?,?,?,?,?)");
			ps.setString(1, serverBeen.getServerName());
			ps.setString(2, serverBeen.getOperatingSystem());
			ps.setString(3, serverBeen.getRam());
			ps.setString(4, serverBeen.getHardDiskSize());
			ps.setString(5, serverBeen.getAvailability());
			ps.setDate(6, serverBeen.getExpiryDate());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateServer(ServerBeen serverBeen) throws ClassNotFoundException {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"update server set serverName=?,operatingSystem=?,ram=?,hardDiskSize=?,availability=?,expiryDate=?  where id='" + serverBeen.getServerId() + "'");
			ps.setString(1, serverBeen.getServerName());
			ps.setString(2, serverBeen.getOperatingSystem());
			ps.setString(3, serverBeen.getRam());
			ps.setString(4, serverBeen.getHardDiskSize());
			ps.setString(5, serverBeen.getAvailability());
			ps.setDate(6, serverBeen.getExpiryDate());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public String nameCheck(String name) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			rs = st.executeQuery("select serverName from server where  name = '" + name + "'");
			if (rs.next()) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}
}
