package com.example.entity; 

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee")
public class Employee{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long empId;
	@NotNull
	private String empName;

	
	 @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="employee")
	 private List<Address> addresses= new ArrayList<>();
	 
		
	

	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Employee() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empName, List<Address> addresses) {
		//super();
		this.empName = empName;
		this.addresses = addresses;
	}
	
	
}