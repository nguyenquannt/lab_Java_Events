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
	/*
	public boolean editEmployees(String idNV) {
		//Employees employees = new Employees(idNV, firstName, lastNamel, sex, age, salary);
		
		if(listEmployees.getcontains(employees)) {
			employees.setAge(age);
			employees.setFirstName(firstName);
			employees.setIdNV(idNV);
			employees.setLastNamel(lastNamel);
			employees.setSalary(salary);
			employees.setSex(sex);
			return employees;
		}else {
			return null;
		}
	}
	*/
	public boolean editEmployees(Employees employeeEdit) {
		for (Employees employees : listEmployees) {
			if(employees.getIdNV().equalsIgnoreCase(employeeEdit.getIdNV())) {
				employees.setFirstName(employeeEdit.getFirstName());
				employees.setLastNamel(employeeEdit.getLastNamel());
				employees.setAge(employeeEdit.getAge());
				employees.setSalary(employeeEdit.getSalary());
				employees.setSex(employeeEdit.getSex());
				return true;
			}
		}
		return false;
	}
	// Kiểm tra sự tồn tại của nhân viên trong danh sách thông qua id
	
	public int searchID(String id) {
		int index = -1;
		for (Employees employees : listEmployees) {
			if(employees.getIdNV().equalsIgnoreCase(id)) {
				index = listEmployees.indexOf(employees); // lấy vị trí phần tử
			}
		}
		return index;
	}
	/*
	public Employees searchID(String idSearch) {
		for (Employees employees : listEmployees) {
			if(employees.getIdNV().equalsIgnoreCase(idSearch)) {
				return employees;
			}
		}
		return null;
	}
	*/
}

