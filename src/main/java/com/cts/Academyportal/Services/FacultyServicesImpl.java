package com.cts.Academyportal.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.Academyportal.Dao.ModuleDao;
import com.cts.Academyportal.Dao.SkillDao;
import com.cts.Academyportal.models.ModuleReg;
import com.cts.Academyportal.models.SkillsReg;
@Component
public class FacultyServicesImpl implements FacultyServices {

	@Autowired
	private SkillDao skillDao;
	@Override
	public List<SkillsReg> getAllSkills() {
		
		List<SkillsReg> skillList = new ArrayList<SkillsReg>();
		
		
		skillDao.findAll().forEach(t->{
			System.out.println(t);
			skillList.add(t);
		});
		return skillList;
	}

}
