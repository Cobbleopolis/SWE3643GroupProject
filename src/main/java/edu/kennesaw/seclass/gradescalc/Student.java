package src.main.java.edu.kennesaw.seclass.gradescalc;

/**
 * A class that represents a single student.
 */
public class Student {
	private String name;
	private String ID;
	private String email;
	private double C;
	private double CPP;
	private double Java;
	private boolean CSEx;
	/**
	 * Creates and setsup a Student class with a given name. Email,
	 * 
	 * @precondition name != null || name != .IsEmpty()
	 * @postcondition creates Student object
	 * @param name The name of the student
	 */
	public Student(String name, String id, String email, double C, double CPP, double Java, boolean CSEX ) {
		IllegalArgumentExceptionMethods(name, email, C, CPP, Java);
		
		this.name = name;
		this.ID = "";
		this.email = "";
		this.C = 0;
		this.CPP = 0;
		this.Java = 0;
		this.CSEx = false;
	}

	private void IllegalArgumentExceptionMethods(String name, String email, double C, double CPP, double Java) {
		if (name == null) {
			throw new IllegalArgumentException("Name is invalid");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name is Empty");
		}
		if (email == null) {
			throw new IllegalArgumentException("Email is invalid");
		}
		if (email.isEmpty()) {
			throw new IllegalArgumentException("Email is Empty");
		}
		if ( C < 0) {
			throw new IllegalArgumentException("C cannot be less than 0");
		}
		if ( CPP < 0) {
			throw new IllegalArgumentException("C cannot be less than 0");
		}
		if ( Java < 0) {
			throw new IllegalArgumentException("C cannot be less than 0");
		}
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getCPP() {
		return CPP;
	}

	public void setCPP(double cPP) {
		CPP = cPP;
	}

	public double getJava() {
		return Java;
	}

	public void setJava(double java) {
		Java = java;
	}

	public boolean isCSEx() {
		return CSEx;
	}

	public void setCSEx(boolean cSEx) {
		CSEx = cSEx;
	}

	/**
	 * Gets the name of the student
	 * @precondition none
	 * @postcondition none
	 * @return name the name of the student
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the name of the student object
	 * @precondition name != null || !name.isEmpty()
	 * @postcondition name == name
	 * @param name the new name
	 */
	public void setName(String name ) {
		name = this.name;	
	}
	
	/**
	 * Gets the email of the student
	 * @precondition none
	 * @postcondition none
	 * @return email the email of the student
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets the email of the student object
	 * @precondition email != null || !email.isEmpty()
	 * @postcondition email == email
	 * @param email the new email
	 */
	public void setEmail(String email ) {
		email = this.email;	
	}
	
	/**
	 * Returns the id of the student object
	 * @precondition none
	 * @postcondition none
	 * @return id The id of the student
	 */
	public String getId() {
		return this.ID;
	}
	
	/**
	 * Sets the id of the student object
	 * @precondition email != null || !email.isEmpty()
	 * @postcondition email == email
	 * @param email the new email
	 */
	public void setId(String id) {
		if (id == null) {
			throw new IllegalArgumentException("id is invalid");
		}
		if (id.isEmpty()) {
			throw new IllegalArgumentException("id is Empty");
		}
		
		id = this.ID;	
	}
	
}