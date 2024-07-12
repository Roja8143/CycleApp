package com.edubridge.CycleApp.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.edubridge.CycleApp.model.Cycle;
import com.edubridge.contactapp.util.DBUtils;
public  class CycleDaoImpl implements CycleDao {

	@Override
	public int addCycle(Cycle c) {
		String INSERT ="insert into cycle(categories,cycle_name,price,colour) values(?,?,?,?)";
		Connection con = DBUtils.getConnection();
		int status =0;
		try {
			PreparedStatement ps =con.prepareStatement(INSERT);
			ps.setNString(1,c.getCategories());
			ps.setString(2,c.getName());
			ps.setInt(3,c.getPrice());
			ps.setString(4,c.getColour());
			
			status=ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Cycle> getAllCycles() {
		String SELECT ="select * from cycle";
		Connection con = DBUtils.getConnection();
		List<Cycle>cycle= new ArrayList<Cycle>();
				
		try {
			PreparedStatement ps =con.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cycle c=new Cycle();
				ps.setNString(1,c.getCategories());
				ps.setString(2,c.getName());
				ps.setInt(3,c.getPrice());
				ps.setString(4,c.getColour());
				cycle.add(c);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cycle;
	}

			@Override
	public Cycle getCycle(String name ) {
		
				String SELECT_BY_NAME="select * from Cycle where name=?";
				Connection con =DBUtils.getConnection();
			Cycle c =new Cycle();
					
				try {
					PreparedStatement ps=con.prepareStatement(SELECT_BY_NAME);
					ps.setString(2,name);
					ResultSet rs=ps.executeQuery();
					if(rs.next()) {
						ps.setNString(1,c.getCategories());
						ps.setString(2,c.getName());
						ps.setInt(3,c.getPrice());
						ps.setString(4,c.getColour());
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				return c;
	}

	@Override
	public int updateCycle(Cycle c) {
		String UPDATE = "update Cycle set Cycle_name = ?,price = ?,colour =? where Cycle categories = ?";
	    Connection con = DBUtils.getConnection();
	    int status = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement(UPDATE);
	        ps.setNString(1,c.getCategories());
			ps.setString(2,c.getName());
			ps.setInt(3,c.getPrice());
			ps.setString(4,c.getColour());
			
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	return status;
}
		
	

	@Override
	public int deleteCycle(String name) {
		// TODO Auto-generated method stub
		String DELETE = "delete from Cycle where name= ?";
	    Connection con = DBUtils.getConnection();
	    int status = 0;
	    try {
	        PreparedStatement ps = con.prepareStatement(DELETE);
	       
	        ps.setNString(1,name);
			
	        status = ps.executeUpdate();
	    } catch (SQLException e) {
	    	
	        e.printStackTrace();
	    }
		return status;
	}
	

	@Override
	public void deleteAllCycle() {
		String DELETE_ALL = "delete from Cycle";
	    Connection con = DBUtils.getConnection();
	    try {
	        PreparedStatement ps = con.prepareStatement(DELETE_ALL);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }		
	}


	
	}

	

		
