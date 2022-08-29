package com.registrationBoot.Login_Register.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.registrationBoot.Login_Register.Entities.CompanyEntities;
import com.registrationBoot.Login_Register.Entities.SiteCompanyEntities;
import com.registrationBoot.Login_Register.Entities.SiteEntities;
import com.registrationBoot.Login_Register.Services.CompanyServices;
import com.registrationBoot.Login_Register.Services.SiteServices;
import com.registrationBoot.Login_Register.Validation.SiteValidation;

@RestController
@CrossOrigin
public class SiteController {

	@Autowired
	SiteServices siteServices;
	
	@Autowired
	CompanyServices companyServices;
	
	@Autowired
	SiteValidation siteValidation;
	
	@GetMapping("/siteCompany")
	public ResponseEntity<Map> getSiteCompany(){
		List<SiteCompanyEntities> SiteCmplist = new ArrayList<SiteCompanyEntities>();
		SiteCmplist = this.companyServices.getAllSitCompany();
//		List<CompanyEntities> Cmplist = this.companyServices.getAllCompany();
//		List<SiteEntities> Cmplist = this.siteServices.getAllCompany();

		System.out.println("Company wise site Cmplist using get mapping  "+SiteCmplist);
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("Record", SiteCmplist);
		m.put("status", true);
		m.put("msg", "Showing all data");
		System.out.println("site record  "+m);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}	
	
//	get all company record
	@GetMapping("/companyrecord")
	public ResponseEntity<Map> getcompany(){
		List<CompanyEntities> Cmplist = new ArrayList<CompanyEntities>();
		Cmplist = this.companyServices.getAllCompany();
//		List<CompanyEntities> Cmplist = this.companyServices.getAllCompany();
//		List<SiteEntities> Cmplist = this.siteServices.getAllCompany();

		System.out.println("companyrecord Cmplist using get mapping  "+Cmplist);
		Map<String, Object> m=new HashMap<String, Object>();
		m.put("All sites", Cmplist);
		m.put("status", true);
		m.put("msg", "Showing all data successfully");
		System.out.println("site record  "+m);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}	
	
//	@Value ("${SiteEntities.deletestatus}")
//	private String deletestatus;
//	create site
	@PostMapping("/site")
	public ResponseEntity<Map> newregister(@Valid @RequestBody SiteEntities siteEntities){
//		List<SiteCompanyWise> list = new ArrayList<SiteCompanyWise>();
//		list = siteServices.getAllSiteCmp();
		Map<String, Object> m=new HashMap<String, Object>();
		SiteEntities siteEntities2 = null;

		try {
		List<CompanyEntities> Cmplist = new ArrayList<CompanyEntities>();
		Cmplist = this.companyServices.getAllCompany();
		System.out.println("POST companyrecord Cmplist using get mapping  "+Cmplist);
		
		siteEntities2 = this.siteServices.createSite(siteEntities);
			System.out.println(siteEntities+ " _________post mapping book_________ " +siteEntities2 );
//			Map<String, Object> m=new HashMap<String, Object>();
			m.put("Site", siteEntities2);
			m.put("status", true);
			m.put("msg", "Site create successfully");
			return new ResponseEntity<Map>(m,HttpStatus.CREATED);
			}catch (Exception e) {
				m.put("Site", siteEntities2);
				m.put("status", false);
				m.put("msg", "create again");
				return new ResponseEntity<Map>(m,HttpStatus.NOT_FOUND);
			}
	}
	
//	get all site record
	@GetMapping("/get-sites")
	public ResponseEntity<Map> getallsite(){
		List<SiteEntities> list = new ArrayList<SiteEntities>();
		list = siteServices.getAllSites();
//		List<SiteEntities> list = siteServices.getAllSites();
		Map<String, Object> m=new HashMap<String, Object>();

		if(list == null) {
			m.put("Empty", list);
			m.put("status", false);
			m.put("msg","record not found");
			return new ResponseEntity<Map>(m,HttpStatus.NOT_FOUND);
		}
		System.out.println("list using get mapping  "+list);
		m.put("All sites", siteServices.getAllSites());
		m.put("status", true);
		m.put("msg", "Showing all data");
		System.out.println("site record  "+m);
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
//	get record by id
	@GetMapping("/siterecord/{id}")
	public ResponseEntity<Map> getSiteById(@PathVariable("id") int id){
		Map<String, Object> m=new HashMap<String, Object>();
		SiteEntities siteEntities = siteServices.getSiteById(id);
		if(siteEntities == null) {
			m.put("Empty", siteEntities);
			m.put("status", false);
			m.put("msg","record not found");
			return new ResponseEntity<Map>(m,HttpStatus.NOT_FOUND);
		}
		
		m.put("Record", siteEntities);
		m.put("status", true);
		m.put("msg","Record showing id wise");
		return new ResponseEntity<Map>(m,HttpStatus.OK);
	}
	
//	update record by id
	@PutMapping("siterecord/{id}")
	public ResponseEntity<Map> updateRecord(@RequestBody SiteEntities siteEntities, @PathVariable ("id") int id) {
		SiteEntities siteUpdate = null;
		Map m= new HashMap();
		try {
		SiteEntities site_update =siteServices.getSiteById(id);
		System.out.println("login_update >>>>>>>>>>>>>>>"+site_update);
		
		site_update.setId(siteEntities.getId());
		site_update.setCompanyname(siteEntities.getCompanyname());
		site_update.setSitename(siteEntities.getSitename());
		site_update.setPlace(siteEntities.getPlace());
		site_update.setOwner(siteEntities.getOwner());
		site_update.setFixedamount(siteEntities.getFixedamount());
		site_update.setCreatdate(siteEntities.getCreatdate());
		site_update.setDeletestatus(siteEntities.getDeletestatus());
		
		siteUpdate = this.siteServices.updateSiteRecord(site_update);	
		
		m.put("status", true);
		m.put("Record",siteUpdate);
		m.put("msg","Site update successfully");
		return new ResponseEntity<Map>(m,HttpStatus.OK);
		}catch (Exception e) {
			m.put("status", false);
			m.put("message","Recod not updated");
			return new ResponseEntity<Map>(m,HttpStatus.NOT_MODIFIED);
	}
	}
	
	@DeleteMapping("/siterecord/{id}")
	public ResponseEntity<Map> deleterecord(@PathVariable("id") int id){
		Map m=new HashMap<String, Object>();
		SiteEntities siteEntities = null;
//		try {
			 siteEntities = siteServices.deleteSiteById(id);
			 System.out.println("siteEntities  "+siteEntities);
			 m.put("record", siteEntities);
			 m.put("status", true);
			 m.put("msg", "Site Delete Successfully");
		    return new ResponseEntity<Map>(m,HttpStatus.OK);

		}

	
	}
//}
