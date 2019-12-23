package application;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sd = DaoFactory.createSellerDao();
		List<Seller> lista = null;
		Seller seller = null;
		Department dp = new Department(3, null);
		
		System.out.println("Método insert");
		//seller = new Seller(null, "Leonardo", "leonardo@globo.com", new Date(), 5000.0, dp);
		//sd.insert(seller);
		//System.out.println("ID do novo vendedor: " + seller.getId());
		
		System.out.println("\nMétodo update");
		seller = sd.findById(10);
		if(seller != null) {
			seller.setName("Anderson");
			sd.update(seller);
			System.out.println("Registro atualizado com sucesso!");
		} else {
			System.out.println("O ID informado não consta no banco de dados!");
		}
		
		System.out.println("\nMétodo delete");
		seller = sd.findById(12);
		if(seller != null) {
			sd.deleteById(seller.getId());
			System.out.println("Registro deletado com sucesso!");
		} else {
			System.out.println("O ID informado não consta no banco de dados!");
		}
		
		System.out.println("\nMétodo findById");
		seller = sd.findById(8);
		System.out.println(seller);
		
		System.out.println("\nMétodo findByDepartment");
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
