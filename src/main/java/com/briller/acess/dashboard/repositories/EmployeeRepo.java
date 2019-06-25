package com.briller.acess.dashboard.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.briller.acess.dto.Employee;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Integer> {
	
	Employee findByEmployeeId(int empId);
	
	@Query(value = "select first_name from Employee where employee_id= ?1", nativeQuery = true)
	public String getFirstName(Integer employeeId);

}
