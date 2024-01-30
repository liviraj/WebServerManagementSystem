package com.gms.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.gms.dbconnection.DbConnection;
import com.gms.model.GroceryBeen;

public class GroceryService {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;

	public ArrayList<GroceryBeen> getGrocery() throws ClassNotFoundException {
		ArrayList<GroceryBeen> groceryList = new ArrayList<GroceryBeen>();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			String query = "select * from grocery";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				GroceryBeen groceryBeen = new GroceryBeen();
				groceryBeen.setIdgroocery(rs.getInt("idgroocery"));
				groceryBeen.setName(rs.getString("name"));
				groceryBeen.setMetrixType(rs.getString("metrixType"));
				groceryBeen.setQuantity(rs.getInt("quantity"));
				groceryBeen.setExpiryDate(rs.getDate("expirydate"));
				groceryBeen.setItemType(rs.getString("itemType"));
				groceryBeen.setPrice(rs.getInt("price"));
				
				groceryList.add(groceryBeen);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groceryList;
	}

	public GroceryBeen getGroceryById(int id) throws ClassNotFoundException {
		GroceryBeen bean = new GroceryBeen();
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("select * from grocery where id='" + id + "'");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bean.setIdgroocery(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setMetrixType(rs.getString(3));
				bean.setQuantity(rs.getInt(4));
				bean.setExpiryDate(rs.getDate(5));
				bean.setItemType(rs.getString(6));
				bean.setPrice(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public int deleteGrocery(int id) throws ClassNotFoundException, SQLException {
		int status = 0;
		String query = "delete from grocery where id=" + id + "";
		con = DbConnection.getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
		status = ps.executeUpdate();
		return status;
	}

	public ArrayList<GroceryBeen> getGrocery2() throws ClassNotFoundException {
		ArrayList<GroceryBeen> groceryList = new ArrayList<GroceryBeen>();
		try {
			con = DbConnection.getConnection();
			st = (Statement) con.createStatement();
			String query = "select * from grocery";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				GroceryBeen grocery = new GroceryBeen();
				grocery.setIdgroocery(rs.getInt("idgroocery"));
				grocery.setName(rs.getString("name"));
				grocery.setMetrixType(rs.getString("metrixType"));
				grocery.setQuantity(rs.getInt("quantity"));
				grocery.setExpiryDate(rs.getDate("expirydate"));
				grocery.setItemType(rs.getString("itemType"));
				grocery.setPrice(rs.getInt("price"));
				
				groceryList.add(grocery);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groceryList;
	}

	public int insertGrocery(GroceryBeen groceryBeen) {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con
					.prepareStatement("insert into grocery(name,metrixType,quantity,expirydate,itemType,price) values(?,?,?,?,?,?)");
			ps.setString(1, groceryBeen.getName());
			ps.setString(2, groceryBeen.getMetrixType());
			ps.setInt(3, groceryBeen.getQuantity());
			ps.setDate(4, groceryBeen.getExpiryDate());
			ps.setString(5, groceryBeen.getItemType());
			ps.setInt(6, groceryBeen.getPrice());
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateGrocery(GroceryBeen groceryBeen) throws ClassNotFoundException {
		int status = 0;
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(
					"update grocery set name=?,metrixType=?,quantity=?,expirydate=?,itemType=?,price=?  where id='" + groceryBeen.getIdgroocery() + "'");
			ps.setString(1, groceryBeen.getName());
			ps.setString(2, groceryBeen.getMetrixType());
			ps.setInt(3, groceryBeen.getQuantity());
			ps.setDate(4, groceryBeen.getExpiryDate());
			ps.setString(5, groceryBeen.getItemType());
			ps.setInt(6, groceryBeen.getPrice());
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
			rs = st.executeQuery("select name from grocery where  name = '" + name + "'");
			if (rs.next()) {
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "failed";
	}
}
