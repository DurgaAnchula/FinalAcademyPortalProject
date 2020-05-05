package com.cts.Academyportal.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cts.Academyportal.Dao.BatchDao;
import com.cts.Academyportal.Dao.FacultyDao;
import com.cts.Academyportal.Dao.SkillDao;
import com.cts.Academyportal.Services.FacultyServices;
import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.Batch;
import com.cts.Academyportal.models.EmployeeLogin;
import com.cts.Academyportal.models.EmployeeReg;
import com.cts.Academyportal.models.Faculty;
import com.cts.Academyportal.models.FacultyLogin;
import com.cts.Academyportal.models.ForgotUid;
import com.cts.Academyportal.models.SkillsReg;

@Controller
@CrossOrigin(origins = {"192.168.43.130"})
public class FacultyController {
	@Autowired
	private FacultyServices facultyServices;
	@Autowired
	private FacultyDao fdao;
	@Autowired
	private BatchDao bdao;
	@Autowired
	private SkillDao sdao;
	String str="";
	@GetMapping("/faculty")
     public String   facutyRegistrationForm(Model model)
     {
	     List<SkillsReg> skillslist = facultyServices.getAllSkills();
	     
	     
		Set<String> skillfamily= new HashSet<String>();
		
		skillslist.forEach(t->{
		 skillfamily.add(t.getSkillfamily());
		});
    	 
    	Faculty faculty = new Faculty(); 
    	System.out.println(skillfamily);
    	
    	model.addAttribute("skillsList", skillslist);
    	model.addAttribute("skillfamily",skillfamily);
    	model.addAttribute("faculty", faculty);
    	
    	return "FacultyReg";
    	 
     }
	@PostMapping(value="/facultyreg")
	public String facultyreg(@ModelAttribute("faculty") Faculty faculty,Model model) {
		
	faculty.setStatus("no");
	Faculty facultyreg=fdao.findByContactNumber(faculty.getContactNumber());
	if(facultyreg==null) {

		Faculty f= fdao.save(faculty);
		if(f!=null) {
		model.addAttribute("message","Your details are submitted successfully.");
		model.addAttribute("msg","your userid is: "+f.getUserId());
		return "FacultyReg";
		}else {
			model.addAttribute("message","Oops...Something went wrong.");
			return "failure";
		}
	}		else {
		model.addAttribute("message","You already registered");
		return "FacultyReg";
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

	@GetMapping("/forgotfacultyuid")
	public String fid(Model model){
		model.addAttribute("name",new ForgotUid());
		return "FacultyUid";
	}
	@PostMapping("/forgotfacultyuid1")
	public String fid1(@ModelAttribute("name") ForgotUid fid,Faculty faculty,Model model)
	{
		Long b=facultyServices.fid(fid);
		if(b!=null)
		{
	  	model.addAttribute("message",b+" is your id");
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return "FacultyUid";
	}

	@GetMapping("/forgotfacultypswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "forgotfacultypwd";
	}
	@PostMapping("/forgotfacultypwd1")
	public String fpwd1(@ModelAttribute("name1") ForgotUid fid,Model model)
	{
		boolean b=facultyServices.fpwd(fid);
		if(b==true)
		{
	  	  return "resetfacultyPwd";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "forgotfacultypwd";
		}
	}
	@PostMapping("/updatefacultypwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
		Faculty faculty =fdao.findById(forgetUID.getUid());
		faculty.setPassword(forgetUID.getPwd());
		fdao.save(faculty);
		model.addAttribute("message","your password has been updated");
		return "resetfacultyPwd";
	}
	@GetMapping(value="/batchreq1")
	public String req1(Model model,HttpSession session) {
		
		long userid = (long)session.getAttribute("name");
		List<Batch> list = bdao.findByFacultyId(userid);
		
		model.addAttribute("list",list);
		return "batchreq";
	}
	
	
	@GetMapping(value="/batchaccept1")
	public String acceptreq1(@RequestParam("name") int name,Model model) {
		Batch b=bdao.findById(name);
		String status=b.getStatus();
		b.setStatus("yes");
		bdao.save(b);
		return "FacultyHome";
	}
	
	@GetMapping(value="/batchreject1")
	public String rejectreq1(@RequestParam("name") int name,Model model) {
      Batch b1=bdao.findById(name);
      String status=b1.getStatus();
      b1.setStatus("no");
      bdao.save(b1);
		
		return "FacultyHome";
	}


	
	
	@GetMapping("/facultylogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}

	
	@RequestMapping(value="/getskillNames",method = RequestMethod.GET)
	public @ResponseBody String getKkillNames(HttpServletRequest request,HttpServletResponse res)
	{
		 str="";
		List<String> skillnamelist = sdao.getSkillNamesBySkillFamily(request.getParameter("q"));
		System.out.println(skillnamelist);
		
		
		
		skillnamelist.forEach(t->{
			
			str+="<input type='checkbox' value='"+t+"' name='skillname'>"+t;
		});
		/*
		 * String str="<input type='checkbox' value='Java' name='skillname'>"+"JAVA";
		 * String str1="<input type='checkbox' value='dotnet'>"+"DOTNET";
		 */
		return str;
	}

}
