package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1 - FIND BY ID ===");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		
		System.out.println("=== TEST 3 - FIND ALL ===");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4 - INSERT ===");
		Department dep2 = new Department(null, "Music");
		departmentDao.insert(dep2);
		System.out.println("Inserted! New department name = " + dep2.getName());
		
		System.out.println("=== TEST 5 - UPDATE ===");
		Department dep3 = departmentDao.findById(1);
		dep3.setName("Food");
		departmentDao.update(dep3);
		System.out.println("Update Complete");
		
		System.out.println("=== TEST 6 - SELLER DELETE BY ID ===");
		System.out.println("Enter ID for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		 
		sc.close();
		

	}

}
