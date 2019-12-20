package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;

public class Program {

	public static void main(String[] args) {

		SellerDao sd = DaoFactory.createSellerDao();
		System.out.println(sd.findById(3));
		
		DepartmentDao dd = DaoFactory.createDepartmentDao();
	}

}
