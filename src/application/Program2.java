package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao dd = DaoFactory.createDepartmentDao();
		Department dp = new Department();
		
		System.out.println("M�todo INSERT");
		dp = new Department(null, "Cosmetics");
		//dd.insert(dp);
		System.out.println("ID do novo departamento: " + dp.getId());
		
		System.out.println("\nM�todo UPDATE");		
		dp = dd.findById(6);
		if(dp != null) {
			dp.setName("Auto");
			dd.update(dp);
			System.out.println("Registro atualizado com sucesso!");
		} else {
			System.out.println("Nenhum registro encontrado com o ID informado!");
		}
		
		System.out.println("\nM�todo DELETE");
		dp = dd.findById(14);
		if(dp != null) {
			dd.deleteById(dp.getId());
			System.out.println("Registro ID = " + dp.getId() + " exclu�do com sucesso do banco de dados!");
		} else {
			System.out.println("Registro n�o encontrado no banco de dados");
		}
		
		System.out.println("\nM�todo findAll");
		List<Department> lista = new ArrayList<>();
		lista = dd.findAll();
		for(Department dep : lista) {
			System.out.println(dep);
		}
	}
}
