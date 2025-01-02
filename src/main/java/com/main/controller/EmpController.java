package com.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.enties.Emp;
import com.main.service.EmpService;

@RestController
@RequestMapping("/api")
public class EmpController {

	@Autowired
	EmpService servi;

	@PostMapping("/addEmp")
	public ResponseEntity<Emp> addEmp(@RequestBody Emp emp) {

		Emp emps = servi.addemp(emp);

		return ResponseEntity.ok(emps);

	}

	@PutMapping("upEmp/{id}")
	public ResponseEntity<Emp> updateEmp(@PathVariable int id, @RequestBody Emp emp) {

		Emp bhu = servi.updateEmployee(id, emp);
		return ResponseEntity.ok(bhu);
	}

	@GetMapping("getById/{id}")
	public ResponseEntity<Optional<Emp>> getByidEmp(@PathVariable int id) {

		Optional<Emp> emp = servi.getByidEmp(id);

		return ResponseEntity.ok(emp);
	}

	@DeleteMapping("deleteEmp/{id}")
	public void deleteEmp(@PathVariable int id) {

		servi.deleteEmp(id);

	}
	
	@GetMapping("getAllEmp")
	public ResponseEntity<List<Emp>> getAllEmp() {
		
        List<Emp> bhu = servi.getAllEmp();
        
        return ResponseEntity.ok(bhu);
        
	}

}
