package com.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.enties.Emp;
import com.main.repository.EmpRepository;

@Service
public class EmpService {

	@Autowired
	EmpRepository repo;

	public Emp addemp(Emp emp) {

		return repo.save(emp);
	}

	public Emp updateEmployee(int id, Emp emp) {

		return repo.findById(id).map(i -> {
			i.setName(emp.getName());
			i.setEmail(emp.getEmail());
			i.setAge(emp.getAge());
			return repo.save(i);
		}).orElseThrow(() -> new RuntimeException("Employee not found " + id));

	}

	public Optional<Emp> getByidEmp(int id) {

		return repo.findById(id);

	}

	public void deleteEmp(int id) {

		repo.deleteById(id);
	}

	public List<Emp> getAllEmp() {
		List<Emp> emp = repo.findAll();
		return emp;
	}

}
