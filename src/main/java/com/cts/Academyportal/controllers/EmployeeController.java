package com.cts.Academyportal.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cts.Academyportal.Dao.BatchDao;
import com.cts.Academyportal.Dao.BatchRequestDao;
import com.cts.Academyportal.Dao.EmployeeDao;
import com.cts.Academyportal.Dao.FacultyDao;
import com.cts.Academyportal.Dao.ModuleDao;
import com.cts.Academyportal.Dao.SkillDao;
import com.cts.Academyportal.Services.EmployeeServices;
import com.cts.Academyportal.models.AdminLogin;
import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.Batch;
import com.cts.Academyportal.models.BatchNominationRequest;
import com.cts.Academyportal.models.EmployeeLogin;
import com.cts.Academyportal.models.EmployeeReg;
import com.cts.Academyportal.models.Faculty;
import com.cts.Academyportal.models.ForgotUid;
import com.cts.Academyportal.models.Help;
import com.cts.Academyportal.models.ModuleReg;
import com.cts.Academyportal.models.SkillsReg;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServices empservices;
	@Autowired
	private EmployeeDao dao;
	@Autowired
	private SkillDao sdao;
	@Autowired
	private FacultyDao fdao;
	@Autowired
	private BatchDao bdao;
	@Autowired
	private ModuleDao mdao;
	@Autowired
	private BatchRequestDao brdao;

	@GetMapping(value="/employee")
	 public String admin(Model model) {
		EmployeeReg reg=new EmployeeReg();
		 model.addAttribute("employee",reg);
		 return "EmployeeReg";
	 }
	@PostMapping(value="/employeereg")
	public String adminreg(@ModelAttribute("employee") EmployeeReg employeereg,Model model) {
		employeereg.setNominationStatus("no");
		employeereg.setStatus("no");
		EmployeeReg employee=dao.findByContactNumber(employeereg.getContactNumber());
		if(employee==null) {
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
		else {
			model.addAttribute("message","You already registered");
			return "EmployeeReg";
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

	@GetMapping("/forgotemployeeuid")
	public String fid(Model model){
		model.addAttribute("name",new ForgotUid());
		return "EmployeeUid";
	}
	@PostMapping("/forgotemployeeuid1")
	public String fid1(@ModelAttribute("name") ForgotUid fid,EmployeeReg employee,Model model)
	{
		Long b=empservices.fid(fid);
		if(b!=null)
		{
	  	model.addAttribute("message",b+" is your id");
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
		}
		return "EmployeeUid";
	}

	@GetMapping("/forgotemployeepswd")
	public String fpwd(Model model){
		model.addAttribute("name1",new ForgotUid());
		return "forgotemployeepwd";
	}
	@PostMapping("/forgotemployeepwd1")
	public String fpwd1(@ModelAttribute("name1") ForgotUid fid,Model model)
	{
		boolean b=empservices.fpwd(fid);
		if(b==true)
		{
	  	  return "resetemployeePwd";
		}
		else
		{
			model.addAttribute("message", "Incorrect credentials");
			return "forgotemployeepwd";
		}
	}
	@PostMapping("/updateemployeepwd")
	public String updatePassword(@ModelAttribute("name1") ForgotUid forgetUID,Model model)
	{
		EmployeeReg ad =dao.findById(forgetUID.getUid());
		ad.setPassword(forgetUID.getPwd());
		dao.save(ad);
		model.addAttribute("message","your password has been updated");
		return "resetemployeePwd";
	}


	
	@GetMapping("/employeelogout")
	public String adminLogOut(HttpSession session)
	{
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/skillsearch")
	public String search(Model model)
	{
		return "skillsearch";
	}
	
	@GetMapping("/search")
	public String search1(Model model, RedirectAttributes redirectAttributes,@RequestParam("bsearch") String bsearch,@RequestParam("advsearch") String advSearch,@RequestParam("searchKey") String sk)
	{
		System.out.println(bsearch +" :"+advSearch+" : "+sk);
		if(bsearch.equals("skill"))
		{
			List<SkillsReg> list = new ArrayList<SkillsReg>();
			
			if(advSearch.equals("skillname"))
			{
				sdao.findAll().forEach(t->{
					
					if(t.getSkillname().equalsIgnoreCase(sk))
					{
						list.add(t);
					}
				});

			}
			else if(advSearch.equals("skillfamily"))
			{
				sdao.findAll().forEach(t->{
					
					if(t.getSkillfamily().equalsIgnoreCase(sk))
					{
						list.add(t);
					}
				});

			}else
			{
				List<SkillsReg> skills = sdao.getAllskillsByName(sk);
				
				System.out.println(skills);
				List<ModuleReg> modules=new ArrayList<ModuleReg>();
				
				skills.forEach(t->{
					
					modules.addAll(t.getModules());
				});
				
				System.out.println(modules);
				
				redirectAttributes.addFlashAttribute("smlist", modules);
				return "redirect:/skillsearch";
			}

			
			System.out.println(list);
			redirectAttributes.addFlashAttribute("searchresult", list);
			return "redirect:/skillsearch";
		}
		else if(bsearch.equals("faculty"))
		{
			List<Faculty> list1 = new ArrayList<Faculty>();
			
			if(advSearch.equals("firstName"))
			{
				fdao.findAll().forEach(t->{
					
					if(t.getFirstName().equalsIgnoreCase(sk))
					{
						list1.add(t);
					}
				});

			}
			else if(advSearch.equals("lastName"))
			{
				fdao.findAll().forEach(t->{
					
					if(t.getLastName().equalsIgnoreCase(sk))
					{
						list1.add(t);
					}
				});

			}
			List<Faculty> finalList = new ArrayList<>();
			
			list1.stream().filter(t->t.getStatus().equalsIgnoreCase("yes")).forEach(t->{finalList.add(t);});
			System.out.println(list1);
			System.out.println("Final List"+finalList);
			redirectAttributes.addFlashAttribute("searchresult1", finalList);
			return "redirect:/skillsearch";

		}
	
		else if(bsearch.equals("batch"))
		{

			System.out.println("Batch Search");
			List<Batch> list1 = null;
			
			if(advSearch.equals("startdate"))
			{
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				
				Date startDate = null;
				try
				{
				
					startDate = new Date(dateformat.parse(sk).getTime());
					System.out.println("Start Date  is :"+startDate);
				}catch (Exception e) {

                     e.printStackTrace();
				}
				
				 list1 = bdao.findByBatchStartDate(startDate);
				System.out.println(list1);
				
				
			}
			else if(advSearch.equals("batchEndDate"))
			{
				
				SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				
				Date endDate = null;
				try
				{
				
				endDate = new Date(dateformat.parse(sk).getTime());
					System.out.println("End Date  is :"+endDate);
				}catch (Exception e) {

                     e.printStackTrace();
				}
				
				 list1 = bdao.findByBatchStartDate(endDate);
				System.out.println(list1);
				

				
			}

			List<Batch> finalList = new ArrayList<>();
			
			list1.stream().filter(t->t.getStatus().equalsIgnoreCase("yes")).forEach(t->{finalList.add(t);});
			System.out.println(list1);
			System.out.println("Final List"+finalList);
			redirectAttributes.addFlashAttribute("searchresult2", finalList);
			return "redirect:/skillsearch";
		}
		else if(bsearch.equals("module"))
		{
			List<ModuleReg> list1 = new ArrayList<ModuleReg>();
			
			if(advSearch.equals("proficiencylevel"))
			{
				mdao.findAll().forEach(t->{
					
					if(t.getProficiencylevel().equalsIgnoreCase(sk))
					{
						list1.add(t);
					}
				});

			}
			else if(advSearch.equals("technology"))
			{
				mdao.findAll().forEach(t->{
					
					if(t.getTechnology().equalsIgnoreCase(sk))
					{
						list1.add(t);
					}
				});

			}

			System.out.println(list1);
			redirectAttributes.addFlashAttribute("searchresult3",list1);
			return "redirect:/skillsearch";
		}

				return "redirect:/skillsearch";
	}

	@GetMapping(value="/logout1")
	public String Logout() {
		return "EmployeeHome";
	}

	
	
	@GetMapping("/enrollforbatch")
	public String naminatetobatch(Model model,RedirectAttributes redirects,@RequestParam("bid") int bid,HttpSession session)
	{
		Batch batch=bdao.findById(bid);
		if(batch.getCurrentBatchCapacity()<=batch.getBatchCapacity())
		{
			long employeeid = (long) session.getAttribute("name");
			
			BatchNominationRequest br = new BatchNominationRequest();
			EmployeeReg employee = dao.findById(employeeid);
			br.setBatchid(batch.getBatchId());
			br.setEmpid(employee.getUserId());
			br.setStatus("no");
			
			Set<Batch> batches = employee.getBatches();
			int currentCapacity = batch.getCurrentBatchCapacity();
			//batch.setCurrentBatchCapacity(currentCapacity+1);
			batches.add(batch);
			dao.save(employee);
			brdao.save(br);
			redirects.addFlashAttribute("nm", "Batch is nominated successfully wait for admin confirmation");
			
		}
		else
		{
			redirects.addFlashAttribute("nm", "Batch is full");
		}
		return "redirect:/skillsearch";

	}
	
}
