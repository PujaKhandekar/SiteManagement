package com.registrationBoot.Login_Register.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.registrationBoot.Login_Register.Entities.Login_Entities;
import com.registrationBoot.Login_Register.Repository.Login_Repository;

@Service
public class Login_Services_Impl implements Login_Services{
	
	@Autowired
	Login_Repository login_Repository;

	PasswordEncoder passwordEncoder;
	@Override
//	public Login_Entities newregister(Login_Entities login) {
//		Login_Entities save = login_Repository.save(login);
//		return save;
//	}
	
	public Login_Entities newregister(Login_Entities login) {
//		String encodedPassword = this.passwordEncoder.encode(login.getPassword());
//	    login.setPassword(this.passwordEncoder.encode(login.getPassword()));
	    
//		String encodedPassword = this.passwordEncoder.encode(login.getPassword());
//		login.setPassword(encodedPassword);
		Login_Entities save = login_Repository.save(login);
		return save;
	}
	@Override
	public List<Login_Entities> getAllRegisterd() {
		List<Login_Entities> list = this.login_Repository.findAll();
		System.out.println("list login services impl "+list);		
		return list;
	}
	
	@Override
	public Login_Entities getDataById(int id) {
		Login_Entities login_data = null;
		try {
			login_data=this.login_Repository.findById(id);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return login_data;
	}
	
//	@Override
//	public void deleteById(int id) {
//		System.out.println("id repo "+id);
//		Login_Entities login = login_Repository.getOne(id);
//		login_Repository.delete(login);
//	}
	
	@Override
	public Login_Entities deleteById(int id) {
		System.out.println("id repo "+id);
		Login_Entities login = login_Repository.getOne(id);
		login_Repository.delete(login);
		return login;
	}
	@Override
	public Login_Entities getRecord(int id) {
		System.out.println("id for update "+id);
		return login_Repository.getById(id);
	}
//	@Override
//	public Login_Entities addrecord(Login_Entities login_update) {
//		System.out.println("update save login_update "+login_update);
//		login_Repository.save();
//		return login_update;
//		
//		
//	}
	@Override
	public Login_Entities updateRecord(Login_Entities login_update) {
		login_Repository.save(login_update);
		System.out.println("Update login record   "+login_update);
		return login_update;
	}
	
	

}
