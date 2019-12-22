package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		
		SellerDao sd = DaoFactory.createSellerDao();
		Seller seller = sd.findById(3);
		System.out.println(seller);
		
		Department dp = new Department(2, null);
		List<Seller> lista = sd.findByDepartment(dp);
		for(Seller sel : lista) {
			System.out.println(sel);
		}
		
	}

}
