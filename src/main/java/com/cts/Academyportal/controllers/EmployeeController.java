package com.cts.Academyportal.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.Academyportal.Dao.EmployeeDao;
import com.cts.Academyportal.models.AdminLogin;
import com.cts.Academyportal.models.EmployeeLogin;
import com.cts.Academyportal.models.EmployeeReg;

@Controller
public class EmployeeController {

	
	@Autowired
	private EmployeeDao dao;
	@GetMapping(value="/employee")
	 public String admin(Model model) {
		EmployeeReg reg=new EmployeeReg();
		 model.addAttribute("employee",reg);
		 return "EmployeeReg";
	 }
	@PostMapping(value="/employeereg")
	public String adminreg(@ModelAttribute("employee") EmployeeReg employeereg,Model model) {
		
		employeereg.setStatus("no");
		EmployeeReg er= dao.save(employeereg);
		if(er!=null) {
		model.addAttribute("message","Your details are submitted successfully.");
		model.addAttribute("msg","your userid is: "+er.getUserId());
		return "EmployeeReg";
		}else {
			model.addAttribute("message","Oops...Something went wrong.");
			return "failure";
		}
		
	}
	@GetMapping(value="/employeelogin")
	public String adminlogin(Model model) {
		EmployeeLogin employeelogin=new EmployeeLogin();
		model.addAttribute("employeelogin", employeelogin);
		return "Employeelogin";
	}
	@PostMapping(value="/employeeloginverify")
	public String employeeloginverify(@ModelAttribute("employeelogin") EmployeeLogin emplogin,Model model,HttpSession session) {
		
		EmployeeReg ereg=dao.findById(emplogin.getUserId());

		if(ereg!=null) {
			
			if(ereg.getPassword().equals(emplogin.getPassword())&& ereg.getStatus().equalsIgnoreCase("yes") ) {
				session.setAttribute("name", ereg.getUserId());
				return "EmployeeHome";
			}else if(ereg.getStatus().equalsIgnoreCase("no"))	{
				model.addAttribute("message", "Wait for admin confirmation");
				return "Employeelogin";
			}
		}
		model.addAttribute("message", "Invalid userId or password");
		return "Employeelogin";
	
		
	}

	@GetMapping("/employeelogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}

}
