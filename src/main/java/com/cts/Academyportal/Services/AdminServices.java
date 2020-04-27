package com.cts.Academyportal.Services;

import com.cts.Academyportal.models.AdminLogin;
import com.cts.Academyportal.models.AdminReg;

public interface AdminServices {
	public int login(AdminLogin adminlogin);
	public int CreateAdmin(AdminReg admin);
}
