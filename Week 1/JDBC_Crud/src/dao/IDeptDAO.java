package dao;

import java.util.*;

import entity.Department;

public interface IDeptDAO {
	public int insert(Department dept);
	
	public int update(Department dept);
	
	public int deleteOne(int dno);
	
	public Department selectOne(int dno);
	
	public List<Department> selectAll();
	
}
