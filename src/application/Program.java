package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data = sdf.parse("01/01/2000");

		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
		Seller sel = new Seller(1, "Leonardo", "leo@google.com", data, 5000.0, obj);
		System.out.println(sel);
	}

}
