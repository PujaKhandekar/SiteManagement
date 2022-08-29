package com.registrationBoot.Login_Register.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registrationBoot.Login_Register.Entities.SiteEntities;
import com.registrationBoot.Login_Register.Repository.CompanyRepository;
import com.registrationBoot.Login_Register.Repository.SiteRepository;

@Service
public class SiteServicesImpl implements SiteServices {

	@Autowired
	SiteRepository siteRepository;
	CompanyRepository companyRepository;
	@Override
	public SiteEntities createSite(SiteEntities siteEntities) {
		SiteEntities save = siteRepository.save(siteEntities);
		return save;
	}
	@Override
	public List<SiteEntities> getAllSites() {
//		return null;
		List<SiteEntities> list = this.siteRepository.findAll();
		return list;
	}
	@Override
	public SiteEntities getSiteById(int id) {
		SiteEntities siteData = null;
//		try {
			siteData = this.siteRepository.findById(id);
//		}catch (Exception e) {
			// TODO: handle exception
//		}
		return siteData;
	}
	@Override
	public SiteEntities updateSiteRecord(SiteEntities site_update) {
		siteRepository.save(site_update);
		return site_update;
	}
	@Override
	public SiteEntities deleteSiteById(int id) {
		SiteEntities delete_site = siteRepository.getOne(id);
		siteRepository.delete(delete_site);
		return delete_site;
	}
	@Override
	public List<SiteEntities> getAllCompany() {
		List<SiteEntities> list = this.siteRepository.findAll();
		return list;
	}
	
	
}
