package donghuns.dto;

public class Employee {
	private String code;
	private String name;
	private String grade;
	private int discntRate;
	
	public Employee() {}

	public Employee(String code, String name, String grade) {
		this.code = code;
		this.name = name;
		this.grade = grade;
	}

	public Employee(String code, String name, String grade, int discntRate) {
		this.code = code;
		this.name = name;
		this.grade = grade;
		this.discntRate = discntRate;
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

	public int getDiscntRate() {
		return discntRate;
	}

	public void setDiscntRate(int discntRate) {
		this.discntRate = discntRate;
	}

	@Override
	public String toString() {
		return String.format("Employee [code=%s, name=%s, grade=%s, discntRate=%s]", code, name, grade, discntRate);
	}
	
	
}
