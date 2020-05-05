package com.cts.Academyportal.Services;

import java.util.List;

import com.cts.Academyportal.models.ForgotUid;
import com.cts.Academyportal.models.SkillsReg;

public interface FacultyServices {
	public List<SkillsReg> getAllSkills();
	public boolean fpwd(ForgotUid fuid);
	public Long fid(ForgotUid fuid);


}
