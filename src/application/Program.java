package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sd = DaoFactory.createSellerDao();
		List<Seller> lista = null;
		
		System.out.println("Método findById");
		Seller seller = sd.findById(3);
		System.out.println(seller);
		
		System.out.println("\nMétodo findByDepartment");
		Department dp = new Department(2, null);
		lista = sd.findByDepartment(dp);
		for(Seller sel : lista) {
			System.out.println(sel);
		}
		
		System.out.println("\nMétodo findAll");
		lista = sd.findAll();
		for(Seller sel : lista) {
			System.out.println(sel);
		}		
	}

}
