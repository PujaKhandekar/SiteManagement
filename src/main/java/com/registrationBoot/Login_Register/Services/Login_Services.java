package com.registrationBoot.Login_Register.Services;

import java.util.List;


import com.registrationBoot.Login_Register.Entities.Login_Entities;

public interface Login_Services {

	Login_Entities newregister(Login_Entities login);

	List<Login_Entities> getAllRegisterd();

	
//	Login_Entities getDataById(int id);
	Login_Entities getDataById(int id);
	//void deleteById(int id);

	Login_Entities deleteById(int id);

	Login_Entities getRecord(int id);

	Login_Entities updateRecord(Login_Entities login_update);


	



	


//	static List<Login_Entities> Login_Entities(Login_Entities login) {
//		// TODO Auto-generated method stub
//		return (List<com.registrationBoot.Login_Register.Entities.Login_Entities>) login;
//	}

	
}
