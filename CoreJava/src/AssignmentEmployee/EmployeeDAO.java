package AssignmentEmployee;

import java.util.List;

public interface EmployeeDAO {
	
	void save (Employee e);
	
	void update(Employee e);
	
	void delete(int id);
	
	List<Employee> getAll();
	
	Employee get(int id);

}
