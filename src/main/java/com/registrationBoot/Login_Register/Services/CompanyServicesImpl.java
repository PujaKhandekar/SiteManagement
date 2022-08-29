package com.registrationBoot.Login_Register.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registrationBoot.Login_Register.Entities.CompanyEntities;
import com.registrationBoot.Login_Register.Entities.SiteCompanyEntities;
import com.registrationBoot.Login_Register.Repository.CompanyRepository;

@Service
public class CompanyServicesImpl implements CompanyServices {

	@Autowired
	CompanyRepository companyRepository;
	@Override
	public List<CompanyEntities> getAllCompany() {
		List<CompanyEntities> list = (List<CompanyEntities>) this.companyRepository.findAll();
		System.out.println("list_____________   "+list);
		return list;
	}
	
	@Override
	public List<SiteCompanyEntities> getAllSitCompany() {
		//List<SiteCompanyEntities> list = this.companyRepository.fi
		return null;
	}
	

}
