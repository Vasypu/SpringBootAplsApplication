//package com.grokonez.restapi.controller;
//
//import java.util.Arrays;
//
//import com.grokonez.restapi.dao.PointDAO;
//import com.grokonez.restapi.model.Point;
//import com.grokonez.restapi.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
////import com.grokonez.restapi.model.Customer;
////import com.grokonez.restapi.repository.CustomerRepository;
//
//@RestController
//public class RestAPIsController {
//	@Autowired
//	CustomerRepository repository;
//	private final PointDAO pointDAO;
//
//	@Autowired
//	public RestAPIsController(PointDAO pointDAO) { this.pointDAO = pointDAO; }
//
////	@RequestMapping("/new")
////	public String process(){
////		// create new Point
////		pointDAO.create();
////		return "Done";
////	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<Point> findById(@PathVariable("id") int id, Model model) {
//
//		model.addAttribute("point", pointDAO.findById(id));
//		return ResponseEntity.ok().body(pointDAO.findById(id));
//	}
//
//	@RequestMapping("/create")
//	public ResponseEntity<?> createNewPoint() {
//
//		String result = "";
//
//		Point point = new Point("Stiv", "Madorskiy");
//		repository.save(point);
//
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}
//
////	@RequestMapping("/delete")
////	public String deletePoint(@RequestParam("lastname") String lastName) {
////
////		String result = "";
////
////		for(Customer cust: repository.findByLastName(lastName)){
////			repository.delete(cust);
////		}
////
////		return "Deleted";
////	}
//}

package com.grokonez.restapi.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.restapi.model.Customer;
import com.grokonez.restapi.repository.CustomerRepository;

@RestController
public class RestAPIsController {
	@Autowired
	CustomerRepository repository;

	@RequestMapping("/save")
	public String process(){
		// save a list of Customers
		repository.save(Arrays.asList(new Customer("Jack", "Smith"), new Customer("Adam", "Johnson"), new Customer("Kim", "Smith"),
				new Customer("David", "Williams"), new Customer("Peter", "Davis")));

		return "Done";
	}

	@RequestMapping("/findall")
	public String findAll(){
		String result = "";

		for(Customer cust : repository.findAll()){
			result += cust.toString() + "<br>";
		}

		return result;
	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}

	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "";

		for(Customer cust: repository.findByLastName(lastName)){
			result += cust.toString() + "<br>";
		}

		return result;
	}

	@RequestMapping("/new")
	public String createNewPoint() {

		String result = "";

		Customer customer = new Customer("Stiv", "Madorskiy");
		result = repository.save(customer).toString();
		return result;
	}

	@RequestMapping("/delete")
	public String deletePoint(@RequestParam("lastname") String lastName) {

		String result = "";

		for(Customer cust: repository.findByLastName(lastName)){
			repository.delete(cust);
		}

		return "Deleted";
	}
}