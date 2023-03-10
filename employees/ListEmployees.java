package employees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListEmployees {

	public ArrayList<Employees> listEmployees;
	
	//GET SET
	public ArrayList<Employees> getListEmployees() {
		return listEmployees;
	}

	public void setListEmployees(ArrayList<Employees> listEmployees) {
		this.listEmployees = listEmployees;
	}
	// constructor hông thám só gọi hàm set
	public ListEmployees() {
		super();
		setListEmployees(new ArrayList<Employees>());
	}
	// Thêm nhân viên
	public boolean addEmployees(Employees employeesNew) {
		if(!listEmployees.contains(employeesNew)) {
			listEmployees.add(employeesNew);
			return true;
		}else {
			return false;
		}
	}
	// xóa nhân viên theo vị trí
	public boolean delEmployees(int index) {
		if(index >=0 && index <= listEmployees.size()-1) {
			listEmployees.remove(index);
			return true;
		}else {
			return false;
		}
	}
public Employees searchEmployees(String idNV) {
	for(Employees employees : listEmployees) {
		if(employees.getIdNV().equalsIgnoreCase(idNV)) {
			return employees;
		}
	}
	return null;
}	
}
