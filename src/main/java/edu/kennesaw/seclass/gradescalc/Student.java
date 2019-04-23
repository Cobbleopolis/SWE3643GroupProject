package edu.kennesaw.seclass.gradescalc;

/**
 * A class that represents a single student.
 */
public class Student {
	private String name;
	private int ID;
	private String email;
	
	/**
	 * Creates and setsup a Student class with a given name. Email,
	 * 
	 * @precondition name != null || name != .IsEmpty()
	 * @postcondition creates Student object
	 * @param name The name of the student
	 */
	public Student(String name) {
		if (name == null) {
			throw new IllegalArgumentException("Name is invalid");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Name is Empty");
		}
		
		this.name = name;
		this.ID = 0;
		this.email = "";
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
	public int getId() {
		return this.ID;
	}
	
	/**
	 * Sets the id of the student object
	 * @precondition email != null || !email.isEmpty()
	 * @postcondition email == email
	 * @param email the new email
	 */
	public void setId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException("Id cannot be negative");
		}
		id = this.ID;	
	}
	
}