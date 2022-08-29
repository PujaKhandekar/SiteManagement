package com.registrationBoot.Login_Register.Services;

import java.util.List;

import com.registrationBoot.Login_Register.Entities.CompanyEntities;
import com.registrationBoot.Login_Register.Entities.SiteCompanyEntities;

public interface CompanyServices {

	List<CompanyEntities> getAllCompany();

	List<SiteCompanyEntities> getAllSitCompany();


}
