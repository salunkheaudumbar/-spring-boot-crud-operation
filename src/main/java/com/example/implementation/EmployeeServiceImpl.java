package com.example.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.repository.AddressRepository;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();

	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee em = new Employee();
		em.setEmpName(employee.getEmpName());
		Employee e1 = employeeRepository.save(em);
		employee=(Employee) addressRepository.saveAll(employee.getAddresses());
		//return e1;
		
		return this.employeeRepository.save(employee);
		
		
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		this.employeeRepository.deleteById(id);

	}

	@Override
	public void updateEmployee(Employee e, long id) {
		// TODO Auto-generated method stub
		e.setEmpId(id);
		this.employeeRepository.save(e);

	}

}
