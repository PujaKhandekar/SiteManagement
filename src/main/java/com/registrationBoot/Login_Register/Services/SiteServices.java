package com.registrationBoot.Login_Register.Services;

import java.util.List;

import com.registrationBoot.Login_Register.Entities.SiteEntities;

public interface SiteServices {

	SiteEntities createSite(SiteEntities siteEntities);

	List<SiteEntities> getAllSites();

	SiteEntities getSiteById(int id);

	SiteEntities updateSiteRecord(SiteEntities site_update);

	SiteEntities deleteSiteById(int id);

	List<SiteEntities> getAllCompany();

	
	
}
