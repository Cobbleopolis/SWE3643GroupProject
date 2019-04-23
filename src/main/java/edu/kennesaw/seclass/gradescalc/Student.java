package edu.kennesaw.seclass.gradescalc;

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
     * @param name The name of the student
     * @precondition name != null || name != .IsEmpty()
     * @postcondition creates Student object
     */
    public Student(String name, String id, String email, double C, double CPP, double Java, boolean CSEX) {
        IllegalArgumentExceptionMethods(name, email, C, CPP, Java);

        this.name = name;
        this.ID = "";
        this.email = "";
        this.C = C;
        this.CPP = CPP;
        this.Java = Java;
        this.CSEx = CSEX;
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
        if (C < 0) {
            throw new IllegalArgumentException("C cannot be less than 0");
        }
        if (CPP < 0) {
            throw new IllegalArgumentException("C cannot be less than 0");
        }
        if (Java < 0) {
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
     *
     * @return name the name of the student
     * @precondition none
     * @postcondition none
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the student object
     *
     * @param name the new name
     * @precondition name != null || !name.isEmpty()
     * @postcondition name == name
     */
    public void setName(String name) {
        name = this.name;
    }

    /**
     * Gets the email of the student
     *
     * @return email the email of the student
     * @precondition none
     * @postcondition none
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of the student object
     *
     * @param email the new email
     * @precondition email != null || !email.isEmpty()
     * @postcondition email == email
     */
    public void setEmail(String email) {
        email = this.email;
    }

    /**
     * Returns the id of the student object
     *
     * @return id The id of the student
     * @precondition none
     * @postcondition none
     */
    public String getId() {
        return this.ID;
    }

    /**
     * Sets the id of the student object
     *
     * @param id the new id
     * @precondition id != null || !id.isEmpty()
     * @postcondition id == id
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