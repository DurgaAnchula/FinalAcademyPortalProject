package com.cts.Academyportal.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.Academyportal.Dao.AdminDao;
import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.ForgotUid;
@Service
@Component
public  class AdminServiceImpl implements AdminServices {

	@Autowired
	private AdminDao dao;
	/*@Override
	public Long CreateAdmin(AdminReg admin) {
		AdminReg a=dao.findByUserId(admin.getContactNumber());
		if(a==null) {
			AdminReg a1=dao.save(admin);
			if (a1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;

	}
	/*@Override
	public int login(AdminLogin adminlogin) {
		AdminReg a =dao.findByUserId(adminlogin.getUserId());
		//AdminReg ad = a.get();

		 if(a==null)
		 {
		   return 1;
		 }
		 else
		 {
		 return 2;
		 }
	}*/

	@Override
	public Long fid(ForgotUid fuid) {

		AdminReg a1=dao.findByContactNumber(fuid.getPhno());
		  if(a1!=null)
		  {
			int a2= a1.getSecretquestion1().compareTo(fuid.getQstn1());
			int a3= a1.getSecretquestion2().compareTo(fuid.getQstn2());
			int a4= a1.getSecretquestion3().compareTo(fuid.getQstn3());
			if((a2==0) && (a3==0) && (a4==0))
			{
				boolean a5=a1.getAnswer1().equalsIgnoreCase(fuid.getAns1());
				boolean a6=a1.getAnswer2().equalsIgnoreCase(fuid.getAns2());
				boolean a7=a1.getAnswer3().equalsIgnoreCase(fuid.getAns3());
				if((a5==true) &&(a6==true) && (a7==true))
				{
					return a1.getUserId();
				}
			}
		  }
		return null;
		}

	
	@Override
	public boolean fpwd(ForgotUid fuid) {
		AdminReg a1=dao.findByUserId(fuid.getUid());
		  if(a1!=null)
		  {
			int a2= a1.getSecretquestion1().compareTo(fuid.getQstn1());
			int a3= a1.getSecretquestion2().compareTo(fuid.getQstn2());
			int a4= a1.getSecretquestion3().compareTo(fuid.getQstn3());
			if((a2==0) && (a3==0) && (a4==0))
			{
				boolean a5=a1.getAnswer1().equalsIgnoreCase(fuid.getAns1());
				boolean a6=a1.getAnswer2().equalsIgnoreCase(fuid.getAns2());
				boolean a7=a1.getAnswer3().equalsIgnoreCase(fuid.getAns3());
				if((a5==true) &&(a6==true) && (a7==true))
				{
					return true;
				}
			}
		  }
		  return false;
		}


	}


