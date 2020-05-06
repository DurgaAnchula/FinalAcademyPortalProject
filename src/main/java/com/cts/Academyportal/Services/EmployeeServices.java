package com.cts.Academyportal.Services;

import com.cts.Academyportal.models.ForgotUid;
import com.cts.Academyportal.models.Help;

public interface EmployeeServices {
	public Long fid(ForgotUid fuid);
	public boolean fpwd(ForgotUid fuid);
}
