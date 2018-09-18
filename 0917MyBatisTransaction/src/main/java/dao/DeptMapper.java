package dao;

import org.apache.ibatis.annotations.Insert;

import vo.DeptTransaction;

public interface DeptMapper {
	
	@Insert("insert into dept values(#{deptno}, #{dname}, #{loc})")
	public int insertdept(DeptTransaction dept);

}
