package springTx;

import java.util.List;

public interface EmployeeService {

	void save(Employee e);

	void update(Employee e);

	void delete(int id);

	List<Employee> getAll();

	Employee get(int id);

	void sortByOrder(String s);

}