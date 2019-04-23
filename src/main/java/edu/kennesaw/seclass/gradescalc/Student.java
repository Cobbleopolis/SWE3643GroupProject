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
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name ) {
		name = this.name;
		
	}
	

}