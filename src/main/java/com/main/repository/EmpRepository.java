package com.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.enties.Emp;

public interface EmpRepository extends JpaRepository<Emp,Integer> {

	
}
