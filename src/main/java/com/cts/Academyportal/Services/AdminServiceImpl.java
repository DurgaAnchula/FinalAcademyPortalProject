package com.cts.Academyportal.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.Academyportal.Dao.AdminDao;
import com.cts.Academyportal.models.AdminLogin;
import com.cts.Academyportal.models.AdminReg;
@Component
public class AdminServiceImpl implements AdminServices {

	@Autowired
	private AdminDao dao;
	@Override
	public int CreateAdmin(AdminReg admin) {
		AdminReg a=dao.findByUserId(admin.getUserId());
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
	@Override
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
	}

}
