package com.cts.Academyportal.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.Academyportal.Dao.AdminDao;
import com.cts.Academyportal.Dao.BatchDao;
import com.cts.Academyportal.Dao.EmployeeDao;
import com.cts.Academyportal.Dao.FacultyDao;
import com.cts.Academyportal.Dao.ModuleDao;
import com.cts.Academyportal.Dao.SkillDao;
import com.cts.Academyportal.Services.AdminServices;
import com.cts.Academyportal.models.AdminLogin;
import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.Batch;
import com.cts.Academyportal.models.EmployeeLogin;
import com.cts.Academyportal.models.EmployeeReg;
import com.cts.Academyportal.models.Faculty;
import com.cts.Academyportal.models.ForgotUid;
import com.cts.Academyportal.models.ModuleReg;
import com.cts.Academyportal.models.SkillsReg;

@Controller
		public class AdminController {
			@Autowired
			private AdminServices adminservices;
	        @Autowired
	        private FacultyDao fdao;
			@Autowired
			private AdminDao dao;
			@Autowired
			private ModuleDao mdao;
			@Autowired
			private SkillDao sdao;
			@Autowired
			private EmployeeDao edao;
			@Autowired
			private BatchDao bdao;

			@GetMapping(value="/admin")
			 public String admin(Model model) {
				AdminReg reg=new AdminReg();
				 model.addAttribute("admin",reg);
				 return "AdminReg";
			 }
		/*	@PostMapping(value="/adminreg")
			public String adminreg(@ModelAttribute("admin") AdminReg adminreg,Model model) {
					
				model.addAttribute("adminreg",new AdminReg());
				
				int res = adminservices.CreateAdmin(adminreg);
				if(res==0)
				{
					model.addAttribute("message", adminreg.getFirstName().concat(adminreg.getLastName()).toUpperCase()+" You are already registered");
					return "AdminReg";
				
				} 
				else if(res==1)
				{
					model.addAttribute("message", adminreg.getFirstName().concat(adminreg.getLastName()).toUpperCase()+"Congrats your registration is successfull and your userid is "+adminreg.getUserId());
					return "AdminReg";
				}
				else
				{
					model.addAttribute("message", "Some thing went wrong");
					return "failure";
				}	
				}*/
		@PostMapping(value="/adminreg")
			public String adminreg(@ModelAttribute("admin") AdminReg adminreg,Model model) {
				AdminReg admin=dao.findByContactNumber(adminreg.getContactNumber());
				System.out.println("admin");
				if(admin==null) {
					AdminReg er= dao.save(adminreg);
					if(er!=null) {
							model.addAttribute("message","Your details are submitted successfully.");
							model.addAttribute("msg","your userid is: "+er.getUserId());
							return "AdminReg";
					}else {
							model.addAttribute("message","Oops...Something went wrong.");
							return "failure";
						}
				}else {
					model.addAttribute("message","You already registered");
					return "AdminReg";
				}
				}
			

			
			@GetMapping(value="/adminlogin")
			public String adminlogin(Model model) {
				AdminLogin adminlogin=new AdminLogin();
				model.addAttribute("adminlogin", adminlogin);
				return "AdminLogin";
			}
			/*@PostMapping(value="/loginverify")
			public String loginverify(@ModelAttribute("adminlogin") AdminLogin adminlogin,Model model,HttpSession session) {
            int status = service.login(adminlogin);
			
			if(status==1)
			{
				model.addAttribute("message","you are not registered");
				return "failure";
		    }
			else if(status==2)
			{
				session.setAttribute("name",adminlogin.getUserId());
				return "AdminHome";
			}
			else
			{
				model.addAttribute("message","Invalid Username OR password");
				return "failure";
			}
		
		}*/
			@PostMapping(value="/loginverify")
			public String loginverify(@ModelAttribute("adminlogin") AdminLogin adminlogin,Model model,HttpSession session) {
				Optional<AdminReg> al=dao.findById(adminlogin.getUserId());
				if(al.isPresent()) {
					AdminReg a1=al.get();
					if(a1.getPassword().equals(adminlogin.getPassword())) {
						session.setAttribute("name", a1.getUserId());
						return "AdminHome";
					}		
				}
				model.addAttribute("message", "Invalid userId or password");
				return "AdminLogin";
				
			}
			

			@GetMapping(value="/req")
			public String req(Model model) {
				List<EmployeeReg> list=(List<EmployeeReg>) edao.findAll();
				model.addAttribute("list",list);
				return "RegRequest";
			}
			
			
			@GetMapping(value="/accept")
			public String acceptreq(@RequestParam("name") long name,Model model) {
				EmployeeReg ereg=edao.findById(name);
				System.out.println(ereg);
				String status=ereg.getStatus();
				ereg.setStatus("Yes");
				edao.save(ereg);
				if(ereg.getStatus().equals(status)) {
					model.addAttribute("message","Unable to update");
				}
				return "AdminHome";
			}
			
			@GetMapping(value="/reject")
			public String rejectreq(@RequestParam("name") long name,Model model) {
				EmployeeReg ereg=edao.findById(name);
				String status=ereg.getStatus();
				ereg.setStatus("Yes");
			     edao.save(ereg);
				if(ereg.getStatus().equals(status)) {
					model.addAttribute("message","Unable to update");
				}
				return "AdminHome";
			}
			@GetMapping(value="/req1")
			public String req1(Model model) {
				List<Faculty> list=(List<Faculty>) fdao.findAll();
				model.addAttribute("list",list);
				return "facultyreq";
			}
			
			
			@GetMapping(value="/accept1")
			public String acceptreq1(@RequestParam("name") long name,Model model) {
				Faculty freg=fdao.findById(name);
				System.out.println(freg);
				String status=freg.getStatus();
				freg.setStatus("Yes");
				fdao.save(freg);
				if(freg.getStatus().equals(status)) {
					model.addAttribute("message","Unable to update");
				}
				return "AdminHome";
			}
			
			@GetMapping(value="/reject1")
			public String rejectreq1(@RequestParam("name") long name,Model model) {
				Faculty freg=fdao.findById(name);
				String status=freg.getStatus();
				freg.setStatus("Yes");
			     fdao.save(freg);
				if(freg.getStatus().equals(status)) {
					model.addAttribute("message","Unable to update");
				}
				return "AdminHome";
			}


			
			@GetMapping(value="/skills")
			 public String skill(Model model) {
				SkillsReg reg=new SkillsReg();
				 model.addAttribute("skills",reg);
				 return "SkillsReg";
			 }
			
			@PostMapping(value="/skillsreg")
			public String skillreg(@ModelAttribute("skills") SkillsReg skillsreg,Model model) {
				SkillsReg sr= sdao.save(skillsreg);
				if(sr!=null) {
				model.addAttribute("message","Skills Registered successfully.");
				return "SkillsReg";
				}else {
					model.addAttribute("message","Oops...Something went wrong.");
					return "failure";
				}
			}
			@GetMapping(value="/logout")
			public String Logout() {
				return "AdminHome";
			}
	/*		@GetMapping(value="/modules")
			 public String module(Model model) {
				ModuleReg reg=new ModuleReg();
				 model.addAttribute("modules",reg);
				 return "ModuleReg";
			 }*/
			
			@PostMapping(value="/modulereg")
			public String modulereg(@RequestParam("technology") String tech,@RequestParam("Proficiencylevel") String proficiency,@RequestParam("executiontype") String execution,@RequestParam("certificationtype") String certification,@RequestParam("certificationname") String certificationname,Model model) {
				
				ModuleReg modulereg= new ModuleReg();
				modulereg.setTechnology(tech);
				modulereg.setProficiencylevel(proficiency);
				modulereg.setExecutiontype(execution);
				modulereg.setCertificationtype(certification);
				modulereg.setCertificationname(certificationname);
				ModuleReg mr= mdao.save(modulereg);
				if(mr!=null) {
				model.addAttribute("message","Modules Registered successfully.");
			     return "AdminHome";
				}else {
					model.addAttribute("message","Oops...Something went wrong.");
					return "failure";
				}
			}

			@GetMapping("/forgotuid")
			public String fid(Model model){
				model.addAttribute("name",new ForgotUid());
				return "ForgotUid";
			}
			@PostMapping("/forgotuid1")
			public String fid1(@ModelAttribute("name") ForgotUid fid,AdminReg admin,Model model)
			{
				Long b=adminservices.fid(fid);
				if(b!=null)
				{
			  	model.addAttribute("message",b+" is your id");
				}
				else
				{
					model.addAttribute("message", "Incorrect credentials");
				}
				return "ForgotUid";
			}


			
			@GetMapping("/mapModuleskill")
			public String mapModule(Model model)
			{
				List<SkillsReg> skills = new ArrayList<SkillsReg>();
				
				sdao.findAll().forEach(t->{
					skills.add(t);
				});
				model.addAttribute("skills", skills);
				
				return "skillmodulemapper1";
			}
			
			
			@PostMapping("/skillmaper1")
			public String mapModule1(@RequestParam("skill") String skill,Model model)
			{
			SkillsReg sreg = sdao.findBySkillname(skill);
		
				List<ModuleReg> mlist = new ArrayList<ModuleReg>();
				mdao.findAll().forEach(t->{
					
					if(t.getTechnology().equalsIgnoreCase(skill))
					{
						mlist.add(t);
					}
				});
				
				model.addAttribute("skill", sreg);
				model.addAttribute("mlist", mlist);
				return "skillmodulemapper2";
			}
			
			@PostMapping("/mapskillsandmodule1")
			public String mapModule2(@RequestParam("sid") String sid, @RequestParam("module") String mid, Model model)
			{
				SkillsReg sr = sdao.findById(Integer.parseInt(sid)).get();
				ModuleReg mr = mdao.findById(Integer.parseInt(mid)).get();
				
				List<ModuleReg> mlist = sr.getModules();
				mlist.add(mr);
				SkillsReg s = sdao.save(sr);
				model.addAttribute("message", "Mapped Successfully");
				return "AdminHome";
			}
			
			
			@GetMapping(value="/batches")
			 public String batch(Model model) {
				Batch breg=new Batch();
				 model.addAttribute("batches",breg);
				 return "batchregistration";
			 }
			
		/*	@PostMapping(value="/batchreg")
			public String batchreg(@ModelAttribute("batches") Batch batch,Model model) {
				
				Batch b= bdao.save(batch);
				if(b!=null) {
				model.addAttribute("message","Skills Registered successfully.");
				return "SkillsReg";
				}else {
					model.addAttribute("message","Oops...Something went wrong.");
					return "failure";
				}
			}*/

			
			
			
			@GetMapping(value="/adminlogout")
			public String logout(HttpSession session) {
				session.invalidate();
				return "redirect:/";
			}

	}



