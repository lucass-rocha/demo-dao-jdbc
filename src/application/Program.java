package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1 - FIND BY ID ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2 - FIND BY DEPARTMENT ===");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3 - FIND ALL ===");
		List<Seller> list2 = sellerDao.findAll();
		for(Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4 - INSERT ===");
		Seller newSeller = new Seller(null,"Greg","greg@gmail.com",new Date(),4000.00, dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("=== TEST 5 - UPDATE ===");
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update Complete");
		
		System.out.println("=== TEST 6 - SELLER DELETE BY ID ===");
		System.out.println("Enter ID for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		 
		sc.close();

		

	}

}
