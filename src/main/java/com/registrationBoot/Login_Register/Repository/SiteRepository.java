package com.registrationBoot.Login_Register.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registrationBoot.Login_Register.Entities.SiteEntities;

public interface SiteRepository extends JpaRepository<SiteEntities, Integer>{
	public SiteEntities findById(int id);
}
