package org.serratec.finalproject.config;

import java.util.Arrays;
import java.util.Date;

import org.serratec.finalproject.entity.Address;
import org.serratec.finalproject.entity.Category;
import org.serratec.finalproject.entity.Customers;
import org.serratec.finalproject.entity.Employee;
import org.serratec.finalproject.entity.OrderItems;
import org.serratec.finalproject.entity.Orders;
import org.serratec.finalproject.entity.Products;
import org.serratec.finalproject.repository.CategoryRepository;
import org.serratec.finalproject.repository.CustomersRepository;
import org.serratec.finalproject.repository.EmployeeRepository;
import org.serratec.finalproject.repository.OrdersRepository;
import org.serratec.finalproject.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertData implements CommandLineRunner {

	@Autowired 
	CategoryRepository catRepository;
	
	@Autowired
	ProductsRepository prodRepository;
	
	@Autowired
	CustomersRepository custRepository;
	
	@Autowired
	OrdersRepository orderRepository;
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Address address1 = new Address (null,"Rua Fulano","50","Perto do bar","Centro","26514-101","Fulanópolis","Rio De Janeiro");
		Address address2 = new Address (null,"Rua Fulano","40","Perto do bar","Centro","26513-101","Fulanópolis","Rio De Janeiro");
		Address address3 = new Address (null,"Rua Fulano","55","Perto do bar","Centro","26514-105","Fulanópolis","Rio De Janeiro");
		Address address4 = new Address (null,"Rua Fulano","70","Perto do bar","Centro","26512-101","Fulanópolis","Rio De Janeiro");
		
		Employee emp1 = new Employee(null,"Afonso","222.333.424.89","1d6a13");
		Employee emp2 = new Employee(null,"Afonso","222.333.424.89","1d6a13");
		
		empRepository.save(emp1);
		empRepository.save(emp2);
		
		Category cat1 = new Category(null,"Cell phones","SmartPhones,IPhone");
		Category cat2 = new Category(null,"Hardware","Memory,Coolers,SSD");
		Category cat3 = new Category(null,"Computers","Desktop,Notebook");
		
		catRepository.save(cat1);
		catRepository.save(cat2);
		catRepository.save(cat3);
		
		Products prod1 = new Products(null,"Samsung", "S9 +",new Date(),1900.00,30.0,cat1);
		Products prod2 = new Products(null,"IPhone", "IPhone 8 Plus",new Date(),3100.00,3.0,cat1);
		Products prod3 = new Products(null,"Memory HyperX", "Modelo: HX424C15FB3/8GB  / Velocidades: 2400MHz",new Date(),249.90,20.0,cat2);
		Products prod4 = new Products(null,"Notebook Dell", "Inspiron 15 3000 +",new Date(),2450.90,4.0,cat3);
		
		prodRepository.save(prod1);
		prodRepository.save(prod2);
		prodRepository.save(prod3);
		prodRepository.save(prod4);
		
		Customers c1 = new Customers(null,"Douglas Tinoco","douglasmndm@gmail.com","645.215.241.54","DouglasDev",new Date(1997-01-15),"bugu31",address1);
		Customers c2 = new Customers(null,"Rafael Santana","rafaelsant@gmail.com","241.245.295.34","RafaTyDev",new Date(1993-8-20),"c1faxc1",address2);
		
		custRepository.save(c1);
		custRepository.save(c2);
		
		Orders order1 = new Orders(null,new Date(),c1);
		Orders order2 = new Orders(null,new Date(),c2);
		
		OrderItems ordItem1 = new OrderItems(null,1,prod1.getPrinceUnity(),prod1);
		OrderItems ordItem2 = new OrderItems(null,2,prod3.getPrinceUnity(),prod3);
		OrderItems ordItem3 = new OrderItems(null,1,prod4.getPrinceUnity(),prod4);
		
		order1.setItems(Arrays.asList(ordItem1,ordItem2));
		order2.setItems(Arrays.asList(ordItem3));
				
		orderRepository.save(order1);
		orderRepository.save(order2);		
	}
}
