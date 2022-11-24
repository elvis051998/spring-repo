package com.abm.component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carPartInv2")
public class CarPartInventoryImpl2 implements CarPartInventory {
	
	@Autowired
	private DataSource dataSource;

	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "insert into tbl_carpart(part_name, car_model, price, quantity) values(?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, carPart.getPartName());
			stmt.setString(2, carPart.getCarModel());
			stmt.setDouble(3, carPart.getPrice());
			stmt.setInt(4, carPart.getQuantity());
			stmt.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close();}
			catch(Exception e) {}
		}
	}

	public List<CarPart> getAvailableParts() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			String sql = "select * from tbl_carpart";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			List<CarPart>  carP = new ArrayList<>();
		    while (rs.next()) {
		    	CarPart carpart = new CarPart();
		    	carpart.setPartNo(rs.getInt("part_no"));
		    	carpart.setPartName(rs.getString("part_name"));
		    	carpart.setCarModel(rs.getString("car_model"));
		    	carpart.setPrice(rs.getDouble("price"));
		    	carpart.setQuantity(rs.getInt("quantity"));
		    	carP.add(carpart);
		    }
		    return carP;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {
			try { conn.close();}
			catch(Exception e) {
				return null;
			}
		}
	}

	
}
