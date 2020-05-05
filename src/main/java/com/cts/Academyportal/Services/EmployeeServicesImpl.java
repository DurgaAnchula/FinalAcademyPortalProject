package com.cts.Academyportal.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cts.Academyportal.Dao.AdminDao;
import com.cts.Academyportal.Dao.EmployeeDao;
import com.cts.Academyportal.models.AdminReg;
import com.cts.Academyportal.models.EmployeeReg;
import com.cts.Academyportal.models.ForgotUid;


@Service
@Component
public class EmployeeServicesImpl implements EmployeeServices {

	
	@Autowired
	private EmployeeDao dao;

	
	@Override
	public Long fid(ForgotUid fuid) {

		EmployeeReg a1=dao.findByContactNumber(fuid.getPhno());
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

		EmployeeReg a1=dao.findById(fuid.getUid());
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
