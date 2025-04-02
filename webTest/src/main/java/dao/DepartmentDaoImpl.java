package dao;

import java.sql.Connection;
import java.util.*;

public class DepartmentDaoImpl implements DeptDAO {
	
	
	private Map<Integer, Dept> depts; 
	
	public DepartmentDaoImpl() {
		depts = new HashMap<Integer, Dept>();
	}

	public void save(Dept dept) {
		
		depts.put(dept.getId(), dept);
	}
	
	public void update(Dept dept) {
		
		depts.put(dept.getId(), dept);
		
	}
	
	public Dept getDept(int id) {
		return depts.get(id);
	}
	
	
	public void delete(int id) {
		depts.remove(id);
	}
	
	
	
	public Set<Dept> getAll(){
		Set<Dept> all = new HashSet<Dept>();
		for(int id: depts.keySet()) {
			all.add(depts.get(id));
		}
		return getAll();
	}

	@Override
	public Dept first() {
		return depts.get(depts.keySet().stream().min((a,b) -> (a-b)).get());
	}

	@Override
	public Dept last() {
		
		return depts.get(depts.keySet().stream().max((a,b)->(a-b)).get());

	}

	@Override
	public Dept next(int id) {
		if(id == depts.size()) return depts.get(depts.size());
		return depts.get(id+1);
	}

	@Override
	public Dept previous(int id) {
		if(id == 1) return getDept(1);
		return depts.get(id-1);
	}

	@Override
	public void showDept(int id) {
//		try(){
//			
//		}catch{
//			
//		}
		
	}

	
	


}
