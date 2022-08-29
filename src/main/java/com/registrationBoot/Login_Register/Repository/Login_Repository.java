package com.registrationBoot.Login_Register.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registrationBoot.Login_Register.Entities.Login_Entities;

//public interface Login_Repository extends CrudRepository<Login_Entities, Integer>{
//	public Login_Entities findById();
//}

public interface Login_Repository extends JpaRepository<Login_Entities, Integer>{
	public Login_Entities findById(int id);


	
}