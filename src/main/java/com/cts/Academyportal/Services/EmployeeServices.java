package com.cts.Academyportal.Services;

import com.cts.Academyportal.models.ForgotUid;

public interface EmployeeServices {
	public Long fid(ForgotUid fuid);
	public boolean fpwd(ForgotUid fuid);

}
