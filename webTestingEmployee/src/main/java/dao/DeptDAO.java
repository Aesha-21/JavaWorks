package dao;

import java.util.Set;

public interface DeptDAO {
	
	Dept first();
	Dept last();
	Dept next(int id);
	Dept previous(int id);
	
	void save(Dept dept);
	void update(Dept dept);
	void delete (int id);
	Dept getDept(int id);
	
	void showDept(int id);
	Set<Dept> getAll();
	

}