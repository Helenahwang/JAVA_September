package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DeptMapper;
import vo.DeptTransaction;

@Service
public class DeptService {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@Transactional
	public void insertdept() {
		DeptTransaction dept = new DeptTransaction();
		dept.setDeptno(12);
		dept.setDname("회계");
		dept.setLoc("광주");
		
		deptMapper.insertdept(dept);
		deptMapper.insertdept(dept);
		
	}

}
