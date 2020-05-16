package com.luisenricke.restwithspring.repository;

import com.luisenricke.restwithspring.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
