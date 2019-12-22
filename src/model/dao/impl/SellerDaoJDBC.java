package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC (Connection conn) {
		this.conn = conn;
	}
	
	private static Statement st = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void insert(Seller obj) {
		try {
			pst = conn.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) VALUES "
					+ "(?, ?, ?, ?, ?)");
			pst.setString(1, obj.getName());
			pst.setString(2, obj.getEmail());
			//pst.setDate(3, obj.getBirthDate());
			pst.setDouble(4, obj.getBaseSalary());
			pst.setInt(5, obj.getDepartment().getId());
			pst.executeUpdate();
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(pst);
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
		try {
			pst = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller "
					+ "INNER JOIN department "
					+ "ON department.Id = seller.DepartmentId "
					+ "WHERE seller.Id = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				Department dept = instantiateDepartment(rs);
				Seller sel = instantiateSeller(rs, dept);
				return sel;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}

	private Seller instantiateSeller(ResultSet rs, Department dept) throws SQLException {
		Seller sel = new Seller();
		sel.setId(rs.getInt("Id"));
		sel.setName(rs.getString("Name"));
		sel.setEmail(rs.getString("Email"));
		sel.setBirthDate(rs.getDate("BirthDate"));
		sel.setBaseSalary(rs.getDouble("BaseSalary"));
		sel.setDepartment(dept);
		return sel;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dept = new Department();
		dept.setId(rs.getInt("DepartmentId"));
		dept.setName(rs.getString("DepName"));
		return dept;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		try {
			pst = conn.prepareStatement("SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE DepartmentId = ? "
					+ "ORDER BY Name");
			pst.setInt(1, department.getId());
			rs = pst.executeQuery();
			List<Seller> lista = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>(); 
			while(rs.next()) {
				Department dp = map.get(rs.getInt("DepartmentId"));
				if(dp == null) {
					dp = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dp);
				}
				Seller sel = instantiateSeller(rs, dp);
				lista.add(sel);
			}
			return lista;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(pst);
			DB.closeResultSet(rs);
		}
	}

}
