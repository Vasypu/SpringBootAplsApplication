package com.grokonez.restapi.repository;

import java.util.List;

//import com.grokonez.restapi.model.Customer;
import org.springframework.data.repository.CrudRepository;
import com.grokonez.restapi.model.Point;

public interface CustomerRepository extends CrudRepository<Point, Long>{
	List<Point> findByLastName(String lastName);
}
