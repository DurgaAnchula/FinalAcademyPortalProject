package com.cts.Academyportal.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.Academyportal.Dao.FacultyDao;
import com.cts.Academyportal.Services.FacultyServices;
import com.cts.Academyportal.models.EmployeeLogin;
import com.cts.Academyportal.models.EmployeeReg;
import com.cts.Academyportal.models.Faculty;
import com.cts.Academyportal.models.FacultyLogin;
import com.cts.Academyportal.models.SkillsReg;

@Controller
public class FacultyController {
	@Autowired
	private FacultyServices facultyServices;
	@Autowired
	private FacultyDao fdao;

	@GetMapping("/faculty")
     public String   facutyRegistrationForm(Model model)
     {
	     List<SkillsReg> skillslist = facultyServices.getAllSkills();
	     
	     
		Set<String> skillfamily= new HashSet<String>();
		
		skillslist.forEach(t->{
		 skillfamily.add(t.getSkillfamily());
		});
    	 
    	Faculty faculty = new Faculty(); 
    	
    	
    	model.addAttribute("skillsList", skillslist);
    	model.addAttribute("skillfamily",skillfamily);
    	model.addAttribute("faculty", faculty);
    	
    	return "FacultyReg";
    	 
     }
	@PostMapping(value="/facultyreg")
	public String facultyreg(@ModelAttribute("faculty") Faculty faculty,Model model) {
		
	faculty.setStatus("no");
		Faculty f= fdao.save(faculty);
		if(f!=null) {
		model.addAttribute("message","Your details are submitted successfully.");
		model.addAttribute("msg","your userid is: "+f.getUserId());
		return "FacultyReg";
		}else {
			model.addAttribute("message","Oops...Something went wrong.");
			return "failure";
		}
		
	}
	@GetMapping(value="/facultylogin")
	public String facultylogin(Model model) {
		FacultyLogin facultylogin=new FacultyLogin();
		model.addAttribute("facultylogin", facultylogin);
		return "Facultylogin";
	}
	@PostMapping(value="/facultyloginverify")
	public String facultyloginverify(@ModelAttribute("facultylogin") FacultyLogin facultylogin,Model model,HttpSession session) {
		
		Faculty freg=fdao.findById(facultylogin.getUserId());

		if(freg!=null) {
			
			if(freg.getPassword().equals(facultylogin.getPassword())&& freg.getStatus().equalsIgnoreCase("yes") ) {
				session.setAttribute("name", freg.getUserId());
				return "FacultyHome";
			}else if(freg.getStatus().equalsIgnoreCase("no"))	{
				model.addAttribute("message", "Wait for admin confirmation");
				return "Facultylogin";
			}
		}
		model.addAttribute("message", "Invalid userId or password");
		return "Facultylogin";
	
		
	}

	@GetMapping("/facultylogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}


}
