package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department obj = new Department(1, "Books");
		System.out.println(obj);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date data = sdf.parse("01/01/2000");		
			Seller sel = new Seller(1, "Leonardo", "leo@google.com", data, 5000.0, obj);
			System.out.println(sel);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		SellerDao sd = DaoFactory.createSellerDao();
		DepartmentDao dd = DaoFactory.createDepartmentDao();
	}

}
