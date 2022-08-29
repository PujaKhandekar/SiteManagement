package com.registrationBoot.Login_Register.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.registrationBoot.Login_Register.Entities.Login_Entities;
import com.registrationBoot.Login_Register.Repository.Login_Repository;
import com.registrationBoot.Login_Register.Services.Login_Services;

@RestController
@CrossOrigin
public class LoginController {

@Autowired
Login_Services login_Services;

//@PostMapping("/register")
//public Login_Entities newregister(@RequestBody Login_Entities login) {
//	return this.login_Services.newregister(login);
//	
//}
//@GetMapping("/Allregister")
//public ResponseEntity<List<Login_Entities>> getregister(){
//	List<Login_Entities> list = login_Services.getAllRegisterd();
//	System.out.println("list using get mapping  "+list);
////	if(list.size()<=0) {
////		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
////	}
//	//return ResponseEntity.status(HttpStatus.CREATED).body(list);
//	return new ResponseEntity<List<Login_Entities>>(HttpStatus.CREATED);
//}


//delete single record handler 	WORKING
//@DeleteMapping("/registerById/{id}")
//public ResponseEntity<HttpStatus> getById(@PathVariable("id") int id){
////	Map m=new HashMap();
//	System.out.println("idiiddi"+id);
//	try {
//		this.login_Services.deleteById(id);
//	       return new ResponseEntity<>(HttpStatus.OK);
//	   }catch(Exception e){
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	   }
//	}

// Record deleted but it is not shiwing in output tab
//@DeleteMapping("/registerById/{id}")
//public ResponseEntity<Map> getById(@PathVariable("id") int id){
//	Map m=new HashMap();
//	Login_Entities delete_log = null;
//	System.out.println("idiiddi"+id);
//	try {
//		delete_log = this.login_Services.deleteById(id);
//		
//		m.put("Record Deleted", delete_log);
//		m.put("status", true);
//		return new ResponseEntity<Map>(m,HttpStatus.OK);
//	       //return new ResponseEntity<>(HttpStatus.OK);
//	   }catch(Exception e){
//		   m.put("Record Again Detele", delete_log);
//			m.put("status", false);
//	        return new ResponseEntity<Map>(m,HttpStatus.INTERNAL_SERVER_ERROR);
//	   }
//	}


// login using username and password


//delete single record handler done bt not showing in output
@DeleteMapping("/registerById/{id}")
public ResponseEntity<Map> getRecordByID(@PathVariable("id") int id){
	Map m=new HashMap<String, Object>();
	Login_Entities login_Entities = null;
	try {
	 login_Entities = login_Services.deleteById(id);
	 
	 System.out.println("login_Entities ++++  "+login_Entities);
//	if(login_Entities == null) {
//		m.put("Record Again Detele", login_Entities);
//		m.put("status", false);
//        return new ResponseEntity<Map>(m,HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	m.put("Record Deleted", login_Entities);
	m.put("status", true);
	return new ResponseEntity<Map>(m,HttpStatus.OK);
	}catch (Exception e) {
		m.put("Delete again", login_Entities);
		m.put("status", false);
		return new ResponseEntity<Map>(m,HttpStatus.NOT_FOUND);
	}
}

//@DeleteMapping("registerById/{id}")
//public ResponseEntity<Map> getRecordByID(@RequestBody Login_Entities login_Entities, @PathVariable ("id") int id) {
//	Login_Entities delete = null;
//	Map m= new HashMap();
//	try {
//	Login_Entities login_update =login_Services.getDataById(id);
//	System.out.println("login_Delete >>>>>>>>>>>>>>>"+login_update);
//	
//	login_update.setId(login_Entities.getId());
//	login_update.setEmail(login_Entities.getEmail());
//	login_update.setPassword(login_Entities.getPassword());
//	login_update.setUsername(login_Entities.getUsername());
//	login_update.setMobileno(login_Entities.getMobileno());
//	
//	delete = this.login_Services.deleteById(id);	
//	
//	m.put("status", true);
//	m.put("message",delete);
//	return new ResponseEntity<Map>(m,HttpStatus.OK);
//	}catch (Exception e) {
//		m.put("status", false);
//		m.put("message","Recod not updated");
//		return new ResponseEntity<Map>(m,HttpStatus.NOT_MODIFIED);
//}
//}

@PutMapping("registerById/{id}")
public ResponseEntity<Map> updateRecord(@RequestBody Login_Entities login_Entities, @PathVariable ("id") int id) {
	Login_Entities update = null;
	Map m= new HashMap();
	try {
	Login_Entities login_update =login_Services.getDataById(id);
	System.out.println("login_update >>>>>>>>>>>>>>>"+login_update);
	
	login_update.setId(login_Entities.getId());
	login_update.setEmail(login_Entities.getEmail());
	login_update.setPassword(login_Entities.getPassword());
	login_update.setUsername(login_Entities.getUsername());
	login_update.setMobileno(login_Entities.getMobileno());
	
	update = this.login_Services.updateRecord(login_update);	
	
	m.put("status", true);
	m.put("message",update);
	return new ResponseEntity<Map>(m,HttpStatus.OK);
	}catch (Exception e) {
		m.put("status", false);
		m.put("message","Recod not updated");
		return new ResponseEntity<Map>(m,HttpStatus.NOT_MODIFIED);
}
}

//@PutMapping("/registerById/{id}")
//public ResponseEntity<Login_Entities>updateRecord(@PathVariable ("id") int id){
//  try{
//     System.out.println("id for update record  "+id);                         
//     this.login_Services.updateRecord(id);
//     return new ResponseEntity<>(HttpStatus.OK);
// }catch(Exception e){
//      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
// }
//}

//get single record handler
@GetMapping("/registerById/{id}")
public ResponseEntity<Map> getRecord(@PathVariable("id") int id){
	Map<String, Object> m=new HashMap<String, Object>();
	Login_Entities login_Entities = login_Services.getDataById(id);
	if(login_Entities == null) {
		m.put("No record", login_Entities);
		m.put("status", false);
		return new ResponseEntity<Map>(m,HttpStatus.NOT_FOUND);
	}
	
	m.put("All Records", login_Entities);
	m.put("status", true);
	return new ResponseEntity<Map>(m,HttpStatus.OK);
}

//get all record handler
@GetMapping("/Allregister")
public ResponseEntity<Map> getregister(){
	List<Login_Entities> list = login_Services.getAllRegisterd();
	System.out.println("list using get mapping  "+list);
//	return new ResponseEntity<List<Login_Entities>>(HttpStatus.CREATED);
	Map<String, Object> m=new HashMap<String, Object>();
//	m.put("adminList", adminRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
	m.put("Register", login_Services.getAllRegisterd());
	m.put("status", true);
	m.put("msg", "Showing all data");
	
//	Map m= new HashMap();
//	m.put("status", true);
//	m.put("message","Update Sucess");
	System.out.println("M++++++++ LIST  "+m);
	return new ResponseEntity<Map>(m,HttpStatus.OK);
}
	
// insert new record
@PostMapping("/register")
public ResponseEntity<Map> newregister(@RequestBody Login_Entities login){
	Login_Entities b = null;
//	try {
		 b = this.login_Services.newregister(login);
//		 b = new Login_Entities(HttpStatus.OK);
		System.out.println(login+ " _________post mapping book_________ " +b);
		
		Map<String, Object> m=new HashMap<String, Object>();
//		m.put("adminList", adminRepo.findAll(Sort.by(Sort.Direction.ASC, "name")));
		m.put("New Register", b);
		m.put("status", true);
		return new ResponseEntity<Map>(m,HttpStatus.CREATED);
//	}catch (Exception e) {
//		e.getStackTrace();
//		return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);

//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
//		b = new Login_Entities(HttpStatus.OK, "Added successfully");
//		return new ResponseEntity<Login_Entities>(b,HttpStatus.NOT_FOUND);
//	}
}


//@SuppressWarnings("unchecked")
//@PostMapping("/register_response")
//public ResponseEntity<APISuccessResponse> newregister(@RequestBody Login_Entities login){
//	APISuccessResponse response = null;
//	List<Login_Entities> Register_Rec = null;
//	try {
//		Register_Rec = Login_Services.getRegister(login);
//		response = new APISuccessResponse(HttpStatus.OK, "get Users List", Register_Rec);
//		System.out.println(login+ "post mapping book");
////		return ResponseEntity.status(response,HttpStatus.CREATED).build();
//	}catch (Exception e) {
////		e.getStackTrace();
////		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
////		b = new Login_Entities(HttpStatus.OK, "Added successfully");
//		response = new APISuccessResponse(HttpStatus.OK, "get Users List", Register_Rec);
//	}
////	 	return new ResponseEntity<>(response, HttpStatus.OK);
//	 	  return new ResponseEntity<>(response, HttpStatus.OK);
//
//}


//@PostMapping("/register_response")
//public ResponseEntity<Login_Entities> newregister(@RequestBody Login_Entities login){
////	APISuccessResponse response = null;
//	List<Login_Entities> Register_Rec = null;
//	try {
//		Register_Rec = Login_Services.getRegister();
////		response = new APISuccessResponse(HttpStatus.OK, "get Users List", Register_Rec);
//		System.out.println(login+ "post mapping book");
//		return ResponseEntity.status(HttpStatus.CREATED).build();
//	}catch (Exception e) {
////		e.getStackTrace();
//		return (ResponseEntity<Login_Entities>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
////		b = new Login_Entities(HttpStatus.OK, "Added successfully");
////		response = new APISuccessResponse(HttpStatus.OK, "get Users List", Register_Rec);
//	}
////	 	return new ResponseEntity<>(HttpStatus.OK);
////	 	  return new ResponseEntity<>(response, HttpStatus.OK);
//
//}

}
