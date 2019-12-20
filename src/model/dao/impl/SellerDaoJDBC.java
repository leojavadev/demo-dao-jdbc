package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private static Connection conn = null;
	private static Statement st = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;

	@Override
	public void insert(Seller obj) {
		if(conn == null) {
			try {
				conn = DB.getConnection();
				pst = conn.prepareStatement("INSERT INTO seller "
						+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES "
						+ "(?, ?, ?, ?, ?)");
				pst.executeUpdate();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			finally {
				DB.closePreparedStatement();
				DB.closeConnection();
			}
		}
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
