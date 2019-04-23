package edu.kennesaw.seclass.gradescalc;

/**
 * A class that represents a single student.
 */
public class Student {
    /**
     * The name of the student.
     */
    private String name;

    /**
     * The name of the student.
     */
    private String id;

    /**
     * The email of the student.
     */
    private String email;

    /**
     * The C value of the student.
     */
    private double C;

    /**
     * The CPP value of the student.
     */
    private double CPP;

    /**
     * The Java value of the student.
     */
    private double Java;

    /**
     * The CSEX value of the student.
     */
    private boolean CSEX;

    /**
     * The GradesDB that this student is a part of.
     */
    private GradesDB gradesDB;

    /**
     * Creates and sets up a Student class.
     *
     * @param name     The name of the student.
     * @param id       The id of the student.
     * @param email    The email of the student.
     * @param C        The C value of the student.
     * @param CPP      The CPP value of the student.
     * @param Java     The Java value of the student.
     * @param CSEX     The CSEX value of the student.
     * @param gradesDB The GradesDB that the student is a part of.
     */
    public Student(String name, String id, String email, double C, double CPP, double Java, boolean CSEX, GradesDB gradesDB) {
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

        this.name = name;
        this.id = id;
        this.email = email;
        this.C = C;
        this.CPP = CPP;
        this.Java = Java;
        this.CSEX = CSEX;
        this.gradesDB = gradesDB;
    }

    /**
     * Gets the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student object.
     *
     * @param name The new name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the id of the student.
     *
     * @return The name of the student.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the student object.
     *
     * @param id The new id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the email of the student.
     *
     * @return The email of the student.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the student object.
     *
     * @param email the new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the C value of the student.
     *
     * @return The C value of the student.
     */
    public double getC() {
        return C;
    }

    /**
     * Sets the C value of the student.
     *
     * @param c The new C value of the student.
     */
    public void setC(double c) {
        this.C = c;
    }

    /**
     * Gets the CPP value of the student.
     *
     * @return The CPP value of the student.
     */
    public double getCPP() {
        return CPP;
    }

    /**
     * Sets the CPP value of the student.
     *
     * @param cpp The new CPP value of the student.
     */
    public void setCPP(double cpp) {
        this.CPP = cpp;
    }

    /**
     * Gets the Java value of the student.
     *
     * @return The Java value of the student.
     */
    public double getJava() {
        return Java;
    }

    /**
     * Sets the Java value of the student.
     *
     * @param java The new java value of the student.
     */
    public void setJava(double java) {
        this.Java = java;
    }

    /**
     * Gets the CSEX value of the student.
     *
     * @return The CSEX value of the student.
     */
    public boolean getCSEX() {
        return CSEX;
    }

    /**
     * Sets the CSEX value of the student.
     *
     * @param csex The new CSEX value of the student.
     */
    public void setCSEX(boolean csex) {
        this.CSEX = csex;
    }

    /**
     * Gets the student's attendance value from the database.
     *
     * @return The student's attendance from the database.
     */
    public double getAttendance() {
        return gradesDB.getStudentAttendance(getName());
    }
}