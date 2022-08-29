package com.registrationBoot.Login_Register.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.registrationBoot.Login_Register.Entities.CompanyEntities;

public interface CompanyRepository extends CrudRepository<CompanyEntities, Integer>{
	public CompanyEntities findById(int id);
}
