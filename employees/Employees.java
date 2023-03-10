package employees;

import java.util.Objects;

public class Employees {
	
	private String idNV; // id là string
	private String firstName;
	private String lastNamel;
	private String sex;
	private int age ;
	private double salary;
	
	//constructor
	public Employees(String idNV) {
		this(idNV, "","", "", 0, 0.0);
	}
	public Employees(String idNV, String firstName, String lastNamel, String sex, int age, double salary) {
		super();
		this.idNV = idNV;
		this.firstName = firstName;
		this.lastNamel = lastNamel;
		this.sex = sex;
		this.age = age;
		this.salary = salary;
	}

	//get / set
	public String getIdNV() {
		return idNV;
	}

	public void setIdNV(String idNV) {
		this.idNV = idNV;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastNamel() {
		return lastNamel;
	}
	public void setLastNamel(String lastNamel) {
		this.lastNamel = lastNamel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	// tostring
	@Override
	public String toString() {
		return "Employees [idNV=" + idNV + ", firstName=" + firstName + ", lastNamel=" + lastNamel + ", sex=" + sex
				+ ", age=" + age + ", salary=" + salary + "]";
	}
	
	// hashcode
	@Override
	public int hashCode() {
		return Objects.hash(idNV);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employees other = (Employees) obj;
		return Objects.equals(idNV, other.idNV);
	}	
}