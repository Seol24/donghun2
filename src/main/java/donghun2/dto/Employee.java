package donghun2.dto;

public class Employee {
	private String code;
	private String name;
	private String grade;

	public Employee() {
	}

	public Employee(String code, String name, String grade) {
		this.code = code;
		this.name = name;
		this.grade = grade;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Employee(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s", code, name, grade);
	}

}
