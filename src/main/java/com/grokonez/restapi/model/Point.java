package com.grokonez.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "point")
public class Point{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "coordinates")
	private String coordinates;

	@Column(name = "description")
	private String description;

	protected Point() {
	}

	public Point (String coordinates, String description) {
		this.coordinates = coordinates;
		this.description = description;
	}

	public long getId() { return id; }

	@Override
	public String toString() {
		return String.format("Point[id=%d, coordinates='%s', description='%s']", id, coordinates, description);
	}
}


//package com.grokonez.restapi.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "customer")
//public class Customer{
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//
//	@Column(name = "firstname")
//	private String firstName;
//
//	@Column(name = "lastname")
//	private String lastName;
//
//	protected Customer() {
//	}
//
//	public Customer(String firstName, String lastName) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//
//	@Override
//	public String toString() {
//		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
//	}
//}