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
		for (int i = 0; i < listEmployees.size(); i++) {
			if(listEmployees.get(i).getIdNV().equalsIgnoreCase(employeesNew.getIdNV())) {
				return false;
			}
		}
		listEmployees.add(employeesNew);
		return true;
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
	// Lấy danh sách nhân viên
	public ArrayList<Employees> getList() {
		return listEmployees;
	}
	// Lấy số lượng nhân viên
	public int numEmployees() {
		return listEmployees.size();
		
	}
	// Sữa thông tin nhân viên
	public boolean editEmployees(String idNV, String firstName, String lastNamel, String sex, int age, double salary) {
		Employees employees = new Employees(idNV, firstName, lastNamel, sex, age, salary);
		
		if(listEmployees.contains(employees)) {
			employees.setAge(age);
			employees.setFirstName(firstName);
			employees.setIdNV(idNV);
			employees.setLastNamel(lastNamel);
			employees.setSalary(salary);
			employees.setSex(sex);
			return true;
		}else {
			return false;
		}
	}
	// Kiểm tra sự tồn tại của nhân viên trong danh sách thông qua id
	public int searchID(String id) {
		int index = 0;
		for (Employees employees : listEmployees) {
			if(employees.getIdNV().equalsIgnoreCase(id)) {
				index = listEmployees.indexOf(employees); // lấy vị trí phần tử
			}
		}
		return index;
	}
}
