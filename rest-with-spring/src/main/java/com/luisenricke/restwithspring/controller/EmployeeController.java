package com.luisenricke.restwithspring.controller;

import com.luisenricke.restwithspring.entity.Employee;
import com.luisenricke.restwithspring.exception.EmployeeNotFoundException;
import com.luisenricke.restwithspring.repository.EmployeeRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Aggregate root

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    EntityModel<Employee> one(@PathVariable Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return new EntityModel<>(employee,
                                 WebMvcLinkBuilder
                                         .linkTo(WebMvcLinkBuilder.methodOn(
                                                 EmployeeController.class
                                         ).one(id))
                                         .withSelfRel(),
                                 WebMvcLinkBuilder
                                         .linkTo(WebMvcLinkBuilder.methodOn(
                                                 EmployeeController.class
                                         ).all())
                                         .withRel("employees")
        );
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
