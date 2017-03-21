package donghun2.dto;


public class Customer {
	
	public static final int L = 4;
	public static final int M = 3;
	public static final int S = 2;
	
	private String code;
	private String name;
	private String grade;
	
	private Customer() {}
	
	public Customer(String code, String name) {
		this.code = code;
		this.name = name;
	}
	public Customer(String code, String name, String grade) {
		this.code = code;
		this.name = name;
		this.grade = grade;
	}
	
	public static int getL() {
		return L;
	}

	public static int getM() {
		return M;
	}

	public static int getS() {
		return S;
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
	
	@Override
	public String toString() {
		return String.format("Customer [code=%s, name=%s]", code, name);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}
	public String[] toArray() {
		return new String[] {code, name, grade};
	}
	
}

